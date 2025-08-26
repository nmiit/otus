package ru.mitiushkin.otus.web.api

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import ru.mitiushkin.otus.service.UserService
import ru.mitiushkin.otus.web.dto.CreateUserRequest
import ru.mitiushkin.otus.web.dto.UpdateUserRequest

@RestController
@RequestMapping("/api/v1/user")
class UserController(
    private val userService: UserService
) {

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getUser(
        @PathVariable("id") userId: Long
    ) = userService.getUserById(userId).toResponse()

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteUser(
        @PathVariable("id") userId: Long
    ) = userService.deleteUserById(userId)

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun createUser(
        @RequestBody rq: CreateUserRequest
    ) = userService.createUser(rq).toResponse()

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun updateUser(
        @PathVariable("id") userId: Long,
        @RequestBody rq: UpdateUserRequest
    ) = userService.updateUser(userId, rq).toResponse()
}