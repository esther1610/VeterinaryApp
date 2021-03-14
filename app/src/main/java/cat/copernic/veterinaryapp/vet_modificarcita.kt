package cat.copernic.veterinaryapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import cat.copernic.veterinaryapp.databinding.FragmentVetModificarcitaBinding

class vet_modificarcita : Fragment() {
    private lateinit var binding: FragmentVetModificarcitaBinding
    private val args by navArgs<vet_modificarcitaArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVetModificarcitaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}