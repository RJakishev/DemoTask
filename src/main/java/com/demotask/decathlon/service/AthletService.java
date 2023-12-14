package com.demotask.decathlon.service;

import com.demotask.decathlon.dto.AthletDTO;
import com.demotask.decathlon.model.Athlet;
import com.demotask.decathlon.repository.AthletRepository;
import com.demotask.decathlon.util.factory.AthletFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AthletService {

    @Autowired
    private AthletRepository athletRepository;

    @Lazy
    @Autowired
    private AthletFactory athletFactory;

    public void delete(int id) {
        athletRepository.deleteById(id);
    }

    public AthletDTO save(AthletDTO athletDTO) {
        return athletFactory.toDto(save(athletFactory.toEntity(athletDTO)));
    }

    public Athlet save(Athlet athlet) { return athletRepository.save(athlet); }

    public AthletDTO getDTOById(int id) { return athletFactory.toDto(getById(id)); }

    public Athlet getById(int id) { return athletRepository.findById(id).orElse(null); }

    public List<AthletDTO> getAllDTOs() { return athletFactory.toDto(getAll()); }

    public List<Athlet> getAll() { return athletRepository.findAll(); }
}
