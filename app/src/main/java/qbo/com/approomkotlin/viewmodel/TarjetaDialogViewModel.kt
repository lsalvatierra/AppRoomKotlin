package qbo.com.approomkotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import qbo.com.approomkotlin.db.TarjetaRoomDatabase
import qbo.com.approomkotlin.db.entity.TarjetaEntity
import qbo.com.approomkotlin.repository.TarjetaRepository

class TarjetaDialogViewModel (application: Application) : AndroidViewModel(application)
{
    private val repository: TarjetaRepository
    // TODO: Implement the ViewModel
    init {
        val tarjetaDao = TarjetaRoomDatabase.getDatabase(application)
            .tarjetaDao()
        repository = TarjetaRepository(tarjetaDao)
    }
    fun insertar(tarjetaEntity: TarjetaEntity) =
        viewModelScope.launch (Dispatchers.IO){
        repository.insertar(tarjetaEntity)
    }
    fun listarTarjetas(): LiveData<List<TarjetaEntity>>{
        return repository.listarTarjetas()
    }
}