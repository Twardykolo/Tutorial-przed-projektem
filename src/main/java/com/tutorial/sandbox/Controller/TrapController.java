package com.tutorial.sandbox.Controller;

import com.tutorial.sandbox.DTO.Request.TrapRequest;
import com.tutorial.sandbox.DTO.Response.TrapResponse;
import com.tutorial.sandbox.Service.TrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trappi")
public class TrapController {

    @Autowired
    private TrapService trapService;

    @GetMapping("/trap")
    public ResponseEntity<List<TrapResponse>> getTraps(){
        return ResponseEntity.ok(trapService.getAllTraps());
    }


    @GetMapping("/trap/{id}")
    public ResponseEntity<TrapResponse> getTrap(@PathVariable("id") Long id){
        return ResponseEntity.ok(trapService.getTrap(id));
    }

    @PostMapping("/trap")
    public ResponseEntity<TrapResponse> createTrap(@RequestBody TrapRequest trapRequest){
        return ResponseEntity.ok(trapService.createTrap(trapRequest));
    }

    @PutMapping("/trap/{id}")
    public ResponseEntity<TrapResponse> updateTrap(@RequestBody TrapRequest trapRequest, @PathVariable("id") Long id){
        return ResponseEntity.ok(trapService.updateTrap(trapRequest,id));
    }

    @DeleteMapping("/trap/{id}")
    public ResponseEntity<Void> deleteTrap(@PathVariable Long id){
        trapService.deleteTrap(id);
        return ResponseEntity.ok().build();
    }

}
