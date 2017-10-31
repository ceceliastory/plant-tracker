package com.plant

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
internal interface PlantRepository : CrudRepository<Plant, Int>


