package com.nal95.portfolioforenterprise.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nal95.portfolioforenterprise.model.Enterprise;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(EnterprisesController.class)
class EnterprisesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private EnterprisesController enterprisesController;

    @Test
    void getAllEnterprise() throws Exception {

        Enterprise mockEnterprise = new Enterprise();
        mockEnterprise.setId(1L);
        mockEnterprise.setEnterpriseName("Adesso");
        mockEnterprise.setEnterpriseToken("12345");

        List<Enterprise> enterpriseList = new ArrayList<>();
        enterpriseList.add(mockEnterprise);
        enterpriseList.add(mockEnterprise);
        enterpriseList.add(mockEnterprise);

        when(enterprisesController.getAllEnterprise()).thenReturn(ResponseEntity.ok(enterpriseList));

        mockMvc.perform(get("/portfolio/enterprises"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].enterpriseName").value("Adesso"))
                .andExpect(jsonPath("$[0].enterpriseToken").value("12345"))
                .andExpect(jsonPath("$[1].id").value(1))
                .andExpect(jsonPath("$[1].enterpriseName").value("Adesso"))
                .andExpect(jsonPath("$[1].enterpriseToken").value("12345"))
                .andExpect(jsonPath("$[2].id").value(1))
                .andExpect(jsonPath("$[2].enterpriseName").value("Adesso"))
                .andExpect(jsonPath("$[2].enterpriseToken").value("12345"))
                .andReturn().getResponse();
    }

    @Test
    void saveEnterprise() throws Exception {

        Enterprise mockEnterprise = new Enterprise();
        mockEnterprise.setId(1L);
        mockEnterprise.setEnterpriseName("Adesso");
        mockEnterprise.setEnterpriseToken("12345");

        final Map<String, String> requestMapping = new HashMap<>();
        requestMapping.put("enterpriseName", "Adesso");

        String requestObject = mapper.writeValueAsString(requestMapping);

        when(enterprisesController.saveEnterprise(any(String.class))).thenReturn(ResponseEntity.ok(mockEnterprise));

        final MockHttpServletResponse response = mockMvc.perform(post("/portfolio/create/enterprise")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestObject))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.enterpriseName").value("Adesso"))
                .andReturn().getResponse();

        assertThat(response).isNotNull();
        assertThat(response.getContentAsString()).isEqualTo("{\"id\":1,\"enterpriseName\":\"Adesso\",\"enterpriseToken\":\"12345\"}");
    }

    @Test
    void updateEnterprise() throws Exception {

        Enterprise existingEnterprise = new Enterprise();
        existingEnterprise.setId(1L);
        existingEnterprise.setEnterpriseName("Adesso");
        existingEnterprise.setEnterpriseToken("12345");

        Enterprise updatetedEnterprise = new Enterprise();
        updatetedEnterprise.setId(1L);
        updatetedEnterprise.setEnterpriseName("Adesso SE");
        updatetedEnterprise.setEnterpriseToken("12345");

        String requestObject = "{\"id\":1,\"enterpriseName\":\"Adesso SE\",\"enterpriseToken\":\"12345\"}";

        when(enterprisesController.updateEnterprise(any(String.class), any(String.class))).thenReturn(ResponseEntity.ok(updatetedEnterprise));

        mockMvc.perform(put("/portfolio/update/12345")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestObject))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.enterpriseName").value("Adesso SE"))
                .andExpect(jsonPath("$.enterpriseToken").value("12345"));
    }
}