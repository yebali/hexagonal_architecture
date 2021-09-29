package com.example.testKoSpring.domain.model.customer

import com.example.testKoSpring.domain.model.order.Order
import javax.persistence.*



@Entity
class Customer (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Enumerated(EnumType.STRING)
    var type: Type = Type.STRANGER,

    var name: String,

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    val orders: MutableList<Order> = mutableListOf()
) {
    enum class Type{
        STRANGER, REGULAR, VIP
    }
}