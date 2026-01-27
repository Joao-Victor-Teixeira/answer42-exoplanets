package com.joaodev.answer42_api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.joaodev.answer42_api.models.entities.Exoplanets;

@Repository
public interface ExoplanetsRepository extends MongoRepository<Exoplanets, String> {

}
