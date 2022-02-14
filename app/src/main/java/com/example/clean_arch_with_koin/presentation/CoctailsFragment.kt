package com.example.clean_arch_with_koin.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clean_arch_with_koin.databinding.FragmentCoctailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class CoctailsFragment : Fragment(){


    private val coctailViewModel: CoctailViewModel by viewModel()
    private var _binding : FragmentCoctailsBinding? =null
    private val binding get() =_binding
    private val coctailAdapter= CoctailAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding= FragmentCoctailsBinding.inflate(inflater,container,false)

        return  binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setLayout()
        observeViewModel()

    }

    private fun observeViewModel() {
       coctailViewModel.coctails.observe(viewLifecycleOwner){
           var coctailDrinks =it?.drinks

           if (coctailDrinks != null) {
               coctailAdapter.drinks=coctailDrinks
               coctailAdapter.notifyDataSetChanged()
              // coctailAdapter.getCoctailData(coctailDrinks)

           }else{
               Toast.makeText(activity,"Error Occured",Toast.LENGTH_SHORT).show()
           }
       }

        coctailViewModel.error.observe(viewLifecycleOwner){
            Toast.makeText(activity,it,Toast.LENGTH_SHORT).show()
        }
    }

    private fun setLayout() {
        binding?.coctailrecycler?.apply {
            setHasFixedSize(true)
            layoutManager=LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter=coctailAdapter
        }
        coctailViewModel.getCoctails("margarita")
    }


}
