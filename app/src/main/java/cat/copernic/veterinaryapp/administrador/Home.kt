package cat.copernic.veterinaryapp.administrador

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import cat.copernic.veterinaryapp.R
import cat.copernic.veterinaryapp.administrador.LlistaUsers.LlistaUsersAdapter
import cat.copernic.veterinaryapp.administrador.LlistaUsers.UserView
import cat.copernic.veterinaryapp.databinding.FragmentHomeBinding
import cat.copernic.veterinaryapp.databinding.ViewUsersBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class home : Fragment(), LlistaUsersAdapter.OnUserClic {

    private lateinit var adapter: LlistaUsersAdapter
    private lateinit var binding: FragmentHomeBinding
    private lateinit var vistaElement: ViewUsersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val genListUser: MutableList<UserView> = mutableListOf()
        genListUser.add(UserView("Emilio", "Regulador"))
        binding.LlistaUsuarisView.layoutManager = LinearLayoutManager(context)

        adapter = LlistaUsersAdapter(genListUser, this)
        binding.LlistaUsuarisView.adapter = adapter

        binding.floatingActionButton2.setOnClickListener {
            findNavController().navigate(R.id.action_home_f_to_viewUser)
        }
    }

    override fun onUserClickAction(nombre: String) {
        this.findNavController().navigate(R.id.action_home_f_to_viewUser)
    }
}