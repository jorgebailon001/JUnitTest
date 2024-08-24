import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// JUnit test class for Contact
public class ContactTest {

    @Test
    public void testContactCreation() {
        // Test case to verify contact creation
        Contact contact = new Contact("12345", "John", "Doe", "0123456789", "123 Main St");
        // Verify that fields are set correctly
        assertEquals("12345", contact.getContactID());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("0123456789", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testContactSetters() {
        // Test case to verify setter methods
        Contact contact = new Contact("12345", "John", "Doe", "0123456789", "123 Main St");
        // Set new values
        contact.setFirstName("Jane");
        contact.setLastName("Smith");
        contact.setPhone("9876543210");
        contact.setAddress("456 Elm St");
        // Verify that fields are updated correctly
        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("9876543210", contact.getPhone());
        assertEquals("456 Elm St", contact.getAddress());
    }

    @Test
    public void testContactInvalidID() {
        // Test cases for invalid contact ID
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "0123456789", "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "0123456789", "123 Main St");
        });
    }

    @Test
    public void testContactInvalidFirstName() {
        // Test cases for invalid first name
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Doe", "0123456789", "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "JohnJohnJohn", "Doe", "0123456789", "123 Main St");
        });
    }

    @Test
    public void testContactInvalidLastName() {
        // Test cases for invalid last name
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", null, "0123456789", "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "DoeDoeDoeDoe", "0123456789", "123 Main St");
        });
    }

    @Test
    public void testContactInvalidPhone() {
        // Test cases for invalid phone number
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", null, "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "123456789", "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "12345678901", "123 Main St");
        });
    }

    @Test
    public void testContactInvalidAddress() {
        // Test cases for invalid address
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "0123456789", null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "0123456789", "123 Main Street That Is Way Too Long");
        });
    }
}
