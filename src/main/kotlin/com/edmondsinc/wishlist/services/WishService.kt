package com.edmondsinc.wishlist.services

import com.edmondsinc.wishlist.models.User
import com.edmondsinc.wishlist.models.Wish
import com.edmondsinc.wishlist.models.dtos.request.WishReqDto
import com.edmondsinc.wishlist.repositories.UserRepo
import com.edmondsinc.wishlist.repositories.WishRepo
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class WishService(
    var wishRepo: WishRepo,
    private val userRepo: UserRepo
) {

    fun createWishForUser(wishReqDto: WishReqDto, userId:Long): Wish{
        val wish: Wish = reqToWish(wishReqDto, userId)
        return wishRepo.save(wish)
    }

    fun deleteWish(id:Long){
        return wishRepo.deleteById(id)
    }

    fun reqToWish(req: WishReqDto, userId:Long): Wish{
        val user: Optional<User> = userRepo.findById(userId)
        if (user.isPresent) return Wish(req.name, req.description, req.url, req.image, req.price, req.quantity, req.ranking, user.get())
        else throw NotFoundException()
    }
}