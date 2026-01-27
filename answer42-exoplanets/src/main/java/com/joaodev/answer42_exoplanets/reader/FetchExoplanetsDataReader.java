package com.joaodev.answer42_exoplanets.reader;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.annotation.BeforeChunk;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.joaodev.answer42_exoplanets.domain.dto.ExoplanetsDTO;

@Component
public class FetchExoplanetsDataReader implements ItemReader<ExoplanetsDTO> {

    public static Logger logger = LoggerFactory.getLogger(FetchExoplanetsDataReader.class);
    private final String BASE_URL = "https://exoplanetarchive.ipac.caltech.edu/TAP/sync?query=select+*+from+ps+where+tran_flag=1+and+default_flag=1+order+by"
            +"+pl_name&format=json";

    private RestTemplate restTemplate = new RestTemplate();

    private List<ExoplanetsDTO> exoplanets = new ArrayList<>();
    private int exoplanetsIndex = 0;

    @Override
    public ExoplanetsDTO read() throws Exception {
        if (exoplanetsIndex < exoplanets.size()) {
            return exoplanets.get(exoplanetsIndex ++);
        }
        return null;
    }

    private List<ExoplanetsDTO> fetchExoplanetsFromAPI(){
        try {
            logger.info("[READER] Buscando os exoplanetas na API da NASA ...");
            ResponseEntity<List<ExoplanetsDTO>> response = restTemplate.exchange(
                BASE_URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ExoplanetsDTO>>() {}
            );
            return response.getBody() != null ? response.getBody() : new ArrayList<>();
        } catch (Exception e) {
            logger.error("Erro ao conectar na API da NASA " + e.getMessage());
            throw e;
        }
    }

    @BeforeChunk
    public void beforeChunk(ChunkContext context){
        if (exoplanets.isEmpty()) {
            exoplanets.addAll(fetchExoplanetsFromAPI());
        }
    }
}
