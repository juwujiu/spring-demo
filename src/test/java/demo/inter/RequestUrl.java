package demo.inter;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // 元注解，标记该注解作用范围
@Retention(RetentionPolicy.RUNTIME) //// 元注解，标记该注解生命周期
@Documented // 元注解，标记生成javadoc时解释说明该注解
public @interface RequestUrl
{
// 定义网络URL类型为String
String value() default "";// 默认请求网址为空

}
