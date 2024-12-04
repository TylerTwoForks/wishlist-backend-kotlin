package com.edmondsinc.wishlist.services

import com.edmondsinc.wishlist.models.User
import com.edmondsinc.wishlist.models.dtos.response.UserWishCombo
import com.edmondsinc.wishlist.repositories.UserRepo
import com.edmondsinc.wishlist.staticUtilities.userToDto
import com.edmondsinc.wishlist.staticUtilities.wishBulkToDto
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