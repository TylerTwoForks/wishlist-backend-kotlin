package com.edmondsinc.wishlist.controllers

import com.edmondsinc.wishlist.models.Wish
import com.edmondsinc.wishlist.models.dtos.WishDto
import com.edmondsinc.wishlist.models.dtos.request.WishReqDto
import com.edmondsinc.wishlist.models.dtos.response.ErrorResDto
import com.edmondsinc.wishlist.services.WishService
import com.edmondsinc.wishlist.staticUtilities.wishToDto
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/wish")
class WishController(
    var wishService: WishService
) {

    @PostMapping()
    fun createWish(
        @RequestBody
        wishDto : WishReqDto,
        userId : Long
    ): ResponseEntity<*> {
        try{
            val wish : Wish = wishService.createWishForUser(wishDto, userId)
            return ResponseEntity<WishDto>(wishToDto(wish), HttpStatus.OK)
        }catch (e:NotFoundException){
            return ErrorResDto.toResponseEntity(e.message, e.stackTraceToString(), HttpStatus.NOT_FOUND)
        }
        catch (e:Exception){
            return ErrorResDto.toResponseEntity(e.message, e.stackTraceToString(), HttpStatus.INTERNAL_SERVER_ERROR)
        }

    }

    @DeleteMapping("/delete/{id}")
    fun deleteWish(@PathVariable id: String) : ResponseEntity<*>{
        try{
            wishService.deleteWish(id.toLong())
            return ResponseEntity.ok("deleted successfully")
        }catch (e:Exception){
            return ErrorResDto.toResponseEntity(e.message, e.stackTraceToString(), HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }



}