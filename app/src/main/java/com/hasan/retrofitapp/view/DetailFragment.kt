package com.hasan.retrofitapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.hasan.retrofitapp.databinding.FragmentDetailBinding
import com.hasan.retrofitapp.model.Model
import com.hasan.retrofitapp.viewmodel.DetailViewModel

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: DetailViewModel
    private var fieldId = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            fieldId = DetailFragmentArgs.fromBundle(it).filedUuid
        }
        viewModel = ViewModelProviders.of(this@DetailFragment)[DetailViewModel::class.java]
        viewModel.getDataFromRoom(fieldId)

        observeLiveData()
    }

    private fun observeLiveData(){
        viewModel.fieldLiveData.observe(viewLifecycleOwner, Observer { field->
            field?.let {
                binding.selectField = field
            }
        })
    }
}