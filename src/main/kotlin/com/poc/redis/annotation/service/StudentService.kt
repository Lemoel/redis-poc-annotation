package com.poc.redis.annotation.service

import com.poc.redis.annotation.entity.Student
import com.poc.redis.annotation.entity.StudentDTO
import com.poc.redis.annotation.repository.StudentRepository
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import java.util.*

@Service
class StudentService(private val studentRepository: StudentRepository) {

    fun create(dto: StudentDTO) {
        val student = Student(name = dto.name)
        studentRepository.save(student)
    }

    @Cacheable("studentAnnotation")
    fun findById(id: UUID): Student =
        studentRepository.findById(id).orElseThrow {
            IllegalStateException("Student not found")
        }
}