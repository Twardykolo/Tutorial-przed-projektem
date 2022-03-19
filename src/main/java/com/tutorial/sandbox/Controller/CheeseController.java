package com.tutorial.sandbox.Controller;


import com.tutorial.sandbox.DTO.Request.CheeseRequest;
import com.tutorial.sandbox.DTO.Response.CheeseResponse;
import com.tutorial.sandbox.Service.CheeseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cheese")
public class CheeseController {
    @Autowired
    private CheeseService cheeseService;

    @GetMapping("/cheese")
    public ResponseEntity<List<CheeseResponse>> getCheese(){
        return ResponseEntity.ok(cheeseService.getAllCheese());
    }

    @GetMapping("/cheese/{id}")
    public ResponseEntity<CheeseResponse> getCheese(@PathVariable("id") Long id){
        return ResponseEntity.ok(cheeseService.getCheese(id));
    }

    @PostMapping("/cheese")
    public ResponseEntity<CheeseResponse> createCheese(@RequestBody CheeseRequest cheeseRequest){
        return ResponseEntity.ok(cheeseService.createCheese(cheeseRequest));
    }

    @PutMapping("/cheese/{id}")
    public ResponseEntity<CheeseResponse> updateCheese(@RequestBody CheeseRequest cheeseRequest, @PathVariable("id") Long id){
        return ResponseEntity.ok(cheeseService.updateCheese(cheeseRequest,id));
    }

    @DeleteMapping("/cheese/{id}")
    public ResponseEntity<Void> deleteCheese(@PathVariable Long id){
        cheeseService.deleteCheese(id);
        return ResponseEntity.ok().build();
    }
}