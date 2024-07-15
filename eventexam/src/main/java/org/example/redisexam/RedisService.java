package org.example.redisexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class RedisService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // TTL (time to Live)
    public void saveJsonWithTTL(String key, String json, long ttlInseconds){
        redisTemplate.opsForValue().set(key, json, Duration.ofSeconds(ttlInseconds));
    }

    public String getJson(String key){
        return (String)redisTemplate.opsForValue().get(key);
    }
}
