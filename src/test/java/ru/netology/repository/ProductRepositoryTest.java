package ru.netology.repository;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.exeption.NotFoundException;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductRepositoryTest {

    private ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    private Book MuhaCokotuha = new Book(1, "MuhaCokotuha", 50, "Chuykovskiy");
    private Book Moydodyr = new Book(2, "Moydodyr", 60, "Chuykovskiy");
    private Book Phone = new Book(3, "Phone", 70, "ChuykovskiyK");
    private TShirt Sony = new TShirt(4, "Sony", 500, "Gray");
    private TShirt Apple = new TShirt(5, "Apple", 600, "Green");
    private TShirt Huawey = new TShirt(6, "Huawey", 100, "Orange");

    @BeforeEach
    public void setUp() {
        manager.add(MuhaCokotuha);
        manager.add(Moydodyr);
        manager.add(Phone);
        manager.add(Sony);
        manager.add(Apple);
        manager.add(Huawey);
    }

    @Test
    public void shouldRemoveIfExist() {
        int idToRemove = 3;
        manager.removeById(idToRemove);

        Product[] actual = manager.findAll();
        Product[] expected = new Product[]{MuhaCokotuha, Moydodyr, Sony, Apple, Huawey};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfExist() {
        int idToRemove = 8;
        assertThrows(NotFoundException.class, () -> manager.removeById(idToRemove));
    }

}
