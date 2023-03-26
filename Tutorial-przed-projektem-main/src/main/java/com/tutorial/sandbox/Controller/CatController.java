package com.tutorial.sandbox.Controller;

import com.tutorial.sandbox.DTO.Request.CatRequest;
import com.tutorial.sandbox.DTO.Response.CatResponse;
import com.tutorial.sandbox.Service.CatService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/catpi")
public class CatController {

    @Autowired
    private CatService catService;

    @GetMapping("/cat")
    public ResponseEntity<List<CatResponse>> getCats(){
        return ResponseEntity.ok(catService.getAllCats());
    }

    @GetMapping("/cat/{id}")
    public ResponseEntity<CatResponse> getCat(@PathVariable("id") Long id){
        return ResponseEntity.ok(catService.getCat(id));
    }

    @PostMapping("/cat")
    public ResponseEntity<CatResponse> createCat(@RequestBody CatRequest catRequest){
        return ResponseEntity.ok(catService.createCat(catRequest));
    }

    @PutMapping("/cat/{id}")
    public ResponseEntity<CatResponse> updateCat(@RequestBody CatRequest catRequest, @PathVariable("id") Long id){
        return ResponseEntity.ok(catService.updateCat(catRequest,id));
    }

    @DeleteMapping("/cat/{id}")
    public ResponseEntity<Void> deleteCat(@PathVariable Long id){
        catService.deleteCat(id);
        return ResponseEntity.ok().build();
    }
}