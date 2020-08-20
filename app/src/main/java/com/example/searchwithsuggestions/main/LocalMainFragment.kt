package com.mrk.compaq.application.local.ui.main

import android.R
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.searchwithsuggestions.databinding.LocalMainFragmentBinding
import kotlinx.android.synthetic.main.local_main_fragment.*

class LocalMainFragment : Fragment() {

    companion object {
        fun newInstance() = LocalMainFragment()
    }
    lateinit var biniding:LocalMainFragmentBinding

    private lateinit var viewModel: Local_MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        biniding= LocalMainFragmentBinding.inflate(inflater,container,false)
        setHasOptionsMenu(true)
        return  biniding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(requireActivity()).get(Local_MainViewModel::class.java)

        viewModel.data.observe(requireActivity(), Observer {
        val list=  it.map {model ->

              model.query
          }
            initialize(list as ArrayList<String>)

        })
    }


    private fun initialize(items:ArrayList<String>){

        val itemsAdapter: ArrayAdapter<String> = ArrayAdapter<String>(requireActivity(), R.layout.simple_list_item_1, items)
        listview.adapter=itemsAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val searchView: SearchView = item.getActionView() as SearchView
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.e("TAG", "onQueryTextSubmit: " )
                query?.let { viewModel.insert(it) }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
        return super.onOptionsItemSelected(item)

    }


}