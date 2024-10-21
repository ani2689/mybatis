package com.ani.mybatis.domain.mapper

import com.ani.mybatis.domain.model.User
import com.ani.mybatis.global.annotation.MyBatisMapper

@MyBatisMapper
interface UserMapper {
    fun usersByClub(clubId: Long): List<User>
    fun createUser(name: String)
}