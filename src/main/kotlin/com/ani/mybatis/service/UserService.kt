package com.ani.mybatis.service

import com.ani.mybatis.domain.model.User

interface UserService {
    fun createUser(name: String)
    fun queryUsersByClub(clubId: Long): List<User>
}