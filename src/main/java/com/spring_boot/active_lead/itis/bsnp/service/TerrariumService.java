package com.spring_boot.active_lead.itis.bsnp.service;

import com.spring_boot.active_lead.itis.bsnp.model.Module;
import com.spring_boot.active_lead.itis.bsnp.model.Terrarium;
import com.spring_boot.active_lead.itis.bsnp.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TerrariumService extends SuperService<Terrarium, Long> {
    @Override
    public Optional<Terrarium> findById(Long id);

    @Override
    public List<Terrarium> findAll();

    @Override
    public Terrarium save(Terrarium terrarium);

    @Override
    public void delete(Terrarium terrarium);

    public List<Terrarium> findAllByUser(User user);

    @Deprecated
    Optional<Terrarium> changeCode(Long id, String code);
}
