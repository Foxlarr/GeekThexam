import Libra.Book;
import Libra.Journal;
import Covered.LibraryItem;
import Libra.LibrarySearchService;

import java.util.*;

// и так далее для других типов..

public class Main {
    public static void main(String[] args) {
        // Инициализация реестра
        List<LibraryItem> items = new ArrayList<>();
        items.add(new Book("1", "Author1"));
        items.add(new Journal("2", "Author2"));
        // и так далее..

        // Инициализация сервиса поиска
        LibrarySearchService searchService = new LibrarySearchService(items);

        // Поиск элементов и вывод на экран
        List<LibraryItem> foundItems = searchService.searchByInventoryNumber("1");
        for (LibraryItem item : foundItems) {
            System.out.println("Найденный элемент: " + item.getInventoryNumber() + ", " + item.getAuthor());
        }
    }
}
