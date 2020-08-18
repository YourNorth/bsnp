package com.spring_boot.active_lead.itis.bsnp.service.impl;

import com.spring_boot.active_lead.itis.bsnp.model.Parameter;
import com.spring_boot.active_lead.itis.bsnp.repository.ParameterRepository;
import com.spring_boot.active_lead.itis.bsnp.service.ParameterService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ParameterServiceImpl implements ParameterService {

    @Autowired
    ParameterRepository parameterRepository;

    @Override
    public Optional<Parameter> findById(Long id) {
        Optional<Parameter> result = parameterRepository.findById(id);
        log.info("IN findById - id : {}, parameter: {}", id, result);
        return result;
    }

    @Override
    public List<Parameter> findAll() {

        List<Parameter> result = parameterRepository.findAll();
        log.info("IN findAll - parameters : {}", result);
        return result;
    }

    @Override
    public Parameter save(Parameter parameter) {
        Parameter result = parameterRepository.save(parameter);
        log.info("IN save - parameter : {}", result);
        return result;
    }

    @Override
    public void delete(Parameter parameter) {
        log.info("IN  delete - parameter : {}", parameter);
        parameterRepository.delete(parameter);
    }
}
