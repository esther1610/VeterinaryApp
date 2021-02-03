package cat.copernic.veterinaryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import cat.copernic.veterinaryapp.databinding.ActivityClienteBinding

class ActivityCliente : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityClienteBinding>(this, R.layout.activity_cliente)
    
        drawerLayout = binding.drawerLayoutUsr

        val navController = this.findNavController(R.id.myNavHostFragmentUsr)

        NavigationUI.setupActionBarWithNavController(this,navController, drawerLayout)

        NavigationUI.setupWithNavController(binding.navViewUsr, navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragmentUsr)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }
}