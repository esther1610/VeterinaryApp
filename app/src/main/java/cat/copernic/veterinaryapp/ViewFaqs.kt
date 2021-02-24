package cat.copernic.veterinaryapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import cat.copernic.veterinaryapp.dataBase.OperaciondBDfirebase_mascota
import cat.copernic.veterinaryapp.dataBase.OperacionesDBFirebase_Perfil
import cat.copernic.veterinaryapp.dataBase.OperacionsBDfirebase_Faqs
import cat.copernic.veterinaryapp.databinding.FragmentCliGestionMascotasBinding
import cat.copernic.veterinaryapp.databinding.FragmentCreaPreguntaBinding
import cat.copernic.veterinaryapp.databinding.FragmentViewUserBinding
import cat.copernic.veterinaryapp.modelos.FAQS
import cat.copernic.veterinaryapp.modelos.Mascota
import cat.copernic.veterinaryapp.modelos.Perfil
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ViewFaqs : Fragment() {

    var firebaseDatabase: FirebaseDatabase? = null
    var databaseReference: DatabaseReference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    lateinit var faqs : FAQS
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding= DataBindingUtil.inflate<FragmentCreaPreguntaBinding>(layoutInflater, R.layout.fragment_crea_pregunta, container, false)
        // Inflate the layout for this fragment
        faqs = FAQS()

        binding.faqs=faqs
        binding.butonGuardarBtnnn.setOnClickListener(){

            if(binding.pregunta .equals("")||binding.resposta.equals("")){
                //validacion()

                if (binding.pregunta.equals("")) {
                    binding.pregunta.setError("Required")
                } else if (binding.resposta.equals("")) {
                    binding.resposta.setError("Required")
                }

            } else {
                faqs.pregunta=binding.pregunta.text.toString()
                faqs.resposta=binding.resposta.text.toString()


                binding.pregunta.setText("")
                binding.resposta.setText("")
            }

            val opdiag =  OperacionsBDfirebase_Faqs()
            opdiag.guardar(faqs)

        }
        return binding.root


    }
}