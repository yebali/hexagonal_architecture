package com.example.testKoSpring.infrastructure.order

import com.example.testKoSpring.domain.model.customer.Customer
import com.example.testKoSpring.domain.model.order.Order
import com.example.testKoSpring.domain.model.order.OrderRepository
import com.example.testKoSpring.domain.model.order.QOrder.order
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

//Adapter
@Repository
class OrderRepositoryImpl(
    @PersistenceContext
    private val em: EntityManager,
    private val jpaQueryFactory: JPAQueryFactory
): OrderRepository {

    override fun findById(id: Long): Order? {
        return jpaQueryFactory.selectFrom(order)
            .where(order.id.eq(id))
            .fetchOne()
    }

    override fun fundByCustomer(customer: Customer): MutableList<Order> {
        return jpaQueryFactory.selectFrom(order)
            .where(order.customer.eq(customer))
            .fetch()
    }

    override fun save(order: Order) {
        em.persist(order)
    }

    override fun delete(order: Order) {
        em.remove(order)
    }

}