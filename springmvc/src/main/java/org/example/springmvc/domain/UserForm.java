package org.example.springmvc.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
public class UserForm {
    @NotEmpty(message = "Username cannot be Empty")
    @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
    private String username;

    @NotEmpty(message = "Password cannot be Empty")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;
}
