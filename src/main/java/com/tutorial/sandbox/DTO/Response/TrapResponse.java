package com.tutorial.sandbox.DTO.Response;

import com.tutorial.sandbox.Entity.Rats.Trap;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrapResponse {
    private Long id;
    private Boolean isTaken;
    private Date catchDate;
    private Double xVal;
    private Double yVal;

    public TrapResponse(Trap trap){
        this.id=trap.getId();
        this.catchDate=trap.getCatchDate();
        this.xVal=trap.getXVal();
        this.yVal=trap.getYVal();
        this.isTaken=trap.getIsTaken();
    }
}
