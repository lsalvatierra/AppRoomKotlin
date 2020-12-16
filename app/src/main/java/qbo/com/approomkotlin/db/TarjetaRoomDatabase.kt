package qbo.com.approomkotlin.db
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import qbo.com.approomkotlin.db.dao.TarjetaDao
import qbo.com.approomkotlin.db.entity.TarjetaEntity
@Database(entities = [TarjetaEntity::class], version = 1)
public abstract class TarjetaRoomDatabase : RoomDatabase() {

    abstract fun tarjetaDao(): TarjetaDao

    companion object{
        @Volatile
        private var INSTANCE: TarjetaRoomDatabase? = null
        fun getDatabase(context : Context): TarjetaRoomDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TarjetaRoomDatabase::class.java,
                    "tarjetasdb"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}