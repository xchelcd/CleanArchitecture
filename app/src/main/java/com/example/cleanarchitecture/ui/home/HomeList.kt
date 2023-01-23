package com.example.cleanarchitecture.ui.home

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecture.data.model.Post
import com.example.cleanarchitecture.util.CallbackWithObj
import com.example.cleanarchitecture.util.onItemSelected
import com.example.cleanarchitecture.util.toast

class HomeList(
    context: Context,
    attrs: AttributeSet
) : RecyclerView(context, attrs), ListenerTest {

    override fun itemSelected(function: (Post) -> Unit): Post {
        return Post(1, "titleX", "", listOf(), "123")
    }

    var data: List<Post> = emptyList()
        set(value) {
            field = value
            adapter?.notifyItemRangeChanged(0, value.size)
        }

    init {
        adapter = Adapter()
        layoutManager = LinearLayoutManager(context)
    }

    inner class Adapter : RecyclerView.Adapter<Adapter.Holder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
            Holder(HomeItem(context, null))

        override fun onBindViewHolder(holder: Holder, position: Int) {
            data[position].also(holder::onBind)
        }

        override fun getItemCount(): Int = data.size

        inner class Holder(private val homeItem: HomeItem) : RecyclerView.ViewHolder(homeItem) {
            fun onBind(post: Post) {
                homeItem.data = post
                homeItem.setOnClickListener {
                    itemSelected {

                    }
                }
            }
        }
    }
}

interface ListenerTest {
    fun itemSelected(function: (Post) -> Unit): Post?
}
