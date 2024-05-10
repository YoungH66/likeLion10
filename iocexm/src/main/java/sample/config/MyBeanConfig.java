package sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import sample.bean.MyBean;

// ApplicationContext에서 직접 썻기때문에 @Configuration을 하지 않아도 동작했지만, 직접 쓰지 않으면 에너테이션을 해주어야 함.
@Configuration
public class MyBeanConfig {
    // <bean id="myBean" class="sample.bean.MyBean"/>
    @Bean
    public MyBean myBean(){
        return new MyBean();
    }

    @Bean
    public MyBean myBean2(){
        return new MyBean();
    }

    @Bean
    @Scope("prototype")
    public MyBean myBean3(){
        return new MyBean();
    }

    @Bean
    public MyBean myBean4(){
        return new MyBean("whatis..", 10);
    }
}
