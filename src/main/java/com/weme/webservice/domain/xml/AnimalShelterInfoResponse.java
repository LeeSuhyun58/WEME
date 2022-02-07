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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="response")
public class AnimalShelterInfoResponse {
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
        private String careRegNo;
        private String careNm;
    }
}
