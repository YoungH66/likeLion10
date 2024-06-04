package org.example.restexam.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/memos")
public class MemoRestController {
    private final Map<Long, String> memos = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    @PostMapping
    public ResponseEntity<Long> createMemo(@RequestBody String content){
        // id는 원래 서비스에서 담당했을거임..
        Long id = counter.incrementAndGet();
        memos.put(id, content);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getMemo(@PathVariable("id") Long id){
        String s = memos.get(id);
        if(s == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(s);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMemo(@PathVariable("id") Long id, @RequestBody String content){
        if(!memos.containsKey(id)){
            return ResponseEntity.notFound().build();
        }
        memos.put(id, content);
        return ResponseEntity.ok("Updated Memo");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMemo(@PathVariable("id") Long id){
        if(!memos.containsKey(id)){
            return ResponseEntity.notFound().build();
        }
        memos.remove(id);
        return ResponseEntity.ok("Deleted Memo");
    }
}
