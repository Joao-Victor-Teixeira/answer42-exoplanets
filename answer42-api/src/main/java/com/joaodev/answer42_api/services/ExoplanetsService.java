package com.joaodev.answer42_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaodev.answer42_api.models.dto.ExoplanetsDTO;
import com.joaodev.answer42_api.models.entities.Exoplanets;
import com.joaodev.answer42_api.repositories.ExoplanetsRepository;

@Service
public class ExoplanetsService {

    @Autowired
    private ExoplanetsRepository repository;

    @Transactional(readOnly = true)
    public Page<ExoplanetsDTO> findAll(Pageable pageable){
        Page<Exoplanets> result = repository.findAll(pageable);
        return result.map(x -> new ExoplanetsDTO(x));
    }
}
