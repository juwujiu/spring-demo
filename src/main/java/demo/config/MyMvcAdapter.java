// package demo.config;
//
// import org.springframework.context.annotation.Configuration;
// import
// org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
// import
// org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
/// *****
// * 功能描述：静态资源路由--该方法在spring5.0已被废弃,不推荐使用*
// * @逻辑说明：TODO 增加描述代码逻辑
// * @牵涉到的配置项：TODO 如果代码中逻辑中牵涉到配置项在这里列出
// * @编码实现人员 cutter
// * @需求提出人员 TODO 填写需求提出人员
// * @实现日期 2018年12月6日
// * @版本 TODO 填写版本
// * @修改历史 TODO 新建的时候留空 修改的时候为格式：什么人 什么时候 因为什么 修改了什么 编码实现人员： 需求提出人员： 实现日期： 版本：
// * 修改内容： ------------------------------------------------
// */
// @SuppressWarnings("deprecation")
// @Configuration
// public class MyMvcAdapter extends WebMvcConfigurerAdapter
// {
// /**
// * 配置静态访问资源
// * @param registry
// */
// @Override
// public void addResourceHandlers(ResourceHandlerRegistry registry)
// {
// registry.addResourceHandler("/s/**").addResourceLocations("file:D:/resources/");
// super.addResourceHandlers(registry);
// }
// }