package com.example.myapplication

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Adapter.CardViewHeroAdapter
import com.example.myapplication.Adapter.GridHeroAdapter
import com.example.myapplication.Adapter.ListHeroAdapter

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var rvHeroes: RecyclerView
    private var title: String = "Mode List"

    //memanggil data yang sudah dibuat pada HeroesData.kt
    private var list: ArrayList<Hero> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)

        list.addAll(HeroesData.lisData)
        setActionBarTitle(title)
        showRecyclerList()
    }

    // List Layout
    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rvHeroes.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : ListHeroAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Hero) {
                showSelectedHero(data)
            }
        })
    }

    // Grid Layout
    private fun showRecyclerGrid() {
        rvHeroes.layoutManager = GridLayoutManager(this, 2)
        val gridHeroAdapter = GridHeroAdapter(list)
        rvHeroes.adapter = gridHeroAdapter
        gridHeroAdapter.setOnItemClickCallback(object : GridHeroAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Hero) {
                showSelectedHero(data)
            }
        })
    }

    // CardView Layout
    private fun showRecyclerCardView() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val cardViewHeroAdapter = CardViewHeroAdapter(list)
        rvHeroes.adapter = cardViewHeroAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectItem: Int) {
        when (selectItem) {
            R.id.action_list -> {
                title = "Mode List"
                showRecyclerList()
            }
            R.id.action_grid -> {
                title = "Mode Grid"
                showRecyclerGrid()
            }
            R.id.action_cardview -> {
                title = "Mode CardView"
                showRecyclerCardView()
            }
        }
        setActionBarTitle(title)
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#ffffff")))
    }

    private fun showSelectedHero(hero: Hero) {
        Toast.makeText(this, "Kamu memilih " + hero.name, Toast.LENGTH_SHORT).show()
    }
}