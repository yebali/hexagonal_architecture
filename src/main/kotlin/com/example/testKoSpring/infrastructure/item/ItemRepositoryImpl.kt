package com.example.testKoSpring.infrastructure.item

import com.example.testKoSpring.domain.model.item.Item
import com.example.testKoSpring.domain.model.item.ItemRepository
import com.example.testKoSpring.domain.model.item.QItem
import com.example.testKoSpring.domain.model.item.QItem.item
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

//Adapter
@Repository
class ItemRepositoryImpl(
    @PersistenceContext
    private val em: EntityManager,
    private val jpaQueryFactory: JPAQueryFactory
): ItemRepository {

    override fun findById(id: Long): Item? {
        return jpaQueryFactory.selectFrom(item)
            .where(item.id.eq(id))
            .fetchOne()
    }

    override fun findByCode(code: String): Item? {
        return jpaQueryFactory.selectFrom(item)
            .where(item.code.eq(code))
            .fetchOne()
    }

    override fun save(member: Item) {
        em.persist(member);
    }

    override fun delete(member: Item) {
        em.remove(member)
    }
}