package Covered;

import Service.Searchable;

// Базовый класс для всех объектов в библиотеке
public abstract class LibraryItem implements Searchable {
    String inventoryNumber;
    String author;

    protected LibraryItem(String inventoryNumber, String author) {
        this.inventoryNumber = inventoryNumber;
        this.author = author;
    }

    @Override
    public boolean searchByInventoryNumber(String inventoryNumber) {
        return this.inventoryNumber.equals(inventoryNumber);
    }

    @Override
    public boolean searchByAuthor(String author) {
        return this.author.equals(author);
    }

    @Override
    public String getInventoryNumber() {
        return inventoryNumber;
    }

    @Override
    public String getAuthor() {
        return author;
    }
}
