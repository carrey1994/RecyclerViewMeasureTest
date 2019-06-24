package com.example.kuanche.recyclerviewmeasuretest

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MainAdapter(val context: Context, val data: List<Movie>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mPosition = -1

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_main, null, false)
        return MainViewHolder(view)
    }

    internal inner class MainViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val rvSub: RecyclerView by lazy {
            view.findViewById<RecyclerView>(R.id.rv_sub)
        }
        val tvTitle: TextView by lazy {
            view.findViewById<TextView>(R.id.tv_title)
        }
        private val selectListener = View.OnClickListener {
            //藉由每此點擊itemView變更mPosition達到單選效果
            mPosition = adapterPosition
            notifyDataSetChanged()
        }

        init {
            itemView.setOnClickListener(selectListener)
        }
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        val holder = p0 as MainViewHolder

        /**清單不變，但第二層的itemView無法隱藏**/
        holder.rvSub.adapter = SubAdapter(context, data)
        /**將玩具總動員2移除清單**/
//        holder.rvSub.adapter = SubAdapter(context, filterHideData())

        holder.rvSub.setHasFixedSize(true)
        val mg = GridLayoutManager(context, 4)
        holder.rvSub.layoutManager = mg
        holder.tvTitle.text = data[p1].name
        if (data[p1].name == "Day2") {
            holder.itemView.visibility = View.GONE
            //只用上面方法Day2只是Invisible仍會佔位
            /**要加上layoutParam才能有效讓Day2的畫面隱藏起來**/
//            holder.itemView.layoutParams = RecyclerView.LayoutParams(0, 0)
        }
        holder.tvTitle.isSelected = (p1 == mPosition)
    }

    private fun filterHideData(): List<Movie> {
        return data.filter { it.type != "HIDE" }
    }


}