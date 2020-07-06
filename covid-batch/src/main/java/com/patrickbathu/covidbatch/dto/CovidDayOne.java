package com.patrickbathu.covidbatch.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class CovidDayOne{

    @JsonProperty("Country")
    private String country;

    @JsonProperty("CountryCode")
    private String countryCode;

    @JsonProperty("Confirmed")
    private Integer confirmed;

    @JsonProperty("Deaths")
    private Integer deaths;

    @JsonProperty("Recovered")
    private Integer recovered;

    @JsonProperty("Active")
    private Integer active;

    @JsonProperty("Date")
    private String date;

    public String toString(){
        String result = null;
        try {
            result = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
        }catch (JsonProcessingException e){
            result = super.toString();
        }
        return result;
    }

}
