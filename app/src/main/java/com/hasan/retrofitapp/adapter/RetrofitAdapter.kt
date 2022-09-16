package com.hasan.retrofitapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hasan.retrofitapp.R
import com.hasan.retrofitapp.databinding.RecyclerRowItemBinding
import com.hasan.retrofitapp.model.Model
import com.hasan.retrofitapp.util.downloadFromUrl
import com.hasan.retrofitapp.util.placeholderProgressBar
import com.hasan.retrofitapp.view.FeedFragmentDirections



class RetrofitAdapter(val modelList: ArrayList<Model>): RecyclerView.Adapter<RetrofitAdapter.RetrofitViewHolder>(){

    class RetrofitViewHolder(val binding:RecyclerRowItemBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<RecyclerRowItemBinding>(inflater,R.layout.recycler_row_item,parent,false)
        return  RetrofitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
        /*holder.binding.itemRowImage.downloadFromUrl(modelList[position].img_src,
            placeholderProgressBar(holder.itemView.context))*/

        holder.binding.model = modelList[position]

        holder.itemView.setOnClickListener {
               val action = FeedFragmentDirections.actionFeedFragmentToDetailFragment()
               Navigation.findNavController(it).navigate(action)
        }


    }

    override fun getItemCount(): Int {
      return  modelList.size
    }

    fun updateCountryList(newCountryList: ArrayList<Model>) {
        modelList.clear()
        modelList.addAll(newCountryList)
        notifyDataSetChanged()
    }
}