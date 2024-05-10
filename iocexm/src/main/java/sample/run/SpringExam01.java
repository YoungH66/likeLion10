package sample.run;

import sample.bean.MyBean;

public class SpringExam01 {
    public static void main(String[] args) {
        // 직접 사용하는 경우
        MyBean bean = new MyBean();
        bean.setName("Kim");

        System.out.println(bean);

        // 스프링 ioc container를 이용할 경우
        // 스프링 컨테이너에게 알려줘야 함
        // 1. 에노테이션으로 알려줌 <- 컴포넌트 스캔 해야함
        // 2. 자바파일을 통해서 알려줌
        // 3. xml을 통해서 알려줌  <- 현재는 많이 사용하지 않음.
    }
}
