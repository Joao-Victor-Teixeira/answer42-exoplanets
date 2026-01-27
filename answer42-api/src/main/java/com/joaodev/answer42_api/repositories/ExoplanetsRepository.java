package com.joaodev.answer42_api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.joaodev.answer42_api.models.entities.Exoplanets;

@Repository
public interface ExoplanetsRepository extends MongoRepository<Exoplanets, String> {

    @Query("{ 'pl_rade' : { $gt: ?0, $lt: ?1 }, 'pl_masse' : { $gt: ?2, $lt: ?3 } }")
    Page<Exoplanets> findEarthLike(Double minRade, Double maxRade, Double minMasse, Double maxMasse, Pageable pageable);
}
