package com.tutorial.sandbox.Service;

import com.tutorial.sandbox.DTO.Request.TrapRequest;
import com.tutorial.sandbox.Entity.Rats.Trap;
import com.tutorial.sandbox.DTO.Response.TrapResponse;
import com.tutorial.sandbox.Repository.Rats.TrapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Date;


@Service
public class TrapService {

    @Autowired
    private TrapRepository trapRepo;

    public List<TrapResponse> getAllTraps() {
        return trapRepo.findAll().stream()
                .filter(Trap::getIsTaken)
                .map(TrapResponse::new)
                .collect(Collectors.toList());
    }

    public TrapResponse getTrap(Long trapId) {
        Trap trap = trapRepo.getById(trapId);
        return new TrapResponse(trap);
    }

    public TrapResponse createTrap(TrapRequest trapRequest){
        Trap trap = Trap.builder()
                .xVal(trapRequest.getXVal())
                .yVal(trapRequest.getYVal())
                .isTaken(trapRequest.getIsTaken())
                .catchDate(new Date())
                .build();
        Trap savedTrap =trapRepo.save(trap);
        TrapResponse zwrotka = new TrapResponse(savedTrap);
        return zwrotka;
    }

    public TrapResponse updateTrap(TrapRequest trapRequest, Long id){
        Trap trap = trapRepo.getById(id);
        trap.setXVal(trapRequest.getXVal());
        trap.setYVal(trapRequest.getYVal());
        trap.setIsTaken(trapRequest.getIsTaken());

        Trap savedTrap = trapRepo.save(trap);
        return new TrapResponse(savedTrap);
    }

    public void deleteTrap(Long id){
        Trap trap = trapRepo.getById(id);
        trapRepo.delete(trap);
    }
}
