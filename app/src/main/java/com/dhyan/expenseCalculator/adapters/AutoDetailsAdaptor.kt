package com.dhyan.expenseCalculator.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dhyan.expenseCalculator.databinding.ItemAutoDetailsRecyBinding
import com.dhyan.expenseCalculator.models.AutoModel


class AutoDetailsAdaptor : RecyclerView.Adapter<AutoDetailsAdaptor.AutoDetailsViewHolder>() {
    inner class AutoDetailsViewHolder(val binding: ItemAutoDetailsRecyBinding): RecyclerView.ViewHolder(binding.root)
    private val differCallback = object : DiffUtil.ItemCallback<AutoModel>(){
        override fun areItemsTheSame(oldItem: AutoModel, newItem: AutoModel): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: AutoModel, newItem: AutoModel): Boolean {
            return oldItem==newItem
        }
    }
    val differ= AsyncListDiffer(this,differCallback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AutoDetailsViewHolder {
        val itemBinding =ItemAutoDetailsRecyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AutoDetailsViewHolder(itemBinding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: AutoDetailsViewHolder, position: Int) {


        val data =differ.currentList[position]

       holder.itemView.apply {
            holder.binding.IdAutoDetailsRecyAmountPaid.text="₹"+data.amount.toString()
            holder.binding.IdAutoDetailsRecyDate.text=data.date
            holder.binding.IdAutoDetailsRecySlNo.text=data.id.toString()
//            setOnClickListener{
//                onItemClickListener?.let { it(data) }
//            }
        }
    }



    private var onItemClickListener:((AutoModel)->Unit)?=null

    fun setOnItemClickListener(listener:(AutoModel)->Unit){
        onItemClickListener=listener
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}