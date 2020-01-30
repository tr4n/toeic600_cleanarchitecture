package vn.sun.asterisk.toeic600.ui.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class BaseRecyclerAdapter<T, VH : BaseViewHolder<T>>(callback: DiffUtil.ItemCallback<T>) :
    ListAdapter<T, VH>(callback) {

    abstract fun getItemLayoutResource(viewType: Int): Int

    override fun onBindViewHolder(holder: VH, position: Int) =
        holder.onBindData(getItem(position))

    override fun submitList(items: List<T>?) {
        super.submitList(items ?: emptyList())
    }

    protected fun getItemView(parent: ViewGroup, viewType: Int): View =
        LayoutInflater.from(parent.context)
            .inflate(getItemLayoutResource(viewType), parent, false)
}
