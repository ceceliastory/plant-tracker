package com.plant

import javax.persistence.*

@Entity
@Table(name = "plant")
data class PlantEntity(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,

        var name: String = "",

        @Column(name = "last_watered")
        var lastWatered: String = "",

        @Column(name = "watering_interval_days")
        var wateringIntervalInDays: Int = 0
)