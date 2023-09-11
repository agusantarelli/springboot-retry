package com.example.springbootretry.shared.config.model

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("spring.datasource", ignoreInvalidFields = true)
class DataSourceConfigurationProperties{
    @Value("\${spring.datasource.driver-class-name}")
    var driver: String = ""
    var url: String = ""
    var database: String = ""
    var username: String = ""
    var password: String = ""
}