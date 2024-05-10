package book;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BookDemo {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BookConfig.class);
        Book book = context.getBean("book",Book.class);
        book.setTitle("Java");
        book.setPrice(10000);
        System.out.println("Book Title : " + book.getTitle());
        System.out.println("Book Price : " + book.getPrice());

        Book book2 = context.getBean("book2", Book.class);
        Book book3 = context.getBean("book3", Book.class);
        System.out.println(book2);
        System.out.println(book3);

        Book book4 = context.getBean("book4", Book.class);
        Book book5 = context.getBean("book4", Book.class);
        book4.setTitle("proto1");
        book5.setTitle("proto2");
        System.out.println(book4);
        System.out.println(book5);
    }
}
