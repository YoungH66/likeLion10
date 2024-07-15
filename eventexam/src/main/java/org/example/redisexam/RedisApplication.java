package org.example.redisexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class RedisApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

    @Autowired
    PersonService personService;
    @Autowired
    RedisService redisService;

    @Override
    public void run(String... args) throws Exception {
        Person person = new Person();
        person.setId("yh");
        person.setName("Younghun");
        person.setAge(26);

//        personService.savePerson(person);
//
//        Optional<Person> yh = personService.getPersonById("yh");
//        System.out.println(yh.get().getName());
//
//        Iterable<Person> allPerson = personService.getAllPersons();
//        allPerson.forEach(System.out::println);

        // RedisService의 이용
        String key = "yh";
        String value = "{\"name\":\"Younghun\",\"age\":26}";    //{"name" : "yh" , "age" : 26}

        redisService.saveJsonWithTTL(key,value, 20);
        String retrieveValue = redisService.getJson(key);
        System.out.println("Retrieved JSON: " + retrieveValue);

        Thread.sleep(21000);

        retrieveValue = redisService.getJson((key));
        System.out.println("Retrieved JSON: " + retrieveValue);
    }
}
