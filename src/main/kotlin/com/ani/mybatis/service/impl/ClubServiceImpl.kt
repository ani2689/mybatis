package com.ani.mybatis.service.impl

import com.ani.mybatis.domain.mapper.ClubMapper
import com.ani.mybatis.domain.model.Club
import com.ani.mybatis.service.ClubService
import org.springframework.stereotype.Service

@Service
class ClubServiceImpl(
    private val clubMapper: ClubMapper
) : ClubService {
    override fun createClub(name: String) = clubMapper.createClub(name)

    override fun signupClub(id: Long, userId: Long) = clubMapper.signupClub(id, userId)

    override fun queryClubs(): List<Club> = clubMapper.clubs()

    override fun queryClubsByUser(userId: Long): List<Club> = clubMapper.clubsByUser()
}