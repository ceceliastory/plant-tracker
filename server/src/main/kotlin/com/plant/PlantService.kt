package com.plant

import org.springframework.stereotype.Service

@Service
open class PlantService(private val plantRepository: PlantRepository) {

    open fun add(newPlant: Plant) {
        val plantEntity = PlantEntity(name = newPlant.name)

        plantRepository.save(plantEntity)
    }

}