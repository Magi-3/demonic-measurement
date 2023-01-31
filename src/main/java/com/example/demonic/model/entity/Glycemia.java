package com.example.demonic.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Glycemia implements Serializable {
    static final long serialVersionUID = 42L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String GlycemiaValue;

    private Date date;
}
