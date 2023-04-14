package org.diyorbek.recyclerviewanim_dragdrop_h1

import android.content.ClipData.Item
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import org.diyorbek.recyclerviewanim_dragdrop_h1.adapter.ItemAdapter
import org.diyorbek.recyclerviewanim_dragdrop_h1.adapter.itemTouchHelper
import org.diyorbek.recyclerviewanim_dragdrop_h1.databinding.ActivityMainBinding
import org.diyorbek.recyclerviewanim_dragdrop_h1.util.Constants

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val itemList = mutableListOf<Item>()
    private val itemAdapter by lazy { ItemAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        itemTouchHelper.attachToRecyclerView(binding.recyclerView)

        binding.recyclerView.apply {
            adapter = itemAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        itemAdapter.itemList = Constants.list()

    }
}