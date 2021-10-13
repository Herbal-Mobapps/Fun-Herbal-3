package com.fiqih.ta_funherbal.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.fiqih.ta_funherbal.R
import com.fiqih.ta_funherbal.databinding.ItemListBinding
import com.fiqih.ta_funherbal.model.TanamanData
import com.fiqih.ta_funherbal.view.TanamanActivity2

class TanamanAdapter (
    var c: Context, var tanamanList:ArrayList<TanamanData>
): RecyclerView.Adapter<TanamanAdapter.TanamanViewHolder>()
{
    inner class TanamanViewHolder(var v : ItemListBinding): RecyclerView.ViewHolder(v.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TanamanViewHolder {
        val inflter = LayoutInflater.from(parent.context)
        val v = DataBindingUtil.inflate<ItemListBinding>(
            inflter, R.layout.item_list,parent,
            false)
        return TanamanViewHolder(v)

    }

    override fun onBindViewHolder(holder: TanamanViewHolder, position: Int) {
        val newList = tanamanList[position]
        holder.v.isTanaman = tanamanList[position]
        holder.v.root.setOnClickListener {
            val img = newList.img
            val name = newList.name
            val info = newList.info

            /**set Data*/
            val mIntent = Intent(c,TanamanActivity2::class.java)
            mIntent.putExtra("img",img)
            mIntent.putExtra("name",name)
            mIntent.putExtra("info",info)
            c.startActivity(mIntent)
        }
    }

    override fun getItemCount(): Int {
        return  tanamanList.size
    }



}