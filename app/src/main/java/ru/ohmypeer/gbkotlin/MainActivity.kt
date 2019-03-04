package ru.ohmypeer.gbkotlin

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.res.Configuration
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import ru.ohmypeer.gbkotlin.data.Note
import ru.ohmypeer.gbkotlin.ui.MainViewModel
import ru.ohmypeer.gbkotlin.ui.RVAdapter

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var adapter: RVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        when (resources.configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> rv_main.layoutManager = LinearLayoutManager(this)
            else -> rv_main.layoutManager = GridLayoutManager(this, 2)
        }
        adapter = RVAdapter()
        rv_main.adapter = adapter

        viewModel.viewState().observe(this, Observer<List<Note>> { t ->
            t?.let { adapter.notes = it }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
            when (item.itemId) {
                R.id.action_settings -> true
                else -> super.onOptionsItemSelected(item)
            }

}
