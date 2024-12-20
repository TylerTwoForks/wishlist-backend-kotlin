package com.edmondsinc.wishlist.services

import com.edmondsinc.wishlist.models.User
import com.edmondsinc.wishlist.models.dtos.response.UserWishCombo
import com.edmondsinc.wishlist.repositories.UserRepo
import com.edmondsinc.wishlist.staticUtilities.userToDto
import com.edmondsinc.wishlist.staticUtilities.wishBulkToDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest

import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class UserService(
    var userRepo: UserRepo,
){

    fun getUsersAndWishesByUserId(id:Long) : List<UserWishCombo> {
        val userAndWishes = userRepo.allWishesForUserId(id)
        return userAndWishes.map { uaw ->
            UserWishCombo(userToDto(uaw), wishBulkToDto(uaw.wishes))
        }
    }

    fun getAllUsers() : MutableIterable<User> {
        return userRepo.findAll()
    }

    fun getAllUsersPaged(page:Int, size:Int): Page<User> {
        val pageable = PageRequest.of(page, size).withSort(Sort.by(Sort.Direction.ASC, "id"))
        return userRepo.findAll(pageable)
    }

    fun createUser(firstName: String, lastName: String, email:String){
        userRepo.save(
            User(firstName, lastName, email, null)
        )
    }

    fun createUser2(){
        val newUser2 = User("Tyler", "Edmonds", "Tyler.g.edmonds@gmail.com", null)
        userRepo.save(newUser2)
    }
}