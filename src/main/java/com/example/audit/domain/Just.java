package com.example.audit.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "JUST")
public class Just {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "room")
    private String room;


    @Column(name = "number")
    private String number;


    @Column(name = "description")
    private String description;

}
