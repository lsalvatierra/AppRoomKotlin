package qbo.com.approomkotlin.repository

import androidx.lifecycle.LiveData
import qbo.com.approomkotlin.db.dao.TarjetaDao
import qbo.com.approomkotlin.db.entity.TarjetaEntity

class TarjetaRepository (private val tarjetaDao: TarjetaDao) {

    suspend fun insertar(tarjetaEntity: TarjetaEntity){
        tarjetaDao.insertar(tarjetaEntity)
    }

    fun listarTarjetas(): LiveData<List<TarjetaEntity>>{
        return tarjetaDao.listarTarjetas()
    }

}