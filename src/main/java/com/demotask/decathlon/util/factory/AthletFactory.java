package com.demotask.decathlon.util.factory;

import com.demotask.decathlon.dto.AthletDTO;
import com.demotask.decathlon.model.Athlet;
import com.demotask.decathlon.service.AthletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AthletFactory {

    private static final Logger log = LoggerFactory.getLogger(AthletFactory.class);

    @Autowired
    private AthletService athletService;

    public AthletFactory(){
    }

    public AthletDTO toDto(Athlet athlet) {

        if (athlet == null) {
            return null;
        }

        log.debug("Converting Athlet entity to DTO.");

        AthletDTO athletDTO = new AthletDTO();

        athletDTO.setId(athlet.getId());
        if(athlet.getFirstname() != null) athletDTO.setFirstname(athlet.getFirstname());
        if(athlet.getLastname() != null) athletDTO.setLastname(athlet.getLastname());

        return athletDTO;
    }
      
    public Athlet toEntity(AthletDTO athletDTO) {

        if (athletDTO == null) {
            return null;
        }

        log.debug("Converting AthletDTO to athlet.");

        Athlet athlet = athletService.getById(athletDTO.getId());

        if(athlet == null) athlet = new Athlet();

        if(athletDTO.getFirstname() != null){
            String firstname = athletDTO.getFirstname().isBlank() ? null : athletDTO.getFirstname();
            athlet.setFirstname(firstname);
        }
        if(athletDTO.getFirstname() != null){
            String lastname = athletDTO.getLastname().isBlank() ? null : athletDTO.getLastname();
            athlet.setLastname(lastname);
        }

        return athlet;
    }

    public List<AthletDTO> toDto(List<Athlet> athlets){

        List<AthletDTO> athletDTOs = new ArrayList<>();

        for (Athlet athlet : athlets) {
            athletDTOs.add(toDto(athlet));
        }

        return athletDTOs;
    }
}