package com.spring_boot.active_lead.itis.bsnp.service;

import com.spring_boot.active_lead.itis.bsnp.model.Terrarium;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface SuperService<T, ID>{
    public Optional<T> findById(ID id);
    public List<T> findAll();
    public T save(T t);
    public void delete(T t);
}
