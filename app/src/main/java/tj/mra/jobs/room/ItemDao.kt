package tj.mra.jobs.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item:Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)


    @Query( "SELECT * from items WHERE id = :id")
    fun getItem(id: Int): LiveData<Item>?

    @Query("SELECT * from items ORDER BY id ASC")
    fun readAllData():LiveData<List<Item>>

}