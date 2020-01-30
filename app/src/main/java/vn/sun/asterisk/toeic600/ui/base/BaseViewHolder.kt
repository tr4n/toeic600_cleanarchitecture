package vn.sun.asterisk.toeic600.ui.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

open class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    protected var itemData: T? = null
    protected var itemPosition: Int = -1

    init {
        itemView.setOnClickListener {
            itemData?.let { onItemClickListener(it) }
        }
    }

    open fun onBindData(itemData: T) {
        this.itemData = itemData
    }

    open fun onBindData(itemPosition: Int, itemData: T) {
        this.itemPosition = itemPosition
        this.itemData = itemData
    }

    open fun onItemClickListener(itemData: T) {
    }
}
