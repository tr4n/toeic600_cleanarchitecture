package vn.sun.asterisk.domain.model

import java.io.Serializable

data class Topic(
    val id: Int = 0,
    val name: String = "",
    val imageUrl: String = "",
    val category: String = "",
    val color: String? = null,
    val lastTime: String? = null,
    val total: Int = 12,
    val master: Int = 0,
    val newWord: Int = 0,
    val remind: Int = 0
) : Serializable
