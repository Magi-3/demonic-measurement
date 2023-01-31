package com.example.demonic.model.service.serviceimpl;

import com.example.demonic.model.entity.Glycemia;
import com.example.demonic.model.repository.GlycemiaRepository;
import com.example.demonic.model.service.GlycemiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class GlycemiaImpl implements GlycemiaService {

    private final GlycemiaRepository glycemiaRepository;

    @Autowired
    GlycemiaImpl(GlycemiaRepository glycemiaRepository){
        this.glycemiaRepository = glycemiaRepository;
    }

    @Override
    public Glycemia createNewGlycemicValue(Glycemia glycemia) {
        glycemia.setDate(new Date());
        return glycemiaRepository.save(glycemia);
    }

    @Override
    public Glycemia findGlycemiaById(Long id) {
        return glycemiaRepository.findById(id).orElseThrow();
    }

    @Override
    public Glycemia findGlycemiaByDate(LocalDateTime dateTime) {
        return glycemiaRepository.findByDate(dateTime);
    }

    @Override
    public void deleteGlycemiaById(Long id) {
        glycemiaRepository.deleteById(id);
    }

    @Override
    public void UpdateGlycemiaById(Long id, Glycemia glycemiaUpdated) {
        Glycemia glycemia = glycemiaRepository.findById(id).orElseThrow();
        glycemia.setId(glycemiaUpdated.getId());
        glycemia.setDate(glycemiaUpdated.getDate());
        glycemia.setGlycemiaValue(glycemiaUpdated.getGlycemiaValue());
    }
}
