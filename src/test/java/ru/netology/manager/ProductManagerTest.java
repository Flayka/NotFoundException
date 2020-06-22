package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Book MuhaCokotuha = new Book(1, "MuhaCokotuha", 50, "Chuykovskiy");
    Book Moydodyr = new Book(2, "Moydodyr", 60, "Chuykovskiy");
    Book Phone = new Book(3, "Phone", 70, "ChuykovskiyK");
    TShirt Sony = new TShirt(4, "Phone", 5000, "Sony");
    TShirt Apple = new TShirt(5, "11pro", 50000, "Apple");
    TShirt Huawey = new TShirt(6, "Q10", 15000, "Huawey");

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
    public void shouldRemoveIfExists() {
        int idToRemove = 1;
        manager.removeById(idToRemove);

        Product[] actual = manager.findAll();
        Product[] expected = new Product[]{MuhaCokotuha, Moydodyr, Phone, Sony, Apple, Huawey};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfExists() {
        int idToRemove = 9;
        manager.removeById(idToRemove);

        Product[] actual = manager.findAll();
        Product[] expected = new Product[]{Moydodyr, Phone, Sony, Apple, Huawey};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldsearchByName() {

        String search = "11pro";

        Product[] actual = manager.searchBy(search);
        Product[] expected = new Product[]{Apple};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldsearchByAuthor() {

        String search = "ChuykovskiyK";

        Product[] actual = manager.searchBy(search);
        Product[] expected = new Product[]{Phone};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldsearchByManufacturer() {

        String search = "Sony";

        Product[] actual = manager.searchBy(search);
        Product[] expected = new Product[]{Sony};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldsearchBySameAuthor() {

        String search = "Chuykovskiy";

        Product[] actual = manager.searchBy(search);
        Product[] expected = new Product[]{MuhaCokotuha, Moydodyr};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldsearchBySameName() {

        String search = "Phone";

        Product[] actual = manager.searchBy(search);
        Product[] expected = new Product[]{Phone, Sony};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldsearchByNoMatches() {

        String search = "Test";

        Product[] actual = manager.searchBy(search);
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);
    }
}
