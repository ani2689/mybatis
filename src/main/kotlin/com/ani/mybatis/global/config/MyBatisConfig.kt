package com.ani.mybatis.global.config

import com.ani.mybatis.global.annotation.MyBatisMapper
import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.annotation.Configuration

@Configuration
@MapperScan(
    basePackages = [
        "com.ani.mybatis.domain.mapper"
    ],
    annotationClass = MyBatisMapper::class
)
class MyBatisConfig {
}