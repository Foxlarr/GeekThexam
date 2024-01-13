package Libra;

import Covered.LibraryItem;
import Service.Searchable;

import java.util.ArrayList;
import java.util.List;

// Сервис для поиска объектов
public class LibrarySearchService {
    List<Searchable> items;

    public LibrarySearchService(List<Searchable> items) {
        this.items = items;
    }

    public List<Searchable> searchByInventoryNumber(String inventoryNumber) {
        List<Searchable> result = new ArrayList<>();
        for (Searchable item : items) {
            if (item.searchByInventoryNumber(inventoryNumber)) {
                result.add(item);
            }
        }
        return result;
    }

    public List<Searchable> searchByAuthor(String author) {
        List<Searchable> result = new ArrayList<>();
        for (Searchable item : items) {
            if (item.searchByAuthor(author)) {
                result.add(item);
            }
        }
        return result;
    }
}
