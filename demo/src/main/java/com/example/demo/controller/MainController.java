package com.example.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping(value = "/project.js", produces = "application/javascript")
    public String getProjectJs() throws IOException {
        StringBuilder sb = new StringBuilder();

        Path jsFolder = Paths.get("src/main/resources/static/js");

        try (Stream<Path> stream = Files.walk(jsFolder)) {
            stream
                .filter(Files::isRegularFile)
                .filter(p -> p.toString().endsWith(".js"))
                .sorted()
                .forEach(p -> {
                    try {
                        sb.append(Files.readString(p)).append("\n");
                    } catch (IOException ignored) {}
                });
        }

        return sb.toString();
    }
}
