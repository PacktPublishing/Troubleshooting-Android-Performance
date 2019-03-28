package com.packt.moviesshowcase

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.packt.moviesshowcase.Genre.*
import com.squareup.leakcanary.LeakCanary

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        LeakCanary.install(application)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movies = arrayListOf(
            Movie(0, "Top Gun", R.drawable.topgun, ACION),
            Movie(1, "The Lego Movie", R.drawable.lego, FAMILY),
            Movie(2, "Frozen", R.drawable.frozen, FAMILY),
            Movie(3, "Up", R.drawable.up, FAMILY),
            Movie(4, "Me, Myself & Irene", R.drawable.memyself, COMEDY),
            Movie(5, "He Got Game", R.drawable.hegotgame, SPORTS),
            Movie(6, "Batman", R.drawable.batman, ACION),
            Movie(7, "Mighty Ducks", R.drawable.mightyducks, SPORTS),
            Movie(8, "Billy Madison", R.drawable.billymadison, COMEDY),
            Movie(9, "Bohemian Rhapsody", R.drawable.bohemian, DRAMA),
            Movie(10, "Trolls", R.drawable.trolls, FAMILY),
            Movie(11, "The Mask", R.drawable.themask, COMEDY),
            Movie(12, "Catch Me If You Can", R.drawable.catchmeifyoucan, DRAMA),
            Movie(13, "Titanic", R.drawable.titanic, DRAMA),
            Movie(14, "The Equalizer", R.drawable.equalizer, DRAMA),
            Movie(15, "Star Wars", R.drawable.starwars, SCIFI)
        )

        val spotlight = findViewById<MovieView>(R.id.spotlight)
        spotlight.setName("Top Gun")
        spotlight.setPosterResource(R.drawable.topgun)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))
        recyclerView.adapter = MoviesAdapter(this, movies)

        val isBatmanInList = SampleClass.isMovieInList(movies, Movie(-1, "Batman", R.drawable.batman, ACION))

//        val rootView = findViewById<ConstraintLayout>(R.id.root)

//        while (true) {
//            rootView.addView(TextView(this))
//        }

//        keepInvoking()
    }

    private fun keepInvoking() {
        keepInvoking()
    }


    private fun forLoopSample() {

        val sampleList = arrayListOf<String>()

        sampleList.forEachIndexed { index, string ->
            Log.d("tag", "This item is " + string + " and it is the " + index + "th item")
        }

    }
}
