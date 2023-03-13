package tj.mra.jobs.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemViewModel(application: Application):AndroidViewModel(application) {
    var _items = MutableLiveData<List<Item>>()
    val items: MutableLiveData<List<Item>>
        get() {
            return _items
        }
    private val repository:ItemRepository
    init {
        val itemDao = InventoryDatabase.getDatabase(application).itemDao()
        repository = ItemRepository(itemDao)
        _items = repository.getLiveData() as MutableLiveData<List<Item>>
        _items.value?.filter { it.id == 1 }
    }



    fun addItem(item: Item){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addItem(item)
        }
    }

    fun update(item: Item){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateItem(item)
        }
    }


    fun addQuantity(id: Int){

    }

    fun removeQuantity(id: Int){
        viewModelScope.launch(Dispatchers.IO) {
            var item_ = repository.getItem(id)
            if (item_?.value != null){
                var item = item_.value
                item?.quantity = item?.quantity?.minus(1)!!
                repository.updateItem(item)
            }
        }
    }

}