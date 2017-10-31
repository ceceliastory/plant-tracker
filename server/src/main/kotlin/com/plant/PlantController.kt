package com.plant

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PlantController(private val plantService: PlantService) {

    @PostMapping("/plant")
    fun add(@RequestBody newPlant: Plant) {
        plantService.add(newPlant)
    }

}