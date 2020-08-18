package com.spring_boot.active_lead.itis.bsnp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "parameter")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Parameter {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private int code;

    private String name;

    private float setValue;

    private float realValue;

    @ToString.Exclude
    @JsonIgnore
    @ManyToOne
    private Module module;
}

