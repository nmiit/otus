package ru.mitiushkin.otus.persistence.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.mitiushkin.otus.persistence.entity.User

@Repository
interface UserRepository : JpaRepository<User, Long> {
}