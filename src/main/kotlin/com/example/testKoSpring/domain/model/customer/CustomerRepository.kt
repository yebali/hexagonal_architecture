package com.example.testKoSpring.domain.model.customer

//Port
interface CustomerRepository {
    fun findById(id: Long): Customer?

    fun save(customer: Customer)

    fun delete(customer: Customer)
}