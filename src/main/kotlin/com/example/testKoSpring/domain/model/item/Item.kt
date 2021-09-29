package com.example.testKoSpring.domain.model.item

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Item(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val code: String,

    var name: String,

    var price: Int
)