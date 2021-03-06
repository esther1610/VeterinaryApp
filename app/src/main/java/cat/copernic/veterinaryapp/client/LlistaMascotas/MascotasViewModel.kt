package cat.copernic.veterinaryapp.client.LlistaMascotas

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cat.copernic.veterinaryapp.administrador.LlistaUsers.ReposUserData
import cat.copernic.veterinaryapp.administrador.LlistaUsers.UserView

class MascotasViewModel: ViewModel() {
    private val repo = ReposMascotaData()
        fun fetchUsersData(): LiveData<MutableList<MascotaView>> {
            val mutabledata = MutableLiveData<MutableList<MascotaView>>()
            repo.getMascotaData().observeForever{
                mutabledata.value = it
            }
            return mutabledata
        }


}