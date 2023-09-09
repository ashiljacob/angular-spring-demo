package com.example.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> postName(@RequestBody(required = false) String body){
        System.out.println(body);

        if (body == null || body.isEmpty()) {
            return ResponseEntity.badRequest().body("Bad Requset , Name Is Empty ");
        }else {

            int index = random.nextInt(greetingList.size());
            String response = "Hello " + body + "  ," + greetingList.get(index);
            System.out.println(body);

            return ResponseEntity.ok().body(response);
        }
    }

}
