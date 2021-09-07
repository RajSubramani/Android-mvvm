package com.tamil.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.tamil.R
import com.tamil.viewModel.MainViewModel
import com.tamil.viewModel.MainViewModelFactory
import com.tamil.viewModel.MainViewModelWithConstructor
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel;
    private lateinit var viewModelWithConstructor: MainViewModelWithConstructor
    private lateinit var viewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        setSupportActionBar(findViewById(R.id.toolbar))

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModelFactory = MainViewModelFactory("Awesome Pandi")
        viewModelWithConstructor =
            ViewModelProvider(this, viewModelFactory).get(MainViewModelWithConstructor::class.java)

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        btnTest.setOnClickListener {
            viewModel.displayName.value!!.add(System.currentTimeMillis().toString())
            viewModel.displayName.value = viewModel.displayName.value
        }

        viewModel.displayName.observe(this, Observer {
            tvLabel.text = it.toString()

        })

        tvTitle.text = viewModelWithConstructor.name
    }
}