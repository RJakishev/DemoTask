package com.demotask.decathlon.controller;

import com.demotask.decathlon.dto.ResultDTO;
import com.demotask.decathlon.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/result")
public class ResultController {

    @Autowired
    private ResultService resultService;

    public ResultController(){
    }

    @PostMapping
    public ResultDTO create(@RequestBody ResultDTO resultDTO) {
        return save(resultDTO);
    }

    @PutMapping()
    public ResultDTO update(@RequestBody ResultDTO resultDTO) {
        return save(resultDTO);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") int id){
        resultService.delete(id);
    }

    @GetMapping("{id}")
    public ResultDTO getById(@PathVariable int id) {
        return resultService.getDTOById(id);
    }

    @GetMapping("/athlet/{athletId}/list")
    public List<ResultDTO> getAllByAthletId(@PathVariable("athletId") int athletId) {
        return resultService.getAllDOsByAthleteId(athletId);
    }

    @GetMapping("/athlet/{athletId}/sum")
    public Double getPointSumByAthletId(@PathVariable("athletId") int athletId) {
        return resultService.getPointSumByAthleteId(athletId);
    }

    @GetMapping()
    public List<ResultDTO> getAll() {
        return resultService.getAllDTOs();
    }

    private ResultDTO save(ResultDTO resultDTO) {
        return resultService.save(resultDTO);
    }
}