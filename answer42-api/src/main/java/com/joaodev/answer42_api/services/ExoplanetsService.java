package com.joaodev.answer42_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaodev.answer42_api.models.dto.ExoplanetMinDTO;
import com.joaodev.answer42_api.models.dto.ExoplanetsDTO;
import com.joaodev.answer42_api.models.entities.Exoplanets;
import com.joaodev.answer42_api.repositories.ExoplanetsRepository;

@Service
public class ExoplanetsService {

    @Autowired
    private ExoplanetsRepository repository;

    @Transactional(readOnly = true)
    public Page<ExoplanetMinDTO> findAll(Pageable pageable) {
        Page<Exoplanets> result = repository.findAll(pageable);
        return result.map(x -> new ExoplanetMinDTO(x));
    }

    @Transactional(readOnly = true)
    public ExoplanetsDTO findByid(String id) {
        Exoplanets result = repository.findById(id).get();
        ExoplanetsDTO dto = new ExoplanetsDTO(result);
        return dto;
    }

    @Transactional(readOnly = true)
    public Page<ExoplanetsDTO> findEarthLike(Pageable pageable) {
        Page<Exoplanets> earthLikePlanets = repository.findEarthLike(0.8, 1.25, 0.5, 2.0, pageable);

        return earthLikePlanets.map(entity -> new ExoplanetsDTO(entity));
    }
}
