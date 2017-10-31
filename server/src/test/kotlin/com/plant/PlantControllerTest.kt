package com.plant

import com.fasterxml.jackson.databind.ObjectMapper
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

class PlantControllerTest {

    val mockPlantService: PlantService = mock()

    lateinit var plantController: PlantController
    lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setup() {
        plantController = PlantController(mockPlantService)
        mockMvc = MockMvcBuilders.standaloneSetup(plantController).build()
    }

    @Nested
    @DisplayName("adding a plant")
    inner class AddPlant {

        @Test
        @DisplayName("receives plant and passes to service")
        fun addPlant() {
            val newPlant = Plant("new plant")

            plantController.add(newPlant)

            verify(mockPlantService).add(newPlant)
        }

        @Test
        @DisplayName("is an HTTP endpoint which passes plant to service")
        fun addPlantHttp() {
            val plant = Plant("cool plant")
            val jsonRequest = ObjectMapper().writeValueAsString(plant)

            mockMvc.perform(post("/plant").content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk)

            verify(mockPlantService).add(plant)
        }
    }

    @Nested
    @DisplayName("retrieving all plants")
    inner class GetPlants {

        private val expectedPlants = listOf(Plant("cool guy"))

        @BeforeEach
        fun setup() {
            whenever(mockPlantService.getAll()).thenReturn(expectedPlants)
        }

        @Test
        @DisplayName("returns plants")
        fun getPlants() {
            val actualPlants = plantController.getAll()

            verify(mockPlantService).getAll()
            assertThat(actualPlants).isEqualTo(expectedPlants)
        }

        @Test
        @DisplayName("is an HTTP endpoint")
        fun getPlantsHttp() {
            mockMvc.perform(get("/plants")).andExpect(status().isOk)

            verify(mockPlantService).getAll()
        }
    }

}