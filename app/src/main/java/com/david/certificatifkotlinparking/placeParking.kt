package com.david.certificatifkotlinparking

import java.time.LocalDate

class placeParking (var Numero: String, var Localisation: String, var Statut:Boolean?, var nomOccupant:String, var immatriculation: String )
{
    //Au cas où aucun occupant
    constructor(Numero: String,Localisation: String,Statut:Boolean?):this( Numero, Localisation, false, "/na","/na" )
    init
    {
        this.Numero = Numero
        this.Localisation = Localisation
        this.Statut = Statut
        this.nomOccupant = nomOccupant
        this.immatriculation = immatriculation
    }
}