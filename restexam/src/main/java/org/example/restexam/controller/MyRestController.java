package org.example.restexam.controller;

import org.example.restexam.domain.Product;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MyRestController {
    @GetMapping("/api/greeting")
    public Map<String, String> greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello " + name + "!");

        return response;
    }

    // json
    @GetMapping(value = "/productjson/{id}", produces = "application/json")
    public Product getProduct(@PathVariable("id") Long id){
        return new Product(id, "Example Product", 9.89);
    }

    // xml
    @GetMapping(value = "/productxml/{id}", produces = "application/xml")
    public Product getProductAsXml(@PathVariable("id") Long id){
        return new Product(id, "Example Product", 9.89);
    }
}
