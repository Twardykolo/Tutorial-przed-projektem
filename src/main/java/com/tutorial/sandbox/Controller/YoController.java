package com.tutorial.sandbox.Controller;

import com.tutorial.sandbox.DTO.Response.YoResponse;
import com.tutorial.sandbox.Service.YoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/yo")
public class YoController {
    @Autowired
    private YoService yoService;

    @GetMapping("/{numer}")
    public ResponseEntity<YoResponse> getYo(@PathVariable("numer") String numer){
        return ResponseEntity.ok(yoService.getForecast(numer));
    }
}
