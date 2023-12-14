package com.demotask.decathlon.controller;

import com.demotask.decathlon.dto.AthletDTO;
import com.demotask.decathlon.service.AthletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/athlet")
public class AthletController {

    @Autowired
    private AthletService athletService;

    public AthletController(){
    }

    @PostMapping
    public AthletDTO create(@RequestBody AthletDTO athletDTO) {
        return save(athletDTO);
    }

    @PutMapping()
    public AthletDTO update(@RequestBody AthletDTO athletDTO) {
        return save(athletDTO);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") int id){
        athletService.delete(id);
    }

    @GetMapping("{id}")
    public AthletDTO getById(@PathVariable int id) {
        return athletService.getDTOById(id);
    }

    @GetMapping()
    public List<AthletDTO> getAll() {
        return athletService.getAllDTOs();
    }

    private AthletDTO save(AthletDTO athletDTO) {
        return athletService.save(athletDTO);
    }
}