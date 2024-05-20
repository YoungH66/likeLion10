package org.example.springmvc.controller;

import org.example.springmvc.domain.Item;
import org.example.springmvc.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.event.ItemEvent;
import java.util.*;

@Controller
public class ExamController {

    @GetMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("welcomeMsg", "Welcome to Spring MVC");
        List<Item> items = Arrays.asList(
                new Item("pen", 3000),
                new Item("notebook", 50000),
                new Item("cup", 2500)
        );

        model.addAttribute("items", items);

        return "welcome";
    }

    // Product를 적절히 정의하고
    private List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1, "Apple", 1.20),
            new Product(2, "Banana", 0.75),
            new Product(3, "Cherry", 2.05)
    ));
    // url = /products 요청하면 응답되도록...
    // products를 이용해서 상품 목록이 출력되도록...
    @GetMapping("/products")
    public String products(Model model) {
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/example")
    public String example(Model model) {
        model.addAttribute("username", "yh");
        model.addAttribute("isAdmin", true);
        model.addAttribute("language", new String[]{"English", "Spanish", "German"});

        return "exam";
    }

}
