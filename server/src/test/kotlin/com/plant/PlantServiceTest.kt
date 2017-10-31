package com.plant

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PlantServiceTest {

    private val mockPlantRepository: PlantRepository = mock()

    lateinit var plantService: PlantService

    @BeforeEach
    internal fun setup() {
        plantService = PlantService(mockPlantRepository)
    }

    @Test
    @DisplayName("should save plant in repository")
    internal fun plantService() {
        val newPlant = Plant("my rubber plant")

        plantService.add(newPlant)

        val savedPlant = PlantEntity(name = "my rubber plant")
        verify(mockPlantRepository).save(savedPlant)
    }
}