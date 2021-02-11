package cat.copernic.veterinaryapp

import android.content.BroadcastReceiver
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import cat.copernic.veterinaryapp.databinding.FragmentViewUserBinding
import cat.copernic.veterinaryapp.Perfil
import java.time.LocalDateTime
import java.util.*


class ViewUser : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
    lateinit var perfil : Perfil
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var binding = DataBindingUtil.inflate<FragmentViewUserBinding>(layoutInflater, R.layout.fragment_view_user, container, false)
        //Aqui se tinenque recuperar los datos y asignarlos a perfil para que se muestren en pantalla
        perfil = Perfil("Jose","Colacios")
        binding.perfil = perfil //Paso el perfil a la vista del fragment

        binding.buttonSave.setOnClickListener {
            var comprobar = Comprobaciones() //Inicializo la clase de comprobaciones

            //Pasar el contenido de los text a el data class
            if (comprobar.contieneTexto(binding.EditTextNom.text.toString()))//Comprueba que tiene texto
                perfil.nombre = binding.EditTextNom.text.toString()

            //perfil.fecha_nac = binding.EditTextDataN.text.toString() //Hay que pasarlo a fecha
            perfil.usuario = binding.EditTextUsuari.text.toString() //Hay que recuperar el mail de user actual, con sharedPreferences y el campo dejarlo en bloqueado para la no edición
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
            val opdiag = OperacionesDBFirebase_Perfil()
            opdiag.guardar(perfil)
        }

        return binding.root
    }

}