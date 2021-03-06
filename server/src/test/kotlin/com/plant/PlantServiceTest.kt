package com.plant

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.assertj.core.api.Assertions.assertThat
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
    @DisplayName("saves plant in repository")
    internal fun addPlant() {
        val newPlant = Plant("my rubber plant", "2018-01-28", 10)

        plantService.add(newPlant)

        val savedPlant = PlantEntity(name = "my rubber plant", lastWatered = "2018-01-28", wateringIntervalInDays = 10)
        verify(mockPlantRepository).save(savedPlant)
    }

    @Test
    @DisplayName("returns a list of plants that are saved")
    internal fun getAllPlants() {
        whenever(mockPlantRepository.findAll()).thenReturn(mutableListOf(PlantEntity(name = "my rubber plant", lastWatered = "2018-01-28", wateringIntervalInDays = 10)))

        val plants: List<Plant> = plantService.getAll()

        assertThat(plants).hasSize(1)
        assertThat(plants[0]).isEqualTo(Plant("my rubber plant", "2018-01-28", 10))
    }
}