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
            Movie(0, "Top Gun", "https://image.tmdb.org/t/p/original/kff36GWyYeArAkW6x9G9LJesXn7.jpg", ACION),
            Movie(1, "The Lego Movie", "https://image.tmdb.org/t/p/original/wPRiV4TVpRCV2es81q0S1eRaUbm.jpg", FAMILY),
            Movie(2, "Frozen", "https://image.tmdb.org/t/p/original/irHmdlkdJphmk4HPfyAQfklKMbY.jpg", FAMILY),
            Movie(3, "Up", "https://image.tmdb.org/t/p/original/h8C7KZwCJO5DN7jPifc7AoIjx7k.jpg", FAMILY),
            Movie(4, "Me, Myself & Irene", "https://image.tmdb.org/t/p/original/tOIs4Em9iFBSAGLjndZEP3Bj25r.jpg", COMEDY),
            Movie(5, "He Got Game", "https://image.tmdb.org/t/p/original/1bm55fptJb2MusLsMoAr3hmQSyO.jpg", SPORTS),
            Movie(6, "Batman", "https://image.tmdb.org/t/p/original/hqkIcbrOHL86UncnHIsHVcVmzue.jpg", ACION),
            Movie(7, "Mighty Ducks", "https://image.tmdb.org/t/p/original/3aZcwu5JQMxNrxt4uoIqA29zqbV.jpg", SPORTS),
            Movie(8, "Billy Madison", "https://image.tmdb.org/t/p/original/fo49glajVv0iyudKzKpngd2979z.jpg", COMEDY),
            Movie(9, "Bohemian Rhapsody", "https://image.tmdb.org/t/p/original/pbXgLEYh8rlG2Km5IGZPnhcnuSz.jpg", DRAMA),
            Movie(10, "Trolls", "https://image.tmdb.org/t/p/original/nEEOK0RhDjOfzmYbFUjVGvMbnjX.jpg", FAMILY),
            Movie(11, "The Mask", "https://image.tmdb.org/t/p/original/dXviP88UuC3qkrQhTGcbYAOreyu.jpg", COMEDY),
            Movie(12, "Catch Me If You Can", "https://image.tmdb.org/t/p/original/yB1crGNo6ZmelA3WPuW0mOzFbqV.jpg", DRAMA),
            Movie(13, "Titanic", "https://image.tmdb.org/t/p/original/xqQztbT6KlPLQLlRtNHoXivEMZA.jpg", DRAMA),
            Movie(14, "The Equalizer", "https://image.tmdb.org/t/p/original/vbl4ZVqelrrzJ16fdDOq9siWbpi.jpg", DRAMA),
            Movie(15, "Star Wars", "https://image.tmdb.org/t/p/original/koE7aMeR2ATivI18mCbscLsI0Nm.jpg", SCIFI)
        )

        val spotlight = findViewById<MovieView>(R.id.spotlight)
        spotlight.setName("Top Gun")
        spotlight.setPosterResource(R.drawable.topgun)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))
        recyclerView.adapter = MoviesAdapter(this, movies)

        Log.d("MainActivity", "I am in thread: " + Thread.currentThread().name)

        Thread(Runnable {
            val a = 1
            Log.d("MainActivity", "I am in thread: " + Thread.currentThread().name)
        }, "My Cool Thread").start()

//        val isBatmanInList = SampleClass.isMovieInList(movies, Movie(-1, "Batman", R.drawable.batman, ACION))

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
