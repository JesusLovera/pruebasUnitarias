package orb.bedu.java.backend.sesion2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    // Arrange
    private Database database;

    @BeforeEach
    public void setup() {
        database = new Database();
    }

    @Test
    @DisplayName("The size of an empty database is 0")
    public void sizeZero() {
        assertEquals(database.size(), 0);
    }

    @Test
    @DisplayName("Database can insert data")
    public void insert() {
        database.insert(new Product(1L, "Coca Cola 3lt"));
        database.insert(new Product(2L, "Gansito"));

        assertEquals(database.size(), 2);
    }

    @Test
    @DisplayName("Search by id")
    public void findById() {
        database.insert(new Product(1L, "Coca Cola 3lt"));
        database.insert(new Product(2L, "Gansito"));
        database.insert(new Product(3L, "Mordisko"));
        database.insert(new Product(4L, "Sabritas 30g"));

        Product p = database.getById(3L);

        assertEquals(p.getId(), 3L);
        assertEquals(p.getName(), "Mordisko");
    }

    @Test
    @DisplayName("Database can be cleared")
    public void clear() {
        database.insert(new Product(1L, "Coca Cola 3lt"));
        database.insert(new Product(2L, "Gansito"));
        database.insert(new Product(3L, "Mordisko"));
        database.insert(new Product(4L, "Sabritas 30g"));

        assertEquals(database.size(), 4L);

        database.clear();

        assertEquals(database.size(), 0L);
    }
    @Test
    @DisplayName("Eliminar elemento")
    public void remove(){
        database.insert(new Product(1L, "Coca Cola 3lt"));
        database.insert(new Product(2L, "Gansito"));
        database.insert(new Product(3L, "Mordisko"));
        database.insert(new Product(4L, "Sabritas 30g"));

        database.removeProduct(1L);
        assertEquals(database.size(), 3L);

    }
    @Test
    @DisplayName("Actualizar nombre de producto")
    public void update(){
        database.insert(new Product(1L, "Coca Cola 3lt"));
        database.insert(new Product(2L, "Gansito"));
        database.insert(new Product(3L, "Mordisko"));
        database.insert(new Product(4L, "Sabritas 30g"));

        Product p = database.getById(1L);

        database.updateProductName(1L, "Coca Cola 600");
        assertEquals(p.getName(), "Coca Cola 600");

    }
}