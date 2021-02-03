package cat.copernic.veterinaryapp.administrador

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import cat.copernic.veterinaryapp.MainActivity
import cat.copernic.veterinaryapp.R
import cat.copernic.veterinaryapp.databinding.ActivityAdministradorBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Administrador : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityAdministradorBinding>(this, R.layout.activity_administrador)

        drawerLayout = binding.drawerLayout

        val navController = this.findNavController(R.id.myNavHostFragment)

        NavigationUI.setupActionBarWithNavController(this,navController, drawerLayout)

        NavigationUI.setupWithNavController(binding.navView, navController)

    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.cierreSesion -> {
                Toast.makeText(this, "Clicked item one", Toast.LENGTH_SHORT).show()
                Firebase.auth.signOut()
                val toInit = Intent(this, MainActivity::class.java)
                startActivity(toInit)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}