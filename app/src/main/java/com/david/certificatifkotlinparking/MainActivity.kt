package com.david.certificatifkotlinparking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.accueil -> {
                val Accueil = Intent(this, MainActivity::class.java)
                startActivity(Accueil)
                true
            }
            R.id.places -> {
                val places = Intent(this, placesParkings::class.java)
                startActivity(places)
                true
            }
            R.id.placesLibres -> {
                val placesLibres = Intent(this, PlacesLibres::class.java)
                startActivity(placesLibres)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}