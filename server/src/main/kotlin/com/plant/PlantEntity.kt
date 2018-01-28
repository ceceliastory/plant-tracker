package com.plant

import javax.persistence.*

@Entity
@Table(name = "plant")
data class PlantEntity(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,

        var name: String,

        var lastWatered: String,

        var wateringIntervalInDays: Int
)