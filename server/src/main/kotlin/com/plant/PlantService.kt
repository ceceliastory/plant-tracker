package com.plant

import org.springframework.stereotype.Service

@Service
open class PlantService(private val plantRepository: PlantRepository) {

    open fun add(newPlant: Plant) {
        val plantEntity = PlantEntity(name = newPlant.name,
                lastWatered = newPlant.lastWatered,
                wateringIntervalInDays = newPlant.wateringIntervalInDays)

        plantRepository.save(plantEntity)
    }

    open fun getAll(): List<Plant> {
        return plantRepository.findAll().map { plant -> Plant(plant.name, plant.lastWatered, plant.wateringIntervalInDays) }
    }

}