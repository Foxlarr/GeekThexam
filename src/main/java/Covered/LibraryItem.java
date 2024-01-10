package Covered;

// Базовый класс для всех объектов в библиотеке
public abstract class LibraryItem {
    String inventoryNumber;
    String author;

    protected LibraryItem(String inventoryNumber, String author) {
        this.inventoryNumber = inventoryNumber;
        this.author = author;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public String getAuthor() {
        return author;
    }
}
