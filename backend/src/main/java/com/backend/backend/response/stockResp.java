package com.backend.backend.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

@ToString
public class StockResp {
    @JsonProperty("Date")
    private List<String> dates;
  
    @JsonProperty("Open")
    private List<Double> openPrices;
  
    @JsonProperty("High")
    private List<Double> highPrices;
  
    @JsonProperty("Low")
    private List<Double> lowPrices;
  
    @JsonProperty("Close")
    private List<Double> closePrices;
  
    @JsonProperty("Volume")
    private List<Long> volumes;
  
}
