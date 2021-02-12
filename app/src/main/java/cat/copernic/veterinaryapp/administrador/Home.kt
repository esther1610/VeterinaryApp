package cat.copernic.veterinaryapp.administrador

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import cat.copernic.veterinaryapp.MainActivity
import cat.copernic.veterinaryapp.R
import cat.copernic.veterinaryapp.databinding.FragmentHomeBinding
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class home : Fragment(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.cierreSesion -> {
                Firebase.auth.signOut()
                true
            }
            else -> false
        }
    }
}