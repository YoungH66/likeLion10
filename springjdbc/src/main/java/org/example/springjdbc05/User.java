package org.example.springjdbc05;

import lombok.*;

//@Getter
@Setter
@ToString
//@NoArgsConstructor
//@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private String email;

//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                '}';
//    }
}
