package com.edmondsinc.wishlist.controllers

import com.edmondsinc.wishlist.configs.LoadDatabase
import com.edmondsinc.wishlist.models.User
import com.edmondsinc.wishlist.models.dtos.response.ErrorResDto
import com.edmondsinc.wishlist.models.dtos.response.UserWishCombo
import com.edmondsinc.wishlist.services.UserService
import com.edmondsinc.wishlist.staticUtilities.userBulkToDto
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception

@RestController
@RequestMapping("/users")
class UserController(
    var userService: UserService,
) {
    private val log: Logger = LoggerFactory.getLogger(LoadDatabase::class.java)

    @PostMapping("/base")
    fun createUser2(): ResponseEntity<*> {
        try{
            userService.createUser2()
            return ResponseEntity<String>(HttpStatus.OK)
        }catch (e:Exception){
            log.error(e.message +" "+e.stackTraceToString())
            return ResponseEntity<ErrorResDto>(
                ErrorResDto(e.message, e.stackTraceToString()),
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }

    @GetMapping("/{id}/wishes")
    fun usersAndWishesByUserId(@PathVariable id: String) : ResponseEntity<List<UserWishCombo>> {
        return ResponseEntity(userService.getUsersAndWishesByUserId(id.toLong()), HttpStatus.OK)
    }

    @GetMapping("/all")
    fun getAllUsers(): ResponseEntity<*>{
        try{
            val users: List<User> = listOf(userService.userRepo.findAll()).flatten()
            return ResponseEntity(userBulkToDto(users), HttpStatus.OK)
        }catch (e:Exception){
            log.error(e.message +" "+e.stackTraceToString())

            return ResponseEntity<ErrorResDto>(
                ErrorResDto(e.message, e.stackTraceToString()),
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }


}