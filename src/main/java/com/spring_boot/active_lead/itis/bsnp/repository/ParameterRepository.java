package com.spring_boot.active_lead.itis.bsnp.repository;

import com.spring_boot.active_lead.itis.bsnp.model.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParameterRepository extends JpaRepository<Parameter, Long> {

}
