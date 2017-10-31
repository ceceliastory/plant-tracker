package com.plant

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "plant")
data class Plant (

    @Id
    val id: Int,

    val name: String
)