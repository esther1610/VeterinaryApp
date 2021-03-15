package cat.copernic.veterinaryapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import cat.copernic.veterinaryapp.dataBase.OperacionesDBFirebase_Diagnostico
import cat.copernic.veterinaryapp.databinding.FragmentVetGenerardiagBinding
import cat.copernic.veterinaryapp.modelos.Diagnostico


/**
 * Fragmento generar diagnostico
 *
 */
class vet_generardiag : Fragment() {
    private lateinit var binding: FragmentVetGenerardiagBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVetGenerardiagBinding.inflate(inflater, container, false)

        return binding.root
    }


}


