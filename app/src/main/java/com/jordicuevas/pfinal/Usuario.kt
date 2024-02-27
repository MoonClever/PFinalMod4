package com.jordicuevas.pfinal

import java.io.Serializable

data class Usuario(var nombre : String,
                   var apellido : String,
                   var correo : String,
                   var genero : String,
                   var password : String
): Serializable
