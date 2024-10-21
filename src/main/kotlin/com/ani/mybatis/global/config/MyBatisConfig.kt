package com.ani.mybatis.global.config

import com.ani.mybatis.global.annotation.MyBatisMapper
import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.apache.ibatis.session.Configuration as SessionConfiguration

@Configuration
@MapperScan(
    basePackages = [
        "com.ani.mybatis.domain.mapper"
    ],
    annotationClass = MyBatisMapper::class,
    sqlSessionFactoryRef = "sqlSessionFactory"
)
class MyBatisConfig {
    @Bean
    fun sqlSessionFactory(): SqlSessionFactory {
        val dataSource = DataSourceBuilder.create().apply {
            url("localhost:3306")
            username("root")
            password("1234")
            driverClassName("com.mysql.cj.jdbc.Driver")
        }.build()

        val configuration = SessionConfiguration().apply {
            isMapUnderscoreToCamelCase = true
        }

        val sqlSessionFactory = SqlSessionFactoryBean().apply {
            setDataSource(dataSource)
            setConfiguration(configuration)
        }.`object`!!

        return sqlSessionFactory
    }
}