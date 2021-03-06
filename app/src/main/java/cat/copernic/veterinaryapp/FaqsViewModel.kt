package cat.copernic.veterinaryapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cat.copernic.veterinaryapp.administrador.LlistaUsers.ReposUserData
import cat.copernic.veterinaryapp.administrador.LlistaUsers.UserView
import cat.copernic.veterinaryapp.modelos.FAQS

class FaqsViewModel: ViewModel() {

    private val repo = ReposFaqsData()
    fun fetchFaqsData(): LiveData<MutableList<FAQS>> {
        val mutabledata = MutableLiveData<MutableList<FAQS>>()
        repo.getFaqsData().observeForever{
            mutabledata.value = it
        }
        return mutabledata
    }
}