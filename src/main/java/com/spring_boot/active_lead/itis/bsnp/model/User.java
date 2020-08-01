package com.spring_boot.active_lead.itis.bsnp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String login;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @JsonIgnore
    @Column(name="role")
    @Enumerated(value = EnumType.STRING)
    private Role role;


    @ToString.Exclude
    @JsonIgnore
    @OneToMany (mappedBy="user", fetch=FetchType.LAZY)
    private Set<Terrarium> terrariums;
}
