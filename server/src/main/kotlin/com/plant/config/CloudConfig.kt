package com.plant.config

import org.springframework.cloud.config.java.AbstractCloudConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import javax.sql.DataSource


@Configuration
@Profile("cloud")
open class CloudConfig : AbstractCloudConfig() {

    @Bean
    open fun dataSource(): DataSource {
        return connectionFactory().dataSource()
    }
}