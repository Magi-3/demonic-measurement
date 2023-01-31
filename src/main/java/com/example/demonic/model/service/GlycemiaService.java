package com.example.demonic.model.service;

import com.example.demonic.model.entity.Glycemia;

import java.time.LocalDateTime;

public interface GlycemiaService {

    public Glycemia createNewGlycemicValue(Glycemia glycemia);

    public Glycemia findGlycemiaById(Long id);

    public Glycemia findGlycemiaByDate(LocalDateTime dateTime);

    public void deleteGlycemiaById(Long Id);

    public void UpdateGlycemiaById(Long id, Glycemia glycemia);

}
