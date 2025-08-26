package ru.mitiushkin.otus.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.mitiushkin.otus.persistence.entity.User
import ru.mitiushkin.otus.persistence.repository.UserRepository
import ru.mitiushkin.otus.web.dto.CreateUserRequest
import ru.mitiushkin.otus.web.dto.UpdateUserRequest

@Service
class UserService(
    private val userRepository: UserRepository
) {

    @Transactional
    fun getUserById(userId: Long): User = userRepository.findByIdOrNull(userId)
            ?: throw IllegalArgumentException("User with id $userId not found")

    @Transactional
    fun deleteUserById(userId: Long) = userRepository.deleteById(userId)

    @Transactional
    fun createUser(createUser: CreateUserRequest): User {
        val user = User(
            username = createUser.username,
            firstName = createUser.firstName,
            lastName = createUser.lastName,
            email = createUser.email,
            phone = createUser.phone
        )

        userRepository.save(user)

        return user
    }

    @Transactional
    fun updateUser(
        userId: Long,
        updateUserRq: UpdateUserRequest
    ): User {
        val user = userRepository.findByIdOrNull(userId) ?: throw IllegalArgumentException("User with id $userId not found")

        user.apply {
            firstName = updateUserRq.firstName ?: this.firstName
            lastName = updateUserRq.lastName ?: this.lastName
            email = updateUserRq.email ?: this.email
            phone = updateUserRq.phone ?: this.phone
        }

        userRepository.save(user)

        return user
    }

}