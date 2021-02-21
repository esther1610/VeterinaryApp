package cat.copernic.veterinaryapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import cat.copernic.veterinaryapp.databinding.FragmentViewUserBinding
import cat.copernic.veterinaryapp.dataBase.OperacionesDBFirebase_Perfil
import cat.copernic.veterinaryapp.modelos.Perfil


class ViewUser : Fragment() {
    lateinit var perfil : Perfil
    lateinit var binding: DataBindingUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }



    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val opdiag = OperacionesDBFirebase_Perfil()
        var binding = DataBindingUtil.inflate<FragmentViewUserBinding>(layoutInflater, R.layout.fragment_view_user, container, false)
        //Aqui se tinenque recuperar los datos y asignarlos a perfil para que se muestren en pantalla
        var emailsp = recuperarDatosPreferences() //Busco el mail del usuario logueado

        var perfilBusqueda: Perfil = Perfil()
        perfilBusqueda.usuario = emailsp.toString() //Creo un perfil que se utiliza para buscar unicamente con el email que se ha obtenido de la memoria del telefono

        perfil = opdiag.buscar(perfilBusqueda)


        val mostrar: Perfil = opdiag.buscar(perfilBusqueda)


        binding.perfil = mostrar

        binding.buttonSave.setOnClickListener {
            var comprobar = Comprobaciones() //Inicializo la clase de comprobaciones

            //Pasar el contenido de los text a el data class
            if (comprobar.contieneTexto(binding.EditTextNom.text.toString()))//Comprueba que tiene texto
                perfil.nombre = binding.EditTextNom.text.toString()

            //perfil.fecha_nac = binding.EditTextDataN.text.toString() //Hay que pasarlo a fecha
            perfil.usuario = perfilBusqueda.usuario.toString() //binding.EditTextUsuari.text.toString() //Hay que recuperar el mail de user actual, con sharedPreferences y el campo dejarlo en bloqueado para la no edición
            //perfil.rol el user no puede editar el rol
            perfil.dni = binding.EditTextDni.text.toString() //El dni tampoco lo deberia modificar el usuario, unicamente recuperar la info
            if (comprobar.contieneTexto(binding.EditTextDir.text.toString()))//Comprueba que tiene texto
                perfil.direccion = binding.EditTextDir.text.toString()
            if (comprobar.contieneTexto(binding.EditTextCognoms.text.toString()))//Comprueba que tiene texto
                perfil.apellidos = binding.EditTextCognoms.text.toString()
            //perfil.foto //clase foto por hacer
            if (comprobar.validarMovil(binding.EditTextTel.text.toString()))
                perfil.telefono = binding.EditTextTel.text.toString()
            else
                //Mensaje numero no valido, cambiarlo por un mensaje emergente.
                Toast.makeText(activity, "Número de telefono no valido", Toast.LENGTH_LONG).show()

            //Añadir los datos a la base de datos
            //val opdiag = OperacionesDBFirebase_Perfil()
            Log.e("Jose","Aqui llega")
            opdiag.guardar(perfil)
        }

        return binding.root
    }

    /**
     * Recuperar los datos del cliente
     *
     */
    fun recuperarDatosPreferences(): String? {
        val preferencias: SharedPreferences? =
            this.activity?.getSharedPreferences("credenciales", Context.MODE_PRIVATE)
        val emailSP: String? = preferencias?.getString("email","Sin datos")
        return emailSP
    }
}