package cat.copernic.veterinaryapp.administrador.LlistaUsers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cat.copernic.veterinaryapp.R

class LlistaUsersAdapter(var elements : MutableList<UserView>, private val clickListener: OnUserClic) :
    RecyclerView.Adapter<LlistaUsersAdapter.LlistUserViewHolder>() {

    interface OnUserClic{
        fun onUserClickAction(nombre: String)
    }

    inner class LlistUserViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bindView(element: UserView){
            val nomUser: TextView = itemView.findViewById(R.id.usuari_nom)
            val rolUser: TextView = itemView.findViewById(R.id.usuari_rol)

            nomUser.text = element.nombre
            rolUser.text = element.rol

            itemView.setOnClickListener { clickListener.onUserClickAction(element.nombre) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LlistUserViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.view_users, parent, false)
        return LlistUserViewHolder(view)
    }

    override fun onBindViewHolder(holder: LlistUserViewHolder, position: Int) {
        holder.bindView(elements[position])
    }

    override fun getItemCount(): Int {
        return elements.size
    }
}