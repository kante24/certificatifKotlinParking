package com.david.certificatifkotlinparking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView

class placesParkings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_places_parkings)

        val place1 : placeParking = placeParking ("A-34" ,"Sous-Sol 3", true, "David Kante", "P5W 9C0" );
        val place3 : placeParking = placeParking ("A-35" ,"Sous-Sol 3", true, "David Kante", "P5W 9C0" );
        val place4 : placeParking = placeParking ("A-36" ,"Sous-Sol 3", true, "David Kante", "P5W 9C0" );
        val place6 : placeParking = placeParking ("A-37" ,"Sous-Sol 3", false );
        val place2 : placeParking = placeParking ("A-38" ,"Sous-Sol 3", false );
        val place5 : placeParking = placeParking ("A-39" ,"Sous-Sol 3", false );
        val arrayPlaces : ArrayList<placeParking> = ArrayList()
        arrayPlaces.add(place1)
        arrayPlaces.add(place2)
        arrayPlaces.add(place3)
        arrayPlaces.add(place4)
        arrayPlaces.add(place5)
        arrayPlaces.add(place6)


        val myListAdapter = placeParkingArrayAdapteur(this,arrayPlaces)
        val listView = findViewById<ListView>(R.id.listViewParking);
        listView.adapter = myListAdapter
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