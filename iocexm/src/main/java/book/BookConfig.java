package book;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BookConfig {

    @Bean
    public Book book() {
        return new Book();
    }

    @Bean
    public Book book2() {
        return new Book("Spring", 200000);
    }

    @Bean
    public Book book3() {
        return new Book("HowToMake", 300000);
    }

    @Bean
    @Scope("prototype")
    public Book book4() {
        return new Book("Prototype", 400000);
    }
}
