package com.joaodev.answer42_api.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.LimitOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaodev.answer42_api.models.dto.BigStarSystemDTO;
import com.joaodev.answer42_api.models.dto.StarSystemDTO;
import com.joaodev.answer42_api.models.entities.Exoplanets;
import com.joaodev.answer42_api.repositories.ExoplanetsRepository;

@Service
public class ExoplanetsService {

    private final ExoplanetsRepository repository;

    private final MongoTemplate mongoTemplate;

    public ExoplanetsService(ExoplanetsRepository repository, MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }

    @Transactional(readOnly = true)
    public Page<Exoplanets> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Exoplanets findByid(String id) {
        return repository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public Page<Exoplanets> findEarthLike(Pageable pageable) {
        Page<Exoplanets> earthLikePlanets = repository.findEarthLike(0.8, 1.25, 0.5, 2.0, pageable);
        return earthLikePlanets;
    }

    @Transactional(readOnly = true)
    public List<StarSystemDTO> getTopStarSystems() {

        GroupOperation group = Aggregation.group("hostname").count().as("planetCount");

        SortOperation sort = Aggregation.sort(Sort.Direction.DESC, "planetCount");

        LimitOperation limit = Aggregation.limit(20);

        ProjectionOperation projection = Aggregation.project("planetCount").and("_id").as("hostname");

        Aggregation aggregation = Aggregation.newAggregation(
                group,
                sort,
                limit,
                projection);

        AggregationResults<StarSystemDTO> results = mongoTemplate.aggregate(
                aggregation,
                "exoplanets",
                StarSystemDTO.class);

        return results.getMappedResults();
    }

    @Transactional(readOnly = true)
    public List<BigStarSystemDTO> getBiggestStarsWithPlanets() {

        MatchOperation match = Aggregation.match(Criteria.where("st_rad").gt(0.5));

        SortOperation sort = Aggregation.sort(Sort.Direction.DESC, "st_rad");

        GroupOperation group = Aggregation.group("hostname")
                .first("st_rad").as("st_rad")
                .push(new org.bson.Document("pl_name", "$pl_name"))
                .as("planets");

        LimitOperation limit = Aggregation.limit(15);

        ProjectionOperation project = Aggregation.project("st_rad", "planets")
                .and("_id").as("hostname");

        Aggregation aggregation = Aggregation.newAggregation(match, sort, group, limit, project);

        return mongoTemplate.aggregate(aggregation, "exoplanets", BigStarSystemDTO.class).getMappedResults();
    }

    
}
