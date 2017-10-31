package com.plant

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "plant")
data class PlantEntity(

    @Id
    var id: Int? = null,

    val name: String
)