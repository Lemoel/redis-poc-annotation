package com.poc.redis.annotation.repository

import com.poc.redis.annotation.entity.Student
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface StudentRepository : CrudRepository<Student, UUID>