package Service;

public interface Searchable {
    boolean searchByInventoryNumber(String inventoryNumber);
    boolean searchByAuthor(String author);
    String getInventoryNumber();
    String getAuthor();
}
