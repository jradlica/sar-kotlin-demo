package com.example.specargresolverdemo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface CustomerRepository : JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer>