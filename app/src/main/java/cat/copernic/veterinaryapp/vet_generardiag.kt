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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Hago el binding
        var binding = inflate<FragmentVetGenerardiagBinding>(
            inflater,
            R.layout.fragment_vet_generarcita,
            container,
            false
        )
        //var diagnostico = Diagnostico(null, "", "xxx","Asesinato","Pastis",null,"Pepito") //Muestra llenar datos

        //De momento sin contenido, se lo paso a la vista del xml
        var diagnostico = Diagnostico()
        //binding.diagnostico = diagnostico

        //Click boton enviar
        binding.btnEnviar.setOnClickListener {

            //diagnostico.fecha //Si es de hoy generar fecha
            diagnostico.diagnostico = binding.editTextDiagnostico.text.toString()
            diagnostico.medicamento = binding.editTextMedicamento.text.toString()
            //diagnostico.veterinario //Obtener nombre veterinario
            //diagnostico.prox_visita = binding.diagnostico.prox_visita
            //diagnostico.paciente //Buscar el funcionamiento del campo.


            var opdiag = OperacionesDBFirebase_Diagnostico()
            opdiag.guardar(diagnostico) //Guardo los datos en la db, lo mismo que modificar si los campos estan llenos por el que se hace la busqueda.
        }
        return binding.root

    }


}