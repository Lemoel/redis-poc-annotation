package com.poc.redis.annotation.resource

import com.poc.redis.annotation.entity.Student
import com.poc.redis.annotation.entity.StudentDTO
import com.poc.redis.annotation.service.StudentService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/v1/students")
class StudentResource(
    val studentService: StudentService,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody student: StudentDTO) = studentService.create(student)

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun find(@PathVariable id: UUID): Student {
        return studentService.findById(id)
    }

}