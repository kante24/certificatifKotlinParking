package com.david.certificatifkotlinparking

import android.app.Activity
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.*

class placeParkingArrayAdapteur(private val context: Activity, var places: ArrayList<placeParking>)
    : ArrayAdapter<placeParking>(context, R.layout.layout_place, places) {

    init {
        places = places
    }


    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        //PLace actuelle
        val tempPLace: placeParking = places[position]
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.layout_place, parent, false)

        val numero = rowView.findViewById(R.id.lblNumero) as TextView
        val occupant = rowView.findViewById(R.id.lblNomOccupant) as TextView
        val statut = rowView.findViewById(R.id.lblStatut) as TextView
        val localisation = rowView.findViewById(R.id.lblLocalisation) as TextView

        numero.text = "Numero de Place= " + tempPLace.Numero
        localisation.text = "Localisation = " +  tempPLace.Localisation

        if(tempPLace.Statut==false)
        {
            numero.setTextColor(Color.BLACK);
            occupant.setTextColor(Color.BLACK);
            statut.setTextColor(Color.BLACK);
            localisation.setTextColor(Color.BLACK);
            statut.text =  "Libre"
            occupant.text = "Aucun aucupant pour le moment"
        }
        else
        {
            numero.setTextColor(Color.GRAY);
            occupant.setTextColor(Color.GRAY);
            statut.setTextColor(Color.GRAY);
            localisation.setTextColor(Color.GRAY);
            statut.text =  "Immatriculation Occupant = " +  tempPLace.immatriculation
            occupant.text = "Nom de l'Occupant = " +  tempPLace.nomOccupant
        }

        return rowView
    }
}