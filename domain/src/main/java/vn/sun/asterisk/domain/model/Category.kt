package vn.sun.asterisk.domain.model

data class Category(
    val name: String,
    val color: String,
    val topics: List<String>
) : DomainModel()
