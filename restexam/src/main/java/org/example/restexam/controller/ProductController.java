package org.example.restexam.controller;

import org.apache.coyote.Response;
import org.example.restexam.domain.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final Map<Long, Product> products = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    // 추가
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        Long id = counter.incrementAndGet();
        product.setId(id);
        products.put(id, product);
        return product;
    }

    // 조회
    @GetMapping("/{id}")
    public ResponseEntity<String> getProduct(@PathVariable("id") Long id) {
        if(!products.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(products.get(id).getName());
    }

    // 전체 조회
    @GetMapping
    public List<Product> getProducts() {
        return new ArrayList<>(products.values());
    }

    // 수정
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        if(!products.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        product.setId(id);
        products.put(id, product);
        return ResponseEntity.ok("Updated product");
    }

    // 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
        if(!products.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        products.remove(id);

        return ResponseEntity.ok("Deleted product with id " + id);
    }

}
