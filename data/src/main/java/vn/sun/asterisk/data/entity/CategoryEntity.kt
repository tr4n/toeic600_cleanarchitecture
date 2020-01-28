package vn.sun.asterisk.data.entity

import vn.sun.asterisk.domain.model.Category

data class CategoryEntity(
    val name: String,
    val color: String,
    val topics: List<TopicEntity>
) : DataEntity(), MappableData<Category> {

    override fun map() = Category(name, color, topics.map(TopicEntity::map))
}
