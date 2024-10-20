package com.ani.mybatis.service

import com.ani.mybatis.domain.model.Club

interface ClubService {
    fun createClub(name: String)
    fun signupClub(id: Long, userId: Long)
    fun queryClubs(): List<Club>
    fun queryClubsByUser(userId: Long): List<Club>
}