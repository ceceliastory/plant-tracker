package com.plant

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PlantRepository : CrudRepository<PlantEntity, Int>


