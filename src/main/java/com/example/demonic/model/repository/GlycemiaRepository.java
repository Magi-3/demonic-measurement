package com.example.demonic.model.repository;

import com.example.demonic.model.entity.Glycemia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface GlycemiaRepository extends JpaRepository<Glycemia, Long> {
    Glycemia findByDate(LocalDateTime dateTime);

}
