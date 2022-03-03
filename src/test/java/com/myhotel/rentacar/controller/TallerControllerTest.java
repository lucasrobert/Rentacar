package com.myhotel.rentacar.controller;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myhotel.rentacar.domain.repository.TallerRepository;
import com.myhotel.rentacar.domain.usecase.TallerService;
import com.myhotel.rentacar.domain.usecase.dto.TallerDto;
import com.myhotel.rentacar.domain.usecase.impl.TallerServiceImpl;
import com.myhotel.rentacar.infraestructure.handler.ExceptionControllerAdvice;
import com.myhotel.rentacar.infraestructure.rest.TallerController;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.IOException;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest
class TallerControllerTest {

    @Mock
    private TallerRepository repository;

    @Mock
    private TallerService service;

    private MockMvc mockMvc;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @InjectMocks
    private TallerController controller;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(ExceptionControllerAdvice.class)
                .build();
    }

    @Test
    @DisplayName("GET v1/talleres/1 completado")
    void testGetWidgetById() throws Exception {
        TallerDto tallerDto = TallerDto.builder().id(1).nombre("Taller Test1").build();
        when(service.get(1)).thenReturn(tallerDto);

        String expected = "{\"_data\":{\"id\":1,\"nombre\":\"Taller Test1\"},\"_errors\":[],\"_status\":\"OK\"}";

        assertTrue(
                matchJson(
                        mockMvc.perform(get("/v1/talleres/{id}", 1))
                                .andExpect(status().isOk())
                                .andReturn()
                                .getResponse()
                                .getContentAsString(),
                        expected
                )
        );


    }


    public static boolean matchJson(String responseString, String expectedString) {
        try {
            JsonNode response = OBJECT_MAPPER.readTree(responseString);
            JsonNode expected = OBJECT_MAPPER.readTree(expectedString);
            if (ObjectUtils.notEqual(response, expected)) {
                log.error("\u001b[0;31mExpected <" + expectedString + ">\n but was \n<" + responseString + ">.\u001b[0m");
                return false;
            } else {
                return true;
            }
        } catch (IOException var5) {
            return false;
        }
    }

}
