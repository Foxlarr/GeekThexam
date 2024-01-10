package Libra;

import Covered.LibraryItem;

import java.util.ArrayList;
import java.util.List;

// Сервис для поиска объектов
public class LibrarySearchService {
    List<LibraryItem> items;

    public LibrarySearchService(List<LibraryItem> items) {
        this.items = items;
    }

    public List<LibraryItem> searchByInventoryNumber(String inventoryNumber) {
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item.getInventoryNumber().equals(inventoryNumber)) {
                result.add(item);
            }
        }
        return result;
    }

    List<LibraryItem> searchByAuthor(String author) {
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item.getAuthor().equals(author)) {
                result.add(item);
            }
        }
        return result;
    }
}
