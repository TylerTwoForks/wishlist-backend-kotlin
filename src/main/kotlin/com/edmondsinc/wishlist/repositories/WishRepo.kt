package com.edmondsinc.wishlist.repositories

import com.edmondsinc.wishlist.models.Wish
import org.springframework.data.repository.CrudRepository


interface WishRepo : CrudRepository<Wish, Long> {

    fun findByNameContaining(itemDesc: String): List<Wish>

}