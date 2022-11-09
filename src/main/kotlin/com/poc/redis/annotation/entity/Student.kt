package com.poc.redis.annotation.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "student")
data class Student(
    @Id val id: UUID = UUID.randomUUID(),
    @Column var name: String? = null,
)
