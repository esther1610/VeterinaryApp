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

        //Da error de momento al pasar los datos ...

        val binding = DataBindingUtil.inflate<FragmentViewUserBinding>(layoutInflater, R.layout.fragment_view_user, container, false)
       /* perfil.direccion =""
        perfil.apellidos = "test"
        perfil.dni = "555454"
        perfil.nombre = "Jose"
        perfil.rol = "cliente"
        perfil.usuario = "s@s.com"
*/






        binding.buttonSave.setOnClickListener {
            //Toast.makeText(container, binding.perfil.nombre.toString(), Toast.LENGTH_LONG).show()
            Toast.makeText(this.getActivity(),"Hola",Toast.LENGTH_LONG).show()
        }

        return binding.root
    }

}