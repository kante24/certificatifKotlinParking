package com.david.certificatifkotlinparking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog

class PlacesLibres : AppCompatActivity() {

    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_places_libres)

        //Création places de parkings
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



        val temArrayPlace : ArrayList<placeParking> = ArrayList()
        for(placeParking in arrayPlaces)
        {
            if(placeParking.Statut == false)
            {
                temArrayPlace.add(placeParking)
            }
        }

        val myListAdapter = placeParkingArrayAdapteur(this,temArrayPlace)
        listView = findViewById(R.id.listViewParking);
        listView.adapter = myListAdapter

        listView.setOnItemClickListener{
                parent, view, position, id ->
            //Place actuelle
//            val tempPLace: placeParking = temArrayPlace[position]
//            Toast.makeText(this, temArrayPlace[position].Numero, Toast.LENGTH_SHORT).show()

//            if(temArrayPlace.contains(temArrayPlace[position]))
//            {
////                            Toast.makeText(this, "You have Clicked " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show()
                //Affichage de l'alert dialog modale
                val dialogView = LayoutInflater.from(this).inflate(R.layout.ajout_dialog, null)
                val dialogbuilder = AlertDialog.Builder(this).setView(dialogView).setTitle("Occupation de la place de parking")
                val alertDialog =  dialogbuilder.show()

                //Click bouton annuler
                val btnAnnuler =dialogView.findViewById<Button>(R.id.btnAnnuler)
                btnAnnuler.setOnClickListener {
                    alertDialog.dismiss()
                }

                //Click bouton annuler
                val btnOccuper =dialogView.findViewById<Button>(R.id.btnOccuper)
                btnOccuper.setOnClickListener {
                    val nom = alertDialog.findViewById<EditText>(R.id.Nom)
                    val immatriculation = alertDialog.findViewById<EditText>(R.id.Nom).toString()
                    if (nom != null) {
                        temArrayPlace[position].nomOccupant = nom.text.toString()
                        temArrayPlace[position].Statut = true
                        myListAdapter.notifyDataSetChanged()
                        alertDialog.dismiss()
                    }
                }

//            }
        }
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
                val intentSup = Intent(this, PlacesLibres::class.java)
                startActivity(intentSup)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }




}
