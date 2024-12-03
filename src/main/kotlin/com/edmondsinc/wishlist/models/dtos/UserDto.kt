package com.edmondsinc.wishlist.models.dtos

import java.util.*

class UserDto(
    val firstName: String = "Default First",
    val lastName: String = "Default Last",
    val email: String = "Default Email",
    id: Long = 1L,
    guid: UUID = UUID.randomUUID()) : BaseDto(id, guid){

    override fun toString(): String {
        return "UserDto(id='$id', guid='$guid', firstName='$firstName', lastName='$lastName', email='$email')"
    }


}