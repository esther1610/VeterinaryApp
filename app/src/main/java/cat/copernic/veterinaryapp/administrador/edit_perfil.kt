package cat.copernic.veterinaryapp.administrador

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cat.copernic.veterinaryapp.modelos.Perfil
import cat.copernic.veterinaryapp.R


/**
 * A simple [Fragment] subclass.
 * Use the [edit_perfil.newInstance] factory method to
 * create an instance of this fragment.
 */
class edit_perfil : Fragment() {
    private lateinit var perfil: Perfil //Donde se almacenaran los datos del perfil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_perfil, container, false)
    }

}