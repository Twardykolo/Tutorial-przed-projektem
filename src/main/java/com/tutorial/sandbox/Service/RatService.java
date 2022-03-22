package com.tutorial.sandbox.Service;

import com.tutorial.sandbox.DTO.Request.RatRequest;
import com.tutorial.sandbox.DTO.Response.RatResponse;
import com.tutorial.sandbox.Entity.Rats.Rat;
import com.tutorial.sandbox.Repository.Rats.RatRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

@Service
public class RatService {

    @Autowired
    private RatRepository ratRepo;

    public List<RatResponse> getAllRats() {
        return ratRepo.findAll().stream()
                                        .filter(Rat::getIsAlive)
                                        .map(RatResponse::new)
                                        .collect(Collectors.toList());
    }

    public RatResponse getRat(Long ratId){
        Rat rat = ratRepo.getOne(ratId);
        return new RatResponse(rat);
    }

    public RatResponse createRat(RatRequest ratRequest){
        Rat rat = Rat.builder()
                .name(ratRequest.getName())
                .age(ratRequest.getAge())
                .isAlive(ratRequest.getIsAlive())
                .creationDate(new Date())
                .build();
        Rat savedRat =ratRepo.save(rat);
        RatResponse zwrotka = new RatResponse(savedRat);
        return zwrotka;
    }

    public RatResponse updateRat(RatRequest ratRequest, Long id){
        Rat rat = ratRepo.getOne(id);
        rat.setName(ratRequest.getName());
        rat.setAge(ratRequest.getAge());
        rat.setIsAlive(ratRequest.getIsAlive());

        Rat savedRat = ratRepo.save(rat);
        return new RatResponse(savedRat);
    }

    public void deleteRat(Long id){
        Rat rat = ratRepo.getOne(id);
        ratRepo.delete(rat);
    }
}
