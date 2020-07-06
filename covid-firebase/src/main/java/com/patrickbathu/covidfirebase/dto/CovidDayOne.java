package com.patrickbathu.covidfirebase.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CovidDayOne  implements Serializable {

    @JsonInclude(Include.NON_NULL)
    private String _id;

    @JsonAlias({"Country", "country"})
    private String country;

    @JsonAlias({"CountryCode", "countryCode"})
    private String countryCode;

    @JsonAlias({"Confirmed", "confirmed"})
    private Integer confirmed;

    @JsonAlias({"Deaths", "deaths"})
    private Integer deaths;

    @JsonAlias({"Recovered", "recovered"})
    private Integer recovered;

    @JsonAlias({"Active", "active"})
    private Integer active;

    @JsonAlias({"Date", "date"})
    private String date;

    private String deathRate;

    private String recoveryRate;

    private String activeRate;

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
