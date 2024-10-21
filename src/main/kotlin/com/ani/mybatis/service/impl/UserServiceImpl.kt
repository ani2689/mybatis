package com.ani.mybatis.service.impl

import com.ani.mybatis.domain.mapper.UserMapper
import com.ani.mybatis.domain.model.User
import com.ani.mybatis.service.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userMapper: UserMapper
) : UserService {
    override fun createUser(name: String) = userMapper.createUser(name)

    override fun queryUsersByClub(clubId: Long): List<User> = userMapper.users()
}