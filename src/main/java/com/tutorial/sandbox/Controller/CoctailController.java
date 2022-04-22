package com.tutorial.sandbox.Controller;

import com.tutorial.sandbox.DTO.Response.CoctailResponse;
import com.tutorial.sandbox.Service.CoctailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coctail")
public class CoctailController {
    @Autowired
    private CoctailService coctailService;

    @GetMapping("/{drink}")
    public ResponseEntity<CoctailResponse> getCoctail(@PathVariable("drink") String drink){
        return ResponseEntity.ok(coctailService.getCoctail(drink));
    }
}
