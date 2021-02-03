package cat.copernic.veterinaryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import cat.copernic.veterinaryapp.databinding.ActivityVeterinariBinding

class ActivityVeterinari : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityVeterinariBinding>(this, R.layout.activity_veterinari)
        //setContentView(R.layout.activity_veterinari)


        drawerLayout = binding.drawerLayoutVet

        val navController = this.findNavController(R.id.myNavHostFragmentVet)

        NavigationUI.setupActionBarWithNavController(this,navController, drawerLayout)

        NavigationUI.setupWithNavController(binding.navViewVet, navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragmentVet)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }
}