package com.weme.webservice.domain.xml;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType
@XmlRootElement(name="response")
public class AnimalInfoResponse {

    private Header header;
    private Body body;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Header{
        private String resultCode;
        private String resultMsg;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @XmlRootElement(name="body")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Body{
        @XmlElementWrapper(name="items")
        @XmlElement(name="item")
        private List<Item> items=new ArrayList<>();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @XmlRootElement(name="item")
    public static class Item{
        public String age;
        public String careAddr;
        public String careNm;
        public String careTel;
        public String chargeNm;
        public String colorCd;
        public String desertionNo;
        public String filename;
        public String happenDt;
        public String happenPlace;
        public String kindCd;
        public String neuterYn;
        public String noticeEdt;
        public String noticeNo;
        public String noticeSdt;
        public String officetel;
        public String orgNm;
        public String popfile;
        public String processState;
        public String sexCd;
        public String specialMark;
        public String weight;
    }
}
