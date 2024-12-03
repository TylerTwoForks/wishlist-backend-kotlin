package com.edmondsinc.wishlist.services

import com.edmondsinc.wishlist.models.User
import com.edmondsinc.wishlist.repositories.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

//import org.springframework.boot.autoconfigure.security.SecurityProperties
@Service
class UserService(
    var userRepo: UserRepo
){


    fun createUser(firstName: String, lastName: String, email:String){
        userRepo.save(
            User(firstName, lastName, email)
        )
    }

    fun createUser2(){
        val newUser2 = User("Tyler", "Edmonds", "Tyler.g.edmonds@gmail.com")
        userRepo.save(newUser2)
    }
}