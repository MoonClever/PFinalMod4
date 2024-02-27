package com.jordicuevas.pfinal

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jordicuevas.pfinal.databinding.FragmentRegistroBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegistroFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegistroFragment : Fragment() {
    private lateinit var binding : FragmentRegistroBinding
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegistroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        binding.btSend.setOnClickListener {
            val nombre = binding.etNombre.text
            val apellido = binding.etApellido.text
            val genero = when (binding.rgGenero.checkedRadioButtonId) {
                R.id.rbHombre -> "Hombre"
                R.id.rbMujer -> "Mujer"
                else -> "No seleccionado"
            }
            val correo = binding.etCorreo.text
            val pass = binding.etPassword.text

            if (nombre.isEmpty() || apellido.isEmpty() || genero === "No seleccionado" || correo.isEmpty() || pass.isEmpty()) {
                binding.tvError.text = "Por favor llene todos los campos"
            } else {
                val usuario = Usuario(
                    nombre.toString(),
                    apellido.toString(),
                    correo.toString(),
                    genero,
                    pass.toString()
                )
                val datosIntent = Intent(requireContext(), DatosActivity::class.java).apply {
                    putExtra("EXTRA_USER", usuario)
                }
                startActivity(datosIntent)

            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegistroFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            RegistroFragment()
    }
}