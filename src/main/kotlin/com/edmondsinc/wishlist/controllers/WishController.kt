package com.edmondsinc.wishlist.controllers

import com.edmondsinc.wishlist.models.Wish
import com.edmondsinc.wishlist.models.dtos.WishDto
import com.edmondsinc.wishlist.models.dtos.request.WishReqDto
import com.edmondsinc.wishlist.models.dtos.response.ErrorResDto
import com.edmondsinc.wishlist.services.WishService
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/wish")
class WishController(var wishService: WishService) {

    @PostMapping()
    fun createWish(
        @RequestBody
        wishDto : WishReqDto,
        userId : Long
    ): ResponseEntity<*> {
        try{
            val wish : Wish = wishService.createWishForUser(wishDto, userId)
            return ResponseEntity<WishDto>(toDto(wish), HttpStatus.OK)
        }catch (e:NotFoundException){
            return ErrorResDto.toResponseEntity(e.message, e.stackTraceToString(), HttpStatus.NOT_FOUND)
        }
        catch (e:Exception){
            return ErrorResDto.toResponseEntity(e.message, e.stackTraceToString(), HttpStatus.INTERNAL_SERVER_ERROR)
        }

    }

    fun toDto(wish: Wish): WishDto{
        return WishDto(wish.name, wish.description, wish.url, wish.image, wish.price, wish.quantity, wish.ranking, wish.user.id)
    }
}