package vn.sun.asterisk.toeic600.ui.category

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import vn.sun.asterisk.domain.model.Category
import vn.sun.asterisk.domain.model.Topic
import vn.sun.asterisk.toeic600.R
import vn.sun.asterisk.toeic600.ui.base.BaseRecyclerAdapter

internal class CategoryAdapter(
    private val onTopicClick: (Topic) -> Unit
) : BaseRecyclerAdapter<Category, CategoryViewHolder>(CategoryDiffUtilCallback()) {

    private val onItemClick = { position: Int, category: Category ->
        category.isExpanded = !category.isExpanded
        notifyItemChanged(position)
    }

    override fun getItemLayoutResource(viewType: Int): Int = R.layout.item_category

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CategoryViewHolder(
            itemView = getItemView(parent, viewType),
            viewPool = RecyclerView.RecycledViewPool(),
            onItemClick = onItemClick,
            onTopicClick = onTopicClick
        )

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.onBindData(position, getItem(position))
    }

    class CategoryDiffUtilCallback : DiffUtil.ItemCallback<Category>() {

        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean =
            oldItem === newItem

        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean =
            oldItem == newItem
    }
}
