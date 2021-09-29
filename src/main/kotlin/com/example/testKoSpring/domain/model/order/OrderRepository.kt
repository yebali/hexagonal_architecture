package com.example.testKoSpring.domain.model.order

import com.example.testKoSpring.domain.model.customer.Customer

//Port
interface OrderRepository {
    fun findById(id: Long): Order?

    fun fundByCustomer(customer: Customer): MutableList<Order>

    fun save(order: Order)

    fun delete(order: Order)
}