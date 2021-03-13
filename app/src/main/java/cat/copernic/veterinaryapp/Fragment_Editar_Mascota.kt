package cat.copernic.veterinaryapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs

import cat.copernic.veterinaryapp.databinding.FragmentEditarMascotaBinding
import cat.copernic.veterinaryapp.modelos.Mascota
import com.google.firebase.firestore.FirebaseFirestore
import cat.copernic.veterinaryapp.Fragment_Editar_MascotaArgs


/**
 * A simple [Fragment] subclass.
 * Use the [Fragment_Editar_Mascota.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment_Editar_Mascota : Fragment() {
    val args : Fragment_Editar_MascotaArgs by navArgs()
    private lateinit var binding: FragmentEditarMascotaBinding
    private val db = FirebaseFirestore.getInstance()
    lateinit var mascota: Mascota



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEditarMascotaBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Recupera el chip enviado por safeargs
        var chip = args.chipMascota
        genui(chip)

    }

    /**
     * Muestra en las vistas los datos de la mascota recuperados de la db
     * pasandole la id (el chip)
     */
    private fun genui(chip: String) {
        db.collection("Mascota").document(chip).get().addOnSuccessListener {
            binding.nombreMascota.setText(it.get("nom") as String?)
            binding.chipMascota.setText(it.get("numero_chip") as String?)
            binding.editTextFechaNacMascota.setText(it.get("data_naixement") as String?)
            binding.editTextNumberSigned.setText(it.get("pes") as String?)
            binding.editTextRaza.setText(it.get("rassa") as String?)
        }
    }
}