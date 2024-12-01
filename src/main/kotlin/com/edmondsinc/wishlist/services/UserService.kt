package com.edmondsinc.wishlist.services

import com.edmondsinc.wishlist.models.User
import com.edmondsinc.wishlist.repositories.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

//import org.springframework.boot.autoconfigure.security.SecurityProperties
@Service
class UserService{

    @Autowired
    lateinit var userRepo:UserRepo


    fun createUser(firstName: String, lastName: String, email:String){
        val newUser = User(firstName, lastName, email)
//        newUser.firstName = firstName
//        newUser.lastName = lastName
//        newUser.email = email

        userRepo.save(newUser)

    //this is a sneaky way to use java reflection in Kotlin to get this done.
    //val myU = AppUser::class.java.getConstructor().newInstance()
    }

    fun createUser2(){
        val newUser2 = User("Tyler", "Edmonds", "Tyler.g.edmonds@gmail.com")
        userRepo.save(newUser2)
    }
}