package com.spring_boot.active_lead.itis.bsnp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
    @Column(name = "module_type")
    private int moduleType;

    @JsonIgnore
    @OneToMany(mappedBy="module", fetch=FetchType.LAZY)
    private List<Parameter> parameters;

    @JsonIgnore
    @Column(name="address")
    private String address;

    @JsonIgnore
    @ManyToOne()
    private Terrarium terrarium;
}
