package com.edmondsinc.wishlist.repositories

import com.edmondsinc.wishlist.models.User
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository

interface UserRepo : PagingAndSortingRepository<User, Long>, CrudRepository<User, Long> {

    fun findByEmail(email: String): List<User> //List is non-mutable in kotlin. this would be used to just return the values of the users and that's it.
    fun findAllByEmailIn(email:List<String>): List<User>

//    @Query(value =
//        "SELECT * FROM users u LEFT JOIN wish w ON u.id = w.user_id WHERE u.id = :id",
//        nativeQuery = true)
    @Query("SELECT u FROM User u LEFT JOIN Wish w ON u.id = w.user.id WHERE u.id = :id ")
    fun allWishesForUserId(id: Long): List<User>
}