package com.ani.mybatis.domain.mapper

import com.ani.mybatis.domain.model.Club
import com.ani.mybatis.global.annotation.MyBatisMapper

@MyBatisMapper
interface ClubMapper {
    fun clubs(): List<Club>
    fun clubsByUser(): List<Club>
    fun createClub(name: String)
    fun signupClub(id: Long, userId: Long)
}