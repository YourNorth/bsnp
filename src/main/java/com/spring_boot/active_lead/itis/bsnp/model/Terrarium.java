package com.spring_boot.active_lead.itis.bsnp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "terrarium")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Terrarium {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "code")
    private String code;

    @JsonIgnore
    @ManyToOne()
    private User user;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy="terrarium", fetch=FetchType.LAZY)
    Set<Module> modules;
}
