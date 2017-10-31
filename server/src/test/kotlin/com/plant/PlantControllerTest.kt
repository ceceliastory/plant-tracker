package com.plant

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

class PlantControllerTest {

    private val mockPlantService = Mockito.mock(PlantService::class.java)

    lateinit var plantController: PlantController
    lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setup() {
        plantController = PlantController(mockPlantService)
        mockMvc = MockMvcBuilders.standaloneSetup(plantController).build()
    }

    @Test
    @DisplayName("receives plant and passes to service")
    fun addPlant() {
        val newPlant = Plant("new plant")

        plantController.add(newPlant)

        verify(mockPlantService).add(newPlant)
    }

    @Test
    @DisplayName("add plant is an HTTP endpoint which passes plant to service")
    fun addPlantHttp() {
        val plant = Plant("cool plant")
        val jsonRequest = ObjectMapper().writeValueAsString(plant)

        mockMvc.perform(post("/plant").content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)

        verify(mockPlantService).add(plant)
    }

}