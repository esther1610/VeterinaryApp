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
import cat.copernic.veterinaryapp.modelos.Perfil
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*


class ViewUser : Fragment() {
    private lateinit var binding: FragmentViewUserBinding
    private val db = FirebaseFirestore.getInstance()
    lateinit var perfil : Perfil


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentViewUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Recupera los datos del usuario logueado
        val email = recuperarDatosPreferences().toString()
        //Envia el mail para recuperar los datos del perfil
        Log.e("Jose",email.toString())
        genUI(email)


    }

    /**
     * Recupera los datos de la base de datos y envia a cada campo correspondiente del fragment para mostrar los datos
     */
    fun genUI(email: String) {
        db.collection("Perfil").document(email).get().addOnSuccessListener {
            //llenar los campos correspondientes del fragment con los datos recuperados de la db
            binding.lvlRol.setText(it.get("rol") as String?)
            binding.EditTextUsuari.setText(it.get("usuario") as String?)
            binding.EditTextNom.setText(it.get("nombre") as String?)
            binding.EditTextCognoms.setText(it.get("apellidos") as String?)
            binding.EditTextDataN.setText(it.get("fecha_nacimiento") as String?)
            binding.EditTextTel.setText(it.get("telefono") as String?)
            binding.EditTextDir.setText(it.get("direccion") as String?)
            binding.EditTextDni.setText(it.get("dni") as String?)
        }
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