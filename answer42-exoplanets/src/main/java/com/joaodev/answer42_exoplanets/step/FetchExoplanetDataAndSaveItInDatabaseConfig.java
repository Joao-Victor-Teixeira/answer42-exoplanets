package com.joaodev.answer42_exoplanets.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.data.builder.MongoItemWriterBuilder;

import com.joaodev.answer42_exoplanets.domain.dto.ExoplanetsDTO;
import com.joaodev.answer42_exoplanets.domain.entities.Exoplanets;

@Configuration
public class FetchExoplanetDataAndSaveItInDatabaseConfig {

    @Autowired
    private PlatformTransactionManager transactionManager;

    private int chunkSize = 10;

    @Bean
    public ItemProcessor<ExoplanetsDTO , Exoplanets> exoplanetsItemProcessor(){
        return dto ->{
            Exoplanets exoplanets = new Exoplanets();
            exoplanets.setId(dto.getId());
            exoplanets.setPl_name(dto.getPl_name());
            exoplanets.setHostname(dto.getHostname());
            exoplanets.setDisc_year(dto.getDisc_year());
            exoplanets.setDisc_facility(dto.getDisc_facility());
            exoplanets.setDiscoverymethod(dto.getDiscoverymethod());
            exoplanets.setPl_rade(dto.getPl_rade());
            exoplanets.setPl_masse(dto.getPl_masse());
            exoplanets.setPl_eqt(dto.getPl_eqt());
            exoplanets.setPl_orbtper(dto.getPl_orbtper());
            exoplanets.setPl_orbsmax(dto.getPl_orbsmax());
            exoplanets.setSt_teff(dto.getSt_teff());
            exoplanets.setSt_rad(dto.getSt_rad());
            exoplanets.setSt_mass(dto.getSt_mass());
            exoplanets.setSt_lum(dto.getSt_lum());
            exoplanets.setDefault_flag(dto.getDefault_flag());
            exoplanets.setTran_flag(dto.getTran_flag());
            exoplanets.setPl_controv_flag(dto.getPl_controv_flag());
            exoplanets.setPl_refname(dto.getPl_refname());
            return exoplanets;
        };
    }

    @Bean
    public MongoItemWriter<Exoplanets> exoplanetsWriter(MongoTemplate mongoTemplate){
        return new MongoItemWriterBuilder<Exoplanets>()
                .template(mongoTemplate)
                .collection("exoplanets")
                .build();
    }

    @Bean
    public Step fetchExoplanetDataStep(
        ItemReader<ExoplanetsDTO> fechExoplanetsDataReader,
        ItemProcessor<ExoplanetsDTO, Exoplanets> exoplanetsItemProcessor,
        ItemWriter<Exoplanets> exoplanetsWriter,
        JobRepository jobRepository){

            return new StepBuilder("fetchExoplanetDataStep", jobRepository)
                    .<ExoplanetsDTO, Exoplanets>chunk(chunkSize, transactionManager)
                    .reader(fechExoplanetsDataReader)
                    .processor(exoplanetsItemProcessor)
                    .writer(exoplanetsWriter)
                    .build();
        }
}
