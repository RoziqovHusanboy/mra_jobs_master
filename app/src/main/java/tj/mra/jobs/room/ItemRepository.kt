package tj.mra.jobs.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ItemRepository(private val itemDao: ItemDao) {

    fun getLiveData(): LiveData<List<Item>> {
        return itemDao.readAllData()
    }

    suspend fun addItem(item: Item){
        itemDao.insert(item)
    }

    suspend fun updateItem(item: Item){
        itemDao.update(item)
    }

    suspend fun getItem(id: Int): LiveData<Item>? {
        return itemDao.getItem(id)
    }

}