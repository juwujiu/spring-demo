package demo.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.dao.Test2Dao;
import demo.dao.TryDao;
import demo.entity.TestBean;
import demo.utils.ExcelUtil;

/**
 * 功能描述：TODO 增加描述代码功能
 * @逻辑说明：TODO 增加描述代码逻辑
 * @牵涉到的配置项：TODO 如果代码中逻辑中牵涉到配置项在这里列出
 * @编码实现人员 lWX605537
 * @需求提出人员 TODO 填写需求提出人员
 * @实现日期 2018年12月20日
 * @版本 TODO 填写版本
 * @修改历史 TODO 新建的时候留空 修改的时候为格式：什么人 什么时候 因为什么 修改了什么 编码实现人员： 需求提出人员： 实现日期： 版本：
 *       修改内容： ------------------------------------------------
 */
@RestController
public class T01Controller
{
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private TryDao tryDao;
    @Autowired
    private Test2Dao test2Dao;

    @GetMapping("/test3")
    public Map<Integer, Integer> test3()
    {
        Map<Integer, Integer> map1 = new HashMap<>();
        map1.put(1, 11);
        map1.put(2, 22);
        map1.put(3, 33);
        return map1;
    }

    @GetMapping("/test4")
    public Date test4()
    {
        return tryDao.test();
    }

    @PostMapping("/test1")
    public String test1(TestBean testBean)
    {
        List<TestBean> infos = new ArrayList<>();
        infos.add(testBean);

        ExcelUtil<TestBean> excel = new ExcelUtil<>();
        // 设置Excel表头
        LinkedHashMap<String, String> headerField = new LinkedHashMap<String, String>();
        // 项目
        headerField.put("id", "id");
        // 环境
        headerField.put("status", "status");

        // 设置excel页签名称
        Map<String, String> param = new HashMap<String, String>();
        String sheetName = "\u7528\u6237\u9884\u7ea6\u8bb0\u5f55";
        param.put("sheetName", sheetName);
        param.put("reqType", "exportAppointmentRecord");
        param.put("pattern", "yyyy-MM-dd HH:mm");
        response.setHeader("Connection", "close");
        response.setHeader("Content-Type", "application/vnd.ms-excel;charset=utf-8");
        // 设置excel文件名
        String fileName = "AppointmentRecord.xlsx";
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        try
        {
            excel.exportExcel(headerField, infos, response.getOutputStream(), param);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return "成功";
    }

    @PostMapping("/test3")
    public String test3(long time)
    {
        TimeZone tz = TimeZone.getTimeZone("ETC/GMT-8");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.setTimeZone(tz);
        return df.format(time);
    }

    /**
     * 截屏并显示
     * @author cutter
     * @date 2018年12月20日
     * @return String
     */
    @GetMapping("/cut")
    public String cut()
    {
        return "success";
    }

    @GetMapping("/download")
    public String download()
    {
        try
        {
            request.setCharacterEncoding("UTF-8");
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;

            // 获取项目根目录
            String ctxPath = request.getSession().getServletContext().getRealPath("");
            // 获取下载文件路径
            String downLoadPath = "D:/image/20190327/142541.png";
            // 获取文件的长度
            long fileLength = new File(downLoadPath).length();
            // 设置文件输出类型
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment; filename=1.xml");
            // 设置输出长度
            response.setHeader("Content-Length", String.valueOf(fileLength));
            // 获取输入流
            bis = new BufferedInputStream(new FileInputStream(downLoadPath));
            // 输出流
            bos = new BufferedOutputStream(response.getOutputStream());
            byte[] buff = new byte[2048];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length)))
            {
                bos.write(buff, 0, bytesRead);
            }
            // 关闭流
            bis.close();
            bos.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return "success";
    }

}
