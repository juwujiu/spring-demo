package demo.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import demo.dao.Test2Dao;
import demo.dao.TryDao;
import demo.service.KafkaService;
import lombok.extern.java.Log;

/**
 * 功能描述：TODO 增加描述代码功能
 * @编码实现人员 cutter
 * @实现日期 2018年12月20日
 */
@Log
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
    @Autowired
    private KafkaService kafkaService;

    @RequestMapping(value = "/test5", produces = {"application/json"}, method = RequestMethod.POST)
    public Date test5(@RequestBody MultipartFile file, @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "version", required = false) String version)
    {
        if (file == null || file.isEmpty())
        {
            System.out.println("上传失败");
        }
        String fileName = file.getOriginalFilename();
        String filePath = "d://uploadFile/";
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists())
        {
            dest.getParentFile().mkdirs();
        }
        try
        {
            file.transferTo(dest);
            System.out.println("上传成功");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("--------------");
        return new Date();
    }

    @GetMapping("/test6")
    public String test6()
    {
        // 声明Connection对象
        Connection con;
        // 驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        // URL指向要访问的数据库名mydata
        String url = "jdbc:mysql://localhost:3306/test";
        // MySQL配置时的用户名
        String user = "root";
        // MySQL配置时的密码
        String password = "root";
        // 遍历查询结果集
        String id = null;
        try
        {
            // 加载驱动程序
            Class.forName(driver);
            // 1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            // 2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            // 要执行的SQL语句
            String sql = "select * from t1";
            // 3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next())
            {
                id = rs.getString("id");
                System.out.println(id);
            }
            System.out.println("--------------");
            sql = "select * from t2";
            // 3.ResultSet类，用来存放获取的结果集！！
            rs = statement.executeQuery(sql);
            while (rs.next())
            {
                id = rs.getString("id");
                System.out.println(id);
            }
            rs.close();
            con.close();
        }
        catch (ClassNotFoundException e)
        {
            // 数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            // 数据库连接失败异常处理
            e.printStackTrace();
        }
        catch (Exception e)
        {
            // TODO: handle exception
            e.printStackTrace();
        }
        finally
        {
            System.out.println("数据库数据成功获取！！");
        }
        return id;
    }

    @GetMapping("/test3")
    public Map<Integer, Integer> test3()
    {
        Map<Integer, Integer> map1 = new HashMap<>();
        map1.put(1, 11);
        map1.put(2, 22);
        map1.put(3, 33);
        log.info("完成");
        return map1;
    }

    @PostMapping("/test4")
    public Date test4(@RequestBody String info, @RequestBody MultipartFile file)
    {
        String fileName = file.getOriginalFilename();
        String filePath = "/uploadFile/";
        File dest = new File(filePath + fileName);
        try
        {
            file.transferTo(dest);
            System.out.println("上传成功");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return new Date();
    }

    @PostMapping("/test3")
    public String test3(String msg)
    {
        kafkaService.sendChannelMess("seckill", msg);
        return msg;
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
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;
            // 获取下载文件路径
            String downLoadPath = "D:/image/20190327/142541.png";
            // 获取文件的长度
            long fileLength = new File(downLoadPath).length();
            // 设置文件输出类型
            // response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;fileName*=utf-8'zh_cn'" + "46565.txt");
            response.setContentType("application/x-download");
            response.setCharacterEncoding("UTF-8");
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
