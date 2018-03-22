package com.studies.isaquefontinele.kotlinstudies

class User {

    var id: Long? = null
    var name: String? = null
    var address: String? = null
    var createdAt: String? = null
    var updatedAt: String? = null

    constructor()

    constructor(name: String, address: String) {
        this.name = name
        this.address = address
    }

    override fun toString(): String {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}'
    }
}