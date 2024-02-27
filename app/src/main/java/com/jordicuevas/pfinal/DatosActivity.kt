package com.jordicuevas.pfinal

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jordicuevas.pfinal.databinding.ActivityDatosBinding
import com.jordicuevas.pfinal.databinding.ActivityMainBinding

class DatosActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDatosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var usuario = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("EXTRA_USER", Usuario::class.java) as Usuario
        } else {
            intent.getSerializableExtra("EXTRA_USER") as Usuario
        }

        if (usuario != null){
            binding.resNombre.text = usuario.nombre
            binding.resApellido.text = usuario.apellido
            binding.resSexo.text = usuario.genero
            binding.resCorreo.text = usuario.correo
            binding.resPass.text = usuario.password
        }else{
            binding.resNombre.text = "Error Interno"
        }

    }
}