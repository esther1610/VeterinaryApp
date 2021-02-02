package cat.copernic.veterinaryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import cat.copernic.veterinaryapp.databinding.ActivityAdminBinding

class Admin : AppCompatActivity() {
    private lateinit var binding: ActivityAdminBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setupActionBarWithNavController(findNavController(R.id.nav_host_admin))
    }

   /* override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_gen, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this,
            R.id.nav_host_admin
        )
            .navigateUp() || super.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.cierreSesion -> {
                val toInit = Intent(this, MainActivity::class.java)
                startActivity(toInit)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }*/
}