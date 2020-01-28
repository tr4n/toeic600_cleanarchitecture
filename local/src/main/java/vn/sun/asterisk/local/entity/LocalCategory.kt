package vn.sun.asterisk.local.entity

import vn.sun.asterisk.data.entity.CategoryEntity
import vn.sun.asterisk.data.entity.MappableData

data class LocalCategory(
    val name: String,
    val color: String,
    val topics: List<LocalTopic>
) : LocalEntity(), MappableData<CategoryEntity> {

    override fun map() = CategoryEntity(name, color, topics.map(LocalTopic::map))
}
