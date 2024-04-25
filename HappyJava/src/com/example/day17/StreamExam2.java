package com.example.day17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamExam2 {
    public static void main(String[] args) {
        Path path = Paths.get("src/com/example/");
        // 한 줄로 얻어오는거면 Files.lines로 받아오면 되는데 path로 얻어오는거라 Files.list로 받음
        try (Stream<Path> stream = Files.list(path);){
            stream.forEach(p -> System.out.println(p.getFileName()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n=========================\n");

        try(Stream<String> stream = Files.lines(Paths.get("src/com/example/test.java"));){
            stream.forEach(p -> System.out.println(p));
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
