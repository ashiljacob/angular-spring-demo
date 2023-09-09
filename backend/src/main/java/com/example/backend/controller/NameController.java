package com.example.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
public class NameController {

    private final Random random;

    List<String> greetingList = Arrays.asList("how are you?",
                                            "what's the news today?",
                                            "nice meeting you! ",
                                            "hope you're doing well!");

    @PostMapping
    public String postName(@RequestBody String body){

        int index = random.nextInt(greetingList.size());
        String response = greetingList.get(index) + " " + body;

        return response;
    }

}
