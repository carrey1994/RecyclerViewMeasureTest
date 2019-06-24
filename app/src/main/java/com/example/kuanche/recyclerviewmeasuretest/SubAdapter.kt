package com.example.kuanche.recyclerviewmeasuretest

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class SubAdapter(private val context: Context, private val data: List<Movie>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val type = p1
        lateinit var mViewHolder: RecyclerView.ViewHolder
        when (type) {
            1 -> mViewHolder = SpSubVH(LayoutInflater.from(context).inflate(R.layout.item_sub_sp, null, false))
            0 -> mViewHolder = SubVH(LayoutInflater.from(context).inflate(R.layout.item_sub, null, false))
        }
        return mViewHolder
    }

    override fun getItemViewType(position: Int): Int {
        return when (data[position].isNew) {
            /**過於複雜的View樣式可以切換不同ItemView達到效果**/
            true -> 1
            else -> 0
        }
    }

    inner class SubVH(view: View) : RecyclerView.ViewHolder(view) {
        val ivPoster: ImageView by lazy {
            view.findViewById<ImageView>(R.id.iv_poster)
        }
        val rlMovie: RelativeLayout by lazy {
            view.findViewById<RelativeLayout>(R.id.rl_movie)
        }
    }

    inner class SpSubVH(view: View) : RecyclerView.ViewHolder(view) {
        val ivPoster: ImageView by lazy {
            view.findViewById<ImageView>(R.id.iv_poster)
        }
        val tvNew by lazy {
            view.findViewById<TextView>(R.id.tv_new)
        }
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {

        when (p0) {
            is SpSubVH -> {
                p0.ivPoster.setBackgroundResource(data[p1].poster)
                p0.tvNew.setOnClickListener { Toast.makeText(context, "This is New", Toast.LENGTH_LONG).show() }
            }
            is SubVH -> {
                p0.ivPoster.setBackgroundResource(data[p1].poster)
                if ("HIDE" == data[p1].type) {
                    p0.itemView.visibility = View.GONE
                    //上述方法會發現該ItemView會消失，但只是inVisible而非Gone所以仍有佔位問題
                    /**用在MainAdapter時隱藏Day2那方法也無效**/
                    val params = RecyclerView.LayoutParams(0, 0)
                    p0.itemView.layoutParams = params
                    //如果允許，那果斷回MainAdapter重新設定SubAdapter的List(EX.移除玩具總動員)比較快= =||
                }
            }
        }
    }


}