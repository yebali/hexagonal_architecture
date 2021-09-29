package com.example.testKoSpring.domain.model.order

import com.example.testKoSpring.domain.model.customer.Customer
import com.example.testKoSpring.domain.model.item.Item
import javax.persistence.*

@Entity
class Order(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer")
    val customer: Customer,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item")
    val item: Item
)