package ru.mitiushkin.otus.persistence.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import ru.mitiushkin.otus.web.dto.UserResponse

@Entity
@Table(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var username: String = "",
    var firstName: String = "",
    var lastName: String = "",
    var email: String = "",
    var phone: String? = null,
) {
    fun toResponse() = UserResponse(
        username = username,
        firstName = firstName,
        lastName = lastName,
        email = email,
        phone = phone
    )
}