package demo.utils;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.security.Key;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.ibatis.mapping.ParameterMapping;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Base64Utils;

/**
 * 【通用实体bena】每一个需要加密的bean实体，都必须继承此类
 * @author CSDN博客：seesun2012
 */
public abstract class CommonEntity implements Serializable
{

    private static final long serialVersionUID = 0L;

    private static final String Algorithm = "DESede";
    private static final byte[] key = "6T8SA4N0I3U4C9J8A7SI8A9XJ13A6V5M8S".getBytes();
    // 表名一律大写
    private static final String[] STR_TAB_ARR = "T_USER_INFO,T_PAY_INFO".split(","); // 后期将改成@注解注在Bean头部
    private static final String[] STR_COL_ARR = "idCard,panAccount".split(","); // 后期将改成@注解注在属性名上

    /**
     * 需要加密的参数（可在具体业务对应bean子类中重写）
     */
    public String[] getEncryptionArr()
    {
        String strArr = "IdCard,PanAccount";
        return strArr.split(",");
    }

    /**
     * myBatis执行回调函数
     */
    public Object myBatisCallBack(String stemType) throws Exception
    {
        return toDecrypt(stemType, getEncryptionArr());
    };

    /**
     * 回调JavaBean加密函数
     * @param obj 实体对象
     * @param stemType 操作类型
     */
    public static Object skill(Object obj, String stemType) throws Exception
    {
        if (CommonEntity.class.equals(obj.getClass().getSuperclass()))
        {
            return obj.getClass().getSuperclass().getDeclaredMethod("myBatisCallBack", String.class).invoke(obj, stemType);
        }
        if (CommonEntity.class.equals(obj.getClass().getSuperclass().getSuperclass()))
        {
            return obj.getClass().getSuperclass().getSuperclass().getDeclaredMethod("myBatisCallBack", String.class).invoke(obj, stemType);
        }
        return obj.getClass().getSuperclass().getSuperclass().getDeclaredMethod("myBatisCallBack", String.class).invoke(obj, stemType);
    }

    /**
     * 加密/解密
     */
    public Object toDecrypt(String stemType, String[] columnArr) throws Exception
    {
        switch (stemType.toUpperCase())
        {
            case "QUERY":
                setEDValue(columnArr, "dc");
                break;
            case "SELECT":
                setEDValue(columnArr, "dc");
                break;
            case "UPDATE":
                setEDValue(columnArr, "ec");
                break;
            case "INSERT":
                setEDValue(columnArr, "ec");
                break;
            case "DELETE":
                setEDValue(columnArr, "ec");
                break;
        }
        return this;
    }

    public void setEDValue(String[] columnArr, String edType) throws Exception
    {
        PropertyDescriptor ps = null;
        if ("ec".equals(edType))
        { // 加密
            for (int i = 0, len = columnArr.length; i < len; i++)
            {
                ps = BeanUtils.getPropertyDescriptor(this.getClass(), columnArr[i]);
                if (ps != null && ps.getReadMethod() != null && ps.getWriteMethod() != null)
                {
                    if (!isEmpty(ps.getReadMethod().invoke(this)))
                    {
                        ps.getWriteMethod().invoke(this, des3EncodeECB(String.valueOf(ps.getReadMethod().invoke(this))));
                    }
                }
            }
        }
        if ("dc".equals(edType))
        { // 解密
            for (int i = 0, len = columnArr.length; i < len; i++)
            {
                ps = BeanUtils.getPropertyDescriptor(this.getClass(), columnArr[i]);
                if (ps != null && ps.getReadMethod() != null && ps.getWriteMethod() != null)
                {
                    if (!isEmpty(ps.getReadMethod().invoke(this)))
                    {
                        ps.getWriteMethod().invoke(this, des3DecodeECB(ps.getReadMethod().invoke(this).toString()));
                    }
                }
            }
        }
    }

    /**
     * 加密增删改查回调参数（回调）
     * @param paramObj 要加密的参数对象
     * @param paramNames 字段bean对应属性名
     * @param parameterMappings
     * @param sqlType
     * @return
     * @throws Throwable
     */
    @SuppressWarnings({ "unchecked" })
    public static Object processColumn(Object paramObj, List<ParameterMapping> parameterMappings, String sqlType) throws Throwable
    {
        if (paramObj == null)
        {
            return paramObj;
        }
        if (paramObj instanceof CommonEntity)
        {
            skill(paramObj, sqlType);
            return paramObj;
        }
        Map<String, Object> paramMap = null;
        for (ParameterMapping map : parameterMappings)
        {
            if (checkColumn(map.getProperty()))
            {
                if (paramObj instanceof HashMap<?, ?>)
                {
                    paramMap = (Map<String, Object>) paramObj;
                    paramMap.put(map.getProperty(),
                            isEmpty(paramMap.get(map.getProperty())) ? null : des3EncodeECB(paramMap.get(map.getProperty()).toString()));
                    return paramObj;
                }
                if (paramObj instanceof String)
                {
                    paramObj = isEmpty(paramObj) ? null : des3EncodeECB(paramObj.toString());
                    return paramObj;
                }
                else
                {
                    return paramObj;
                }
            }
        }
        return paramObj;
    }

    /**
     * ECB加密,不要IV（禁止修改）
     * @param key 密钥
     * @param data 明文
     * @return Base64编码的（密文）
     */
    public static String des3EncodeECB(String data)
    {
        if (data == null)
        {
            return null;
        }
        try
        {
            Key deskey = null;
            DESedeKeySpec spec = new DESedeKeySpec(key);
            SecretKeyFactory keyfactory = SecretKeyFactory.getInstance(Algorithm);
            deskey = keyfactory.generateSecret(spec);
            Cipher cipher = Cipher.getInstance(Algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, deskey);
            byte[] bOut = cipher.doFinal(data.getBytes());
            return Base64Utils.encodeToString(bOut);
        }
        catch (Exception e)
        {
            return data;
        }
    }

    /**
     * ECB解密,不要IV（禁止修改）
     * @param key 密钥
     * @param data Base64编码的密文（明文）
     */
    public static String des3DecodeECB(String data)
    {
        if (data == null)
        {
            return null;
        }
        try
        {
            Key deskey = null;
            DESedeKeySpec spec = new DESedeKeySpec(key);
            SecretKeyFactory keyfactory = SecretKeyFactory.getInstance(Algorithm);
            deskey = keyfactory.generateSecret(spec);
            Cipher cipher = Cipher.getInstance(Algorithm);
            cipher.init(Cipher.DECRYPT_MODE, deskey);
            byte[] bOut = cipher.doFinal(Base64Utils.decode(data.getBytes()));
            return new String(bOut);
        }
        catch (Exception e)
        {
            return data;
        }
    }

    public static boolean checkTable(String sql)
    {
        sql = sql.toUpperCase();
        for (String tab : STR_TAB_ARR)
        {
            if (sql.indexOf(tab) >= 0)
                return true;
        }
        return false;
    }

    public static boolean checkColumn(String column)
    {
        column = column.toLowerCase();
        for (String col : STR_COL_ARR)
        {
            if (column.equals(col))
                return true;
        }
        return false;
    }

    public static boolean isEmpty(Object str)
    {
        return (str == null || "".equals(str));
    }

}
