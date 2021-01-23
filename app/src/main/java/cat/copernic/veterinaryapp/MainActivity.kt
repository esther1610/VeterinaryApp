package cat.copernic.veterinaryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import cat.copernic.veterinaryapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Botones
        binding.btnLogIn.setOnClickListener(this)
    }
    //Comprueba que los datos del correo y contraseña no estan vacíos
    private fun analizarDatosUsuario(){
        //TODO
    }
     private fun login(email: String, password: String){
         //TODO
         //Tost temporal pra probar
         Toast.makeText(this,"Pulasado LogIn", Toast.LENGTH_LONG).show()
     }
    override fun onClick(v: View) {
        when(v.id) {
            //Llamada a metodos de los botones
            R.id.btnLogIn -> login("tmp user","tmp pass")

        }
    }
}