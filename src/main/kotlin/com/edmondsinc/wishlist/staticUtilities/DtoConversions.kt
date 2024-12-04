package com.edmondsinc.wishlist.staticUtilities

import com.edmondsinc.wishlist.models.User
import com.edmondsinc.wishlist.models.Wish
import com.edmondsinc.wishlist.models.dtos.UserDto
import com.edmondsinc.wishlist.models.dtos.WishDto

fun userBulkToDto(users: List<User>) : ArrayList<UserDto> {
    val userDtoArrayList = ArrayList<UserDto>()
    users.forEach{u ->
        userDtoArrayList.add(userToDto(u))
    }
    return userDtoArrayList
}

fun userToDto(u: User) : UserDto {
    return UserDto(u.firstName, u.lastName, u.email, u.id, u.guid)
}


fun wishBulkToDto(wishes: List<Wish>?) : List<WishDto>{
    val wishToDtoList = ArrayList<WishDto>()
    wishes?.forEach{ w ->
        wishToDtoList.add(wishToDto(w))
    }

    return wishToDtoList
}

fun wishToDto(wish: Wish): WishDto {
    return WishDto(wish.name, wish.description, wish.url, wish.image, wish.price, wish.quantity, wish.ranking, wish.user.id)
}