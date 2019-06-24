package com.example.kuanche.recyclerviewmeasuretest

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class BottomSheetTextAdapter(val context: Context, val data: List<String>) :
	RecyclerView.Adapter<RecyclerView.ViewHolder>() {
	
	override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
		val view = LayoutInflater.from(context).inflate(R.layout.item_center_text, null, false)
		return TextVH(view)
	}
	
	inner class TextVH(view: View) : RecyclerView.ViewHolder(view) {
		val tvContent: TextView by lazy {
			view.findViewById<TextView>(R.id.tvContent)
		}
	}
	
	override fun getItemCount(): Int = data.size
	
	override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
		val holder = p0 as TextVH
		holder.tvContent.text = data[p1]
	}
}