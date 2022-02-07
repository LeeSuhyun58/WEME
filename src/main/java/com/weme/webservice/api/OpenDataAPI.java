package com.weme.webservice.api;

import com.weme.webservice.domain.xml.AnimalInfoResponse;
import com.weme.webservice.domain.xml.AnimalShelterInfoResponse;
import feign.Param;
import feign.RequestLine;

//호출하고자 하는 api 선언
public interface OpenDataAPI {

    //동물 정보 조회
    @RequestLine("GET /abandonmentPublic"
            +"?serviceKey={serviceKey}"+"%pageNo={pageNumber}+" +
            "&numOfRows={rowsPerPage}")
    AnimalInfoResponse getAnimalInfo(@Param("serviceKey") String serviceKey,
                                     @Param("pageNumber") String pageNumber,
                                     @Param("rowsPerPage") String rowsPerPage);

    //보호소 정보 조회
    @RequestLine("GET /shelter"
            +"?serviceKey={serviceKey}"
            +"&pageNo={pageNumber}"
            +"&numOfRows={rowsPerPage}")
    AnimalShelterInfoResponse getAnimalShelterInfo(@Param("serviceKey") String serviceKey,
                                                   @Param("pageNumber") String pageNumber,
                                                   @Param("rowsPerPage") String rowsPerPage);


}
