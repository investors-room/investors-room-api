package com.habibi.stockstoryapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.habibi.stockstoryapi.dto.StockPositionStoryDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class StockShortPositionStoryControllerTest {

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MockMvc mockMvc;

    @Test
    public void readStockShortPositionStoriesOfCertainStock() throws Exception {
        mockMvc.perform(get("/api/stock-short-position-stories?stock-code=000660")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaTypes.HAL_JSON)
                )
                .andExpect(status().isOk());
    }

    @Test
    public void createStockShortPositionStory() throws Exception {
        StockPositionStoryDto dto = StockPositionStoryDto.builder()
                .stockCode("035720")
                .stockPrices(new int[]{43950, 44000, 43900})
                .dt(LocalDate.of(2023, 10, 1))
                .story("실적이 안 좋고, 개선 여지가 크게 보이지 않아 매도")
                .build();

        mockMvc.perform(post("/api/stock-short-position-stories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaTypes.HAL_JSON)
                        .content(objectMapper.writeValueAsString(dto))
                )
                .andExpect(status().isCreated());
    }
}
