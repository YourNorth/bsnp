package com.spring_boot.active_lead.itis.bsnp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "module")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @Enumerated(value = EnumType.STRING)
    @Column(name = "module_type")
    private ModuleType moduleType;

    @JsonIgnore
    @Column(name = "setting")
    private String settings;

    @JsonIgnore
    @Column(name="address")
    private String address;

    @JsonIgnore
    @ManyToOne()
    private Terrarium terrarium;
}
