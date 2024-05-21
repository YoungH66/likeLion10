package org.example.springmvc.controller;

import org.example.springmvc.domain.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {
    @GetMapping("/form")
    public String showForm(Model model){
        model.addAttribute("userForm", new UserForm());
        return "form";
    }

    @PostMapping("/submitForm")
    public String submitForm(@ModelAttribute("userForm") UserForm userForm, BindingResult result){
        if(result.hasErrors()){
            return "form";
        }
        System.out.println(userForm.getUsername() + " :: " + userForm.getPassword());
        return "result";
    }
}
