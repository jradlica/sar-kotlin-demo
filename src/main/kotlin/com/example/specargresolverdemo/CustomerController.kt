package com.example.specargresolverdemo

import net.kaczmarzyk.spring.data.jpa.domain.Equal
import net.kaczmarzyk.spring.data.jpa.domain.Like
import net.kaczmarzyk.spring.data.jpa.web.annotation.And
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController(val repo: CustomerRepository) {

    @GetMapping("/customers")
    fun findProvidersByIdAndName(@And(
            Spec(path = "name", spec = Like::class),
            Spec(path = "id", spec = Equal::class)) spec: Specification<Customer>, pageable: Pageable): Page<Customer> {
        return repo.findAll(spec, pageable);
    }
}