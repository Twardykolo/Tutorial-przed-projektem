package com.tutorial.sandbox.Controller;

import com.tutorial.sandbox.DTO.Request.RatRequest;
import com.tutorial.sandbox.DTO.Response.RatResponse;
import com.tutorial.sandbox.Service.RatService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/rats")
public class RatController {

    @Autowired
    private RatService ratService;

    @GetMapping
    public ResponseEntity<List<RatResponse>> getRats(){
        return ResponseEntity.ok(ratService.getAllRats());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RatResponse> getRat(@PathVariable("id") Long id){
        return ResponseEntity.ok(ratService.getRat(id));
    }

    @PostMapping
    public ResponseEntity<RatResponse> createRat(@RequestBody RatRequest ratRequest){
        return ResponseEntity.ok(ratService.createRat(ratRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RatResponse> updateRat(@RequestBody RatRequest ratRequest, @PathVariable("id") Long id){
        return ResponseEntity.ok(ratService.updateRat(ratRequest,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRat(@PathVariable Long id){
        ratService.deleteRat(id);
        return ResponseEntity.ok().build();
    }
}