package com.ani.mybatis.controller

import com.ani.mybatis.domain.model.Club
import com.ani.mybatis.domain.model.User
import com.ani.mybatis.service.ClubService
import com.ani.mybatis.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class Controller(
    private val userService: UserService,
    private val clubService: ClubService
) {
    @GetMapping("/club")
    fun queryClubs(): ResponseEntity<List<Club>> =
        clubService.queryClubs()
            .let { ResponseEntity.ok(it) }

    @GetMapping("/club/user")
    fun queryClubsByUser(@RequestParam("user_id") userId: Long): ResponseEntity<List<Club>> =
        clubService.queryClubsByUser(userId)
            .let { ResponseEntity.ok(it) }

    @PostMapping("/club")
    fun createClub(@RequestParam name: String): ResponseEntity<Unit> =
        clubService.createClub(name)
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }

    @PostMapping("/club/signup")
    fun signupClub(@RequestParam("club_id") clubId: Long, @RequestParam("user_id") userId: Long): ResponseEntity<Unit> =
        clubService.signupClub(clubId, userId)
            .let { ResponseEntity.status(HttpStatus.NO_CONTENT).build() }

    @GetMapping("/user")
    fun queryUsersByClub(@RequestParam("club_id") clubId: Long): ResponseEntity<List<User>> =
        userService.queryUsersByClub(clubId)
            .let { ResponseEntity.ok(it) }

    @PostMapping("/user")
    fun createUser(@RequestParam name: String): ResponseEntity<Unit> =
        userService.createUser(name)
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }

}