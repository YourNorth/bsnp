package com.spring_boot.active_lead.itis.bsnp.service.impl;

import com.spring_boot.active_lead.itis.bsnp.model.Terrarium;
import com.spring_boot.active_lead.itis.bsnp.model.User;
import com.spring_boot.active_lead.itis.bsnp.repository.TerrariumRepository;
import com.spring_boot.active_lead.itis.bsnp.service.TerrariumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TerrariumServiceImpl implements TerrariumService {
    @Autowired
    TerrariumRepository terrariumRepository;

    @Override
    public Optional<Terrarium> findById(Long id) {
        Optional<Terrarium> result = terrariumRepository.findById(id);
        log.info("IN findById - id: {}, terrarium: {}", id, result);
        return result;
    }

    @Override
    public List<Terrarium> findAll() {
        List<Terrarium> result = terrariumRepository.findAll();
        log.info("IN findAll() - count of terrarums: {}", result.size());
        return result;
    }

    @Override
    public Terrarium save(Terrarium terrarium) {
        Terrarium result = terrariumRepository.save(terrarium);
        log.info("IN save: terrarium: {}", terrarium);
        return result;
    }

    @Override
    public void delete(Terrarium terrarium) {
        log.info("IN delete: terrarium: {}", terrarium);
        terrariumRepository.delete(terrarium);
    }

    @Override
    public List<Terrarium> findAllByUser(User user) {
        List<Terrarium> result = terrariumRepository.findAllByUser(user);
        log.info("IN findAllByUser - user: {}, count of terrariums: {}", user, result.size());
        return result;
    }


    @Override
    public Optional<Terrarium> changeCode(Long id, String code) {
        Optional<Terrarium> terrarium = findById(id);
        return terrarium.map(value -> this.changeCode(value, code));
    }

    @Deprecated
    private Terrarium changeCode(Terrarium terrarium, String code){
        log.info("IN changeCode - terrarium with old code: {}, new code: {}", terrarium, code);
        terrarium.setCode(code);
        return this.save(terrarium);
    }
}
