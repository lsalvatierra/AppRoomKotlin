package qbo.com.approomkotlin.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import qbo.com.approomkotlin.db.entity.TarjetaEntity

@Dao
interface TarjetaDao {

    @Insert
    suspend fun insertar(tarjeta: TarjetaEntity?)

    @Query("SELECT * FROM tarjeta ORDER BY titulo ASC")
    fun listarTarjetas(): LiveData<List<TarjetaEntity>>

}