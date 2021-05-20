package com.biodun.abetterwayassigment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import com.biodun.abetterwayassigment.databinding.ActivityCategoryBinding
import com.biodun.abetterwayassigment.databinding.ActivityMainBinding
import com.biodun.abetterwayassigment.databinding.CategoryRecyclerItemBinding

class CategoryActivity : AppCompatActivity() {


    private lateinit var binding: ActivityCategoryBinding
    var adapter: CategoryAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setUpCategories(binding)
    }

    private fun setUpCategories(binding: ActivityCategoryBinding) {
        adapter = CategoryAdapter(this, CategoryData.categories) { category: Category ->
            clickedCategoryViews(category)
        }

        Log.e("VeryKinky", CategoryData.categories.toString())
        val recyclerView = binding.categoryRv

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = adapter


    }

    private fun clickedCategoryViews ( clickedView : Category) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("categoryToolbarTitle", clickedView.categoryName )
        startActivity(intent)
    }
}