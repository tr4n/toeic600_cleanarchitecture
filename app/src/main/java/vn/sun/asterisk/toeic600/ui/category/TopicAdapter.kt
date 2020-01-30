package vn.sun.asterisk.toeic600.ui.category

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import kotlinx.android.synthetic.main.item_topic.view.*
import vn.sun.asterisk.domain.model.Topic
import vn.sun.asterisk.toeic600.R
import vn.sun.asterisk.toeic600.ui.base.BaseRecyclerAdapter
import vn.sun.asterisk.toeic600.ui.base.BaseViewHolder

class TopicAdapter(
    callback: TopicDiffUtilCallback
) : BaseRecyclerAdapter<Topic, TopicAdapter.TopicViewHolder>(callback) {

    var onItemClick: (Topic) -> Unit = {}

    override fun getItemLayoutResource(viewType: Int): Int = R.layout.item_topic

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TopicViewHolder(
        itemView = getItemView(parent, viewType),
        onItemClick = onItemClick
    )

    class TopicViewHolder(
        itemView: View,
        private val onItemClick: (Topic) -> Unit
    ) : BaseViewHolder<Topic>(itemView) {

        override fun onBindData(itemData: Topic) = with(itemView) {
            super.onBindData(itemData)

            progressTopic.apply {
                max = itemData.total
                progress = itemData.master
                secondaryProgress = itemData.total - itemData.newWord
            }

            textNameTopic?.text = itemData.name
            textLastTime?.text = itemData.lastTime ?: context.getString(R.string.level_never)
        }

        override fun onItemClickListener(itemData: Topic) = onItemClick(itemData)
    }

    class TopicDiffUtilCallback : DiffUtil.ItemCallback<Topic>() {
        override fun areItemsTheSame(oldItem: Topic, newItem: Topic): Boolean =
            oldItem === newItem

        override fun areContentsTheSame(oldItem: Topic, newItem: Topic): Boolean =
            oldItem == newItem
    }
}
