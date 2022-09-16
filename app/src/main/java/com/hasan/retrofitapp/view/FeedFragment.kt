package com.hasan.retrofitapp.view



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.hasan.retrofitapp.BR


import com.hasan.retrofitapp.adapter.RetrofitAdapter
import com.hasan.retrofitapp.databinding.FragmentFeedBinding
import com.hasan.retrofitapp.model.Model
import com.hasan.retrofitapp.viewmodel.FeedViewModel


class FeedFragment : Fragment() {

    private lateinit var binding: FragmentFeedBinding
    private lateinit var viewModel : FeedViewModel
    private  var retrofitAdapter=RetrofitAdapter(arrayListOf())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFeedBinding.inflate(inflater)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //super.onViewCreated(view, savedInstanceState)

           viewModel = ViewModelProviders.of(this@FeedFragment)[FeedViewModel::class.java]
           viewModel.getDataFromApi()


          binding.recyclerView.layoutManager = GridLayoutManager(context,2)
          binding.recyclerView.addItemDecoration(SpacesItemDecoration(10))




           observerLiveData()

    }

    private fun observerLiveData(){
        viewModel.fieldsMars.observe(viewLifecycleOwner, Observer { fields->
            fields?.let {
               binding.setVariable(BR.adapter,retrofitAdapter)
                retrofitAdapter.updateCountryList(fields as ArrayList<Model> /* = java.util.ArrayList<com.hasan.retrofitapp.model.Model> */) /* = java.util.ArrayList<com.hasan.retrofitapp.model.Model> */



            }

        })
    }
}