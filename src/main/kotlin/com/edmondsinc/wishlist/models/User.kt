package com.edmondsinc.wishlist.models

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.OneToMany
import jakarta.persistence.Table


@Table(name = "users")
@Entity
class User(
    val firstName: String,
    val lastName: String,
    @Column(unique = true)
    val email: String,
    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY, mappedBy = "user")
    val wishes: List<Wish>?
) : AbstractEntity() { //extends AbstractEntity to obtain base items: id, guid, and createdDate

    override fun toString(): String {
        return "User(id='$id', guid='$guid', createdAt='$createdAt' firstName='$firstName', lastName='$lastName', email='$email') \n " +
                "Wishes(wishes='$wishes')"
    }


    /* NOTES Below */
    /*Three ways to initialize a class.

        #1 in the constructor
            by using "val" in the constructor name, it's like doing #2 below.

        #2 assign directly to variable
            val lastName: String = lastName
            val email: String = email

        #3 use an init block if you need to do some logic to assign the value.
            init{
                firstName = _firstName
                lastName = _lastName
            }
     */
}