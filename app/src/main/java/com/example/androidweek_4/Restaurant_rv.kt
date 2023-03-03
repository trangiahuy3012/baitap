package com.example.androidweek_4
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import android.widget.ImageButton
import android.widget.Switch
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidweek_4.databinding.RvLayoutBinding

class Restaurant_rv : AppCompatActivity(){

    lateinit var binding: RvLayoutBinding
    lateinit var adapter: RestaurantAdapter
    lateinit var adapter_grid: RestaurantAdapterGrid
    //viewmodel
    lateinit var viewModel: RestaurantVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.rv_layout)
        viewModel = ViewModelProvider(this)[RestaurantVM::class.java]

        //viewModel.loadData()
        setUpRecyclerView()
        viewModel.loadData()
        binding.menuswitch.setOnClickListener{view ->
            var checked = (view as Switch).isChecked
            if (!checked) {
                setUpRecyclerView()
                viewModel.loadData()
            } else {
                setUpRecyclerViewGrid()
                viewModel.loadData()
            }

        }
        setUpButtonLoad()
        registerDataEvent()
        registerLoadingView()


    }

    private fun setUpRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RestaurantAdapter()
        adapter_grid = RestaurantAdapterGrid()
        binding.recyclerView.adapter = adapter
    }
    private fun setUpRecyclerViewGrid() {
        binding.recyclerView.layoutManager = GridLayoutManager(this, 3)
        adapter = RestaurantAdapter()
        adapter_grid = RestaurantAdapterGrid()
        binding.recyclerView.adapter = adapter_grid
    }

    private fun setUpButtonLoad() {
        binding.btnLoad.setOnClickListener {
            viewModel.loadData()
        }
    }

    private fun registerDataEvent() {
        viewModel.listOfIdol.observe(this, Observer { data ->
            run {
                adapter.setData(data)
                adapter_grid.setData(data)
            }
        })
    }

    private fun registerLoadingView() {
        viewModel.isLoading.observe(this) { isLoading ->
            run {
                binding.progressBar.visibility =
                    if (isLoading) View.VISIBLE else
                        View.INVISIBLE
            }
        }
    }
}