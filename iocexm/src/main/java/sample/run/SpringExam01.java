package sample.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sample.bean.MyBean;
import sample.config.MyBeanConfig;

public class SpringExam01 {
    public static void main(String[] args) {
        // 직접 사용하는 경우
//        MyBean bean = new MyBean();
//        bean.setName("Kim");
//
//        System.out.println(bean);

        // 스프링 ioc container를 이용할 경우
        // 객체를 내가 생성하지 않고 스프링이 만들어준다.
        // 스프링 컨테이너에게 알려줘야 함
        // 1. 에노테이션으로 알려줌 <- 컴포넌트 스캔 해야함
        // 2. 자바파일을 통해서 알려줌

        // BeanFactory  -- 빈을 생성하는데 간단한 기능만 포함하고 있다. aop같은 기술을 사용할 수 없다.
        // ApplicationContext 사용. 공장이 생성될때 어떤 빈을 생성해야 할지 결정(MyBeanConfig.class)
        System.out.println("ApplicationContext 생성전...");
        ApplicationContext context = new AnnotationConfigApplicationContext(MyBeanConfig.class);
        System.out.println("ApplicationContext 생성후...");
        MyBean bean1 = (MyBean)context.getBean("myBean");   //lookup 방식, id를 알려줌


        bean1.setName("YH");
        System.out.println(bean1);

//        MyBean bean2 = context.getBean(MyBean.class);   // id를 알려주지 않고, 타입만 알려줌
         MyBean bean2 = context.getBean("myBean2", MyBean.class);  // id도 같이 넘겨줄수 있다.
        bean2.setName("extra");
        System.out.println(bean2);
        // bean1이 bean2로 덮어씌어 졌다.
        // 기본은 싱글턴이기 때문에 getBean으로 리턴해온 대상이 값은 값이다.
        // myBean2를 새로 만들어서 해결 가능
        System.out.println(bean1);

        // 같은 인스턴스이다.
        if(bean1==bean2)
            System.out.println("same..");
        else System.out.println("different..");

        MyBean bean3 = context.getBean("myBean", MyBean.class);
        if(bean3 == bean1)
            System.out.println("same..");
        else System.out.println("different..");

        // 같이 myBean3로 했지만, scope를 prototype으로 했더니 결과가 달라짐.
        MyBean bean4 = context.getBean("myBean3", MyBean.class);
        bean4.setName("proto");

        MyBean bean5 = context.getBean("myBean3", MyBean.class);
        bean5.setName("proto2");

        System.out.println(bean4);
        System.out.println(bean5);
        // 3. xml을 통해서 알려줌  <- 현재는 많이 사용하지 않음.
    }
}
