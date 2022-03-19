package com.tutorial.sandbox.Service;
import com.tutorial.sandbox.DTO.Request.CheeseRequest;
import com.tutorial.sandbox.DTO.Response.CheeseResponse;
import com.tutorial.sandbox.Entity.Cheese;
import com.tutorial.sandbox.Repository.CheeseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CheeseService {

    @Autowired
    private CheeseRepository cheeseRepo;

    public List<CheeseResponse> getAllCheese() {
        return cheeseRepo.findAll().stream()
                .filter(Cheese::getIsNotEaten)
                .map(CheeseResponse::new)
                .collect(Collectors.toList());
    }

    public CheeseResponse getCheese(Long cheeseId){
        Cheese cheese = cheeseRepo.getOne(cheeseId);
        return new CheeseResponse(cheese);
    }

    public CheeseResponse createCheese(CheeseRequest cheeseRequest){
        Cheese cheese = Cheese.builder()
                .name(cheeseRequest.getName())
                .amount(cheeseRequest.getAmount())
                .isNotEaten(cheeseRequest.getIsNotEaten())
                .ratto(cheeseRequest.getRatto())
                .creationDate(new Date())
                .build();
        Cheese savedCheese =cheeseRepo.save(cheese);
        CheeseResponse zwrotka = new CheeseResponse(savedCheese);
        return zwrotka;
    }

    public CheeseResponse updateCheese(CheeseRequest cheeseRequest, Long id){
        Cheese cheese = cheeseRepo.getOne(id);
        cheese.setName(cheeseRequest.getName());
        cheese.setAmount(cheeseRequest.getAmount());
        cheese.setRatto(cheeseRequest.getRatto());
        cheese.setIsNotEaten(cheeseRequest.getIsNotEaten());

        Cheese savedCheese = cheeseRepo.save(cheese);
        return new CheeseResponse(savedCheese);
    }

    public void deleteCheese(Long id){
        Cheese cheese = cheeseRepo.getOne(id);
        cheeseRepo.delete(cheese);
    }
}