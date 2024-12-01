package com.edmondsinc.wishlist.controllers

import com.edmondsinc.wishlist.services.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController {

    var us:UserService = UserService()

    @PostMapping("/user/base")
    fun createUser(){
        return us.createUser2()
    }
}