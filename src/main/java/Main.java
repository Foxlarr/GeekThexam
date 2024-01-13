import Libra.Book;
import Libra.LibrarySearchService;
import Service.Searchable;

import java.util.*;



public class Main {
    public static void main(String[] args) {
        // Инициализация реестра
        List<Searchable> items = new ArrayList<>();
        items.add(new Book("1", "Author1"));
        items.add(new Book("2", "Author2"));
        items.add(new Book("3", "Author3"));

        // Инициализация сервиса поиска
        LibrarySearchService searchService = new LibrarySearchService(items);

        // Поиск элементов и вывод на экран
        List<Searchable> foundItems = searchService.searchByInventoryNumber("2");
        for (Searchable item : foundItems) {
            System.out.println("Найденный элемент: " + item.getInventoryNumber() + ", " + item.getAuthor());
        }
    }
}