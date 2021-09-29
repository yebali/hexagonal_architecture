package com.example.testKoSpring.domain.model.item

//Port
interface ItemRepository {

    fun findById(id: Long): Item?

    fun findByCode(code: String): Item?

    fun save(item: Item)

    fun delete(item: Item)
}