package com.weme.webservice.api;

import com.weme.webservice.domain.xml.AnimalInfoResponse;
import com.weme.webservice.domain.xml.AnimalShelterInfoResponse;
import feign.Feign;
import feign.jaxb.JAXBContextFactory;
import feign.jaxb.JAXBDecoder;
import feign.jaxb.JAXBEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.LocalDateTime;


//Open API를 조회하기 위한 설정과 조회에서 로깅, db 저장
@Slf4j
@Component
public class AnimalAPISet {
    private @Value("${api.serviceKey}") String apiKey;
    //private @Autowired(required = true) AnimalRepository animalRepository;
    private OpenDataAPI openDataAPI;

    @PostConstruct
    public void postConstruct(){
        log.info("AnimalAPISet Stared At : {}", LocalDateTime.now().toString());

        JAXBContextFactory jaxbContextFactory=new JAXBContextFactory.Builder()
                .withMarshallerJAXBEncoding("UTF-8")
                .build();

        openDataAPI=Feign.builder()
                .encoder(new JAXBEncoder(jaxbContextFactory))
                .decoder(new JAXBDecoder(jaxbContextFactory))
                .target(OpenDataAPI.class, "http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc");
        }

        @PreDestroy
        public void preDestroy(){
            log.info("AnimalAPISet Finished At : {}", LocalDateTime.now().toString());
        }


        @Scheduled(fixedDelay = 1000)
        public void scheduleTask() {
            //10페이지까지 가져오기
            for(int i=1;i<=10;i++){
                String rowsPerPage="10";
                String pageNumber=String.valueOf(i);

                AnimalInfoResponse animalInfoResponse=openDataAPI.getAnimalInfo(apiKey,pageNumber,rowsPerPage);
                AnimalShelterInfoResponse animalShelterInfoResponse=openDataAPI.getAnimalShelterInfo(apiKey,pageNumber,rowsPerPage);

                log.info("유기동물 정보 Page {} : {}",pageNumber, animalInfoResponse);
                log.info("보호소 정보 Page {} : {}", pageNumber, animalShelterInfoResponse);


                //DB저장하는 곳(지금은 사용x)
                animalInfoResponse.getBody().getItems().forEach(item->{


                });


               }
            }
        }

