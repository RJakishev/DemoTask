package com.demotask.decathlon.service;

import com.demotask.decathlon.dto.ResultDTO;
import com.demotask.decathlon.model.Event;
import com.demotask.decathlon.model.Result;
import com.demotask.decathlon.repository.ResultRepository;
import com.demotask.decathlon.util.factory.ResultFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    private static final Logger log = LoggerFactory.getLogger(ResultService.class);

    @Lazy
    @Autowired
    private ResultFactory resultFactory;

    @Autowired
    private ResultRepository resultRepository;

    public void delete(int id) {
        resultRepository.deleteById(id);
    }

    public ResultDTO save(ResultDTO resultDTO) {
        return resultFactory.toDto(save(resultFactory.toEntity(resultDTO)));
    }

    public Result save(Result result) {
        if (result == null) {
            String msg = "Cannot save Result. Result is NULL";
            log.error(msg);
            throw new RuntimeException(msg);
        }

        if (result.getAthlet() == null) {
            String msg = "Cannot save Result. Athlet in result is NULL";
            log.error(msg);
            throw new RuntimeException(msg);
        }

        if (result.getEvent() == null) {
            String msg = "Cannot save Result. Event in result is NULL";
            log.error(msg);
            throw new RuntimeException(msg);
        }

        if (result.getPoints() == null) {
            String msg = "Cannot save Result. Points in result is NULL";
            log.error(msg);
            throw new RuntimeException(msg);
        }

        if (result.getEventResult() == null) {
            String msg = "Cannot save Result. EventResult in result is NULL";
            log.error(msg);
            throw new RuntimeException(msg);
        }

        result.setPoints(getCalculatedResultPointsInEvent(result));

        return resultRepository.save(result);
    }

    public Result getById(int id) { return resultRepository.findById(id).orElse(null); }

    public ResultDTO getDTOById(int id) { return resultFactory.toDto(getById(id)); }

    public List<ResultDTO> getAllDTOs() { return resultFactory.toDto(getAll()); }

    public List<Result> getAll() { return resultRepository.findAll(); }

    public List<ResultDTO> getAllDOsByAthleteId(int athletId) { return resultFactory.toDto(getAllByAthleteId(athletId)); }

    public List<Result> getAllByAthleteId(int athletId) { return resultRepository.findAllByAthletId(athletId); }

    public Double getPointSumByAthleteId(int athletId) { return resultRepository.athletPointSum(athletId); }


    public double getCalculatedResultPointsInEvent(Result result){
        Event event = result.getEvent();
        double a =event.getA();
        double b =event.getB();
        double c =event.getC();
        double resultPoints = 0;

        if (event.isDistanceUnit()) {
            resultPoints = Math.abs(a * Math.pow(result.getEventResult() - b, c));
        }
        else
            resultPoints = Math.abs(a * Math.pow(b - result.getEventResult(), c));

        return resultPoints;
    }
}
