package com.weme.webservice.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController{
    @GetMapping("/animalapi")
    public void callanimalapi(){
        AnimalAPISet animalAPISet=new AnimalAPISet();
        animalAPISet.postConstruct();
    }
}
/*
//참고:https://vmpo.tistory.com/33 -이전에 참고한 내용
//참고:https://leeborn.tistory.com/entry/Spring-xml-%EB%8D%B0%EC%9D%B4%ED%84%B0-%EC%B2%98%EB%A6%AC%ED%95%98%EA%B8%B02-%EC%BD%94%EB%A1%9C%EB%82%98-OpenAPI


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Response;
import java.net.URI;


public class APIController {
    String StartDay="20220201"; //검색 시작 날짜
    String EndDay="20220207"; //검색 끝 날짜
    String Pageno="1"; //페이지 숫자, 필수 아님
    String numOfRows="10"; //페이지당 보여줄 개수, 필수 아님
    String url="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?bgnde="+StartDay+"&endde="+EndDay+
            "&pageNo="+Pageno+"&numOfRows="+numOfRows+"&ServiceKey="
            +"ia5tvugbDgT2IDf9oME4OPwXUuN252wpqS8vJi%2Bk922X37kOZ25EXBAbW6ayJKT2z0teNaVglVRbDoHXLQk1kw%3D%3D";

    //Api 호출
    @GetMapping(value="/animalapi")
    public ResponseEntity<String> get() {
        RestTemplate restTemplate=new RestTemplate();
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<HttpHeaders> entity=new HttpEntity<>(headers);
        ResponseEntity<String> response=
                restTemplate.exchange(URI.create(url), HttpMethod.GET, entity, String.class);
        return response;
    }



    //xml데이터로 호출하면 java로 데이터 처리 가능
    public Response parser(String xml){
        ObjectMapper xmlMapper=new XmlMapper();
        Response response=null;

        try{
            response=xmlMapper.readValue(xml, Response.class);
        } catch (JsonMappingException e){
            e.printStackTrace();
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return response;

    }

}
    /*
    public static void main(String[] args) throws IOException {
        String StartDay="20220201"; //검색 시작 날짜
        String EndDay="20220207"; //검색 끝 날짜
        String Pageno="1"; //페이지 숫자
        String urlBuilder="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?bgnde="+StartDay+"&endde="+EndDay+
                "&pageNo="+Pageno+"&numOfRows=10&ServiceKey="
                +"ia5tvugbDgT2IDf9oME4OPwXUuN252wpqS8vJi%2Bk922X37kOZ25EXBAbW6ayJKT2z0teNaVglVRbDoHXLQk1kw%3D%3D";
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
    }
}
*/















/*@RestController
public class APIController {

    //보호소 동물 정보
    @GetMapping("/animalapi")
    public String callanimalapi(){
        StringBuffer result=new StringBuffer();
        try{
            String urlstr="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?bgnde=20140301&endde=20140430&pageNo=1&numOfRows=10&ServiceKey="
            +"ia5tvugbDgT2IDf9oME4OPwXUuN252wpqS8vJi+k922X37kOZ25EXBAbW6ayJKT2z0teNaVglVRbDoHXLQk1kw==";

            URL url=new URL(urlstr);
            HttpURLConnection urlConnection=(HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            BufferedReader br;
            br=new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));

            String returnLine;
            result.append("<xmp>");

            while((returnLine= br.readLine())!=null){
                result.append(returnLine+"\n\r");
            }
            urlConnection.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result+"</xmp>";
    }

}

*/