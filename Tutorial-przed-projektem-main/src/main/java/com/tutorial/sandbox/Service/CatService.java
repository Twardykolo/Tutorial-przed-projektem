package com.tutorial.sandbox.Service;

import com.tutorial.sandbox.DTO.Request.CatRequest;
import com.tutorial.sandbox.DTO.Response.CatResponse;
import com.tutorial.sandbox.Entity.Rats.Cat;
import com.tutorial.sandbox.Repository.Rats.CatRepository;
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
public class CatService {
    @Autowired
    private CatRepository catRepo;

    public List<CatResponse> getAllCats() {
        return catRepo.findAll().stream().map(CatResponse::new).collect(Collectors.toList());
    }

    public CatResponse getCat(Long catId){
        Cat cat = catRepo.getOne(catId);
        return new CatResponse(cat);
    }

    public CatResponse createCat(CatRequest catRequest){
        Cat cat = Cat.builder().
                name(catRequest.getName())
                .age(catRequest.getAge())
                .numberOfRats(catRequest.getNumberOfRats())
                .creationDate(new Date())
                .build();
        Cat catWithTrophy = catRepo.save(cat);
        CatResponse zwracanie = new CatResponse(catWithTrophy);
        return zwracanie;
    }

    public CatResponse updateCat(CatRequest catRequest, Long id){
        Cat cat = catRepo.getOne(id);
        cat.setName(catRequest.getName());
        cat.setAge(catRequest.getAge());

        Cat catWithTrophy = catRepo.save(cat);
        return new CatResponse(catWithTrophy);
    }

    public void deleteCat(Long id){
        Cat cat = catRepo.getOne(id);
        catRepo.delete(cat);
    }
}
