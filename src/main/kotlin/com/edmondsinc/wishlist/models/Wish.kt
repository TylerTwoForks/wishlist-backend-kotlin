package com.edmondsinc.wishlist.models

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class Wish(
    val name: String,
    val description: String?,
    val url: String?,
    val image: String?,
    val price: Double = 0.0,
    val quantity: Int = 1,
    val ranking: Int = 1,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user.id")
    val user: User
) : AbstractEntity() {

    override fun toString(): String {
        return "Wish(id='$id', guid='$guid', createdAt='$createdAt', name='$name', description=$description, url=$url, image=$image, price=$price, quantity=$quantity, ranking=$ranking, user=${user.id})"
    }
}