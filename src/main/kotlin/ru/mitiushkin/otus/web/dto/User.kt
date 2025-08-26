package ru.mitiushkin.otus.web.dto

data class UserResponse(
    val username: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String?
)

data class CreateUserRequest(
    val username: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String?
)

data class UpdateUserRequest(
    val firstName: String? = null,
    val lastName: String? = null,
    val email: String? = null,
    val phone: String? = null
)