package vn.sun.asterisk.toeic600.ui.category

import android.graphics.Color
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_category.view.*
import vn.sun.asterisk.domain.model.Category
import vn.sun.asterisk.domain.model.Topic
import vn.sun.asterisk.toeic600.R
import vn.sun.asterisk.toeic600.ui.base.BaseViewHolder


internal class CategoryViewHolder(
    itemView: View,
    viewPool: RecyclerView.RecycledViewPool,
    private val onItemClick: (Int, Category) -> Unit,
    private val onTopicClick: (Topic) -> Unit = {}
) : BaseViewHolder<Category>(itemView) {

    private val topicAdapter = TopicAdapter(TopicAdapter.TopicDiffUtilCallback()).apply {
        onItemClick = onTopicClick
    }

    init {
        itemView.recyclerTopics.apply {
            setRecycledViewPool(viewPool)
            adapter = topicAdapter
        }
    }

    override fun onBindData(itemPosition: Int, itemData: Category) {
        super.onBindData(itemPosition, itemData)

        itemView.run {
            relativeCategory?.setBackgroundColor(Color.parseColor(itemData.color))
            textTitleCategory?.text = itemData.name
            textTitleTopics?.text = itemData.topics.joinToString { it.name }

            if (itemData.isExpanded) {
                recyclerTopics?.isVisible = true
                imageExpand?.setImageResource(R.drawable.ic_keyboard_arrow_up)
            } else {
                recyclerTopics?.isVisible = false
                imageExpand?.setImageResource(R.drawable.ic_keyboard_arrow_down)
            }
        }
        topicAdapter.submitList(itemData.topics)
    }

    override fun onItemClickListener(itemData: Category) = onItemClick(itemPosition, itemData)
}
