package com.example.springbootretry.shared.config

import com.example.springbootretry.shared.config.model.DataSourceConfigurationProperties
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

@Configuration
@EnableTransactionManagement
class DatabaseConfiguration(
    private val dataSourceConfigurationProperties: DataSourceConfigurationProperties
) {

    @Bean("datasource")
    fun dataSource(): DataSource {
        val dataSource = DriverManagerDataSource();
        dataSource.setDriverClassName(dataSourceConfigurationProperties.driver);
        dataSource.setSchema(dataSourceConfigurationProperties.database);
        dataSource.setUrl(dataSourceConfigurationProperties.url);
        dataSource.setUsername(dataSourceConfigurationProperties.username);
        dataSource.setPassword(dataSourceConfigurationProperties.password);
        return dataSource
    }


    @Bean("namedParameterJdbcTemplate")
    fun namedParameterJdbcTemplate(@Qualifier("datasource") datasource: DataSource): NamedParameterJdbcTemplate {
        return NamedParameterJdbcTemplate(datasource)
    }

}