package tj.mra.jobs.room

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized
import java.time.chrono.HijrahChronology
import java.time.chrono.HijrahChronology.INSTANCE

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class InventoryDatabase:RoomDatabase() {

    abstract fun itemDao():ItemDao

    companion object{

        @Volatile
        private var Instance: InventoryDatabase? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context): InventoryDatabase {
             val tempInstance = Instance
            if (tempInstance!=null) {
            return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    InventoryDatabase::class.java,
                    "item_database"
                ).build()
                Instance = instance
                return instance
            }
    }

}
}