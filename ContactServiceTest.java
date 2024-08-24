import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// JUnit test class for ContactService
public class ContactServiceTest {
    private ContactService service;

    @BeforeEach
    public void setUp() {
        // Initialize the ContactService before each test
        service = new ContactService();
    }

    @Test
    public void testAddContact() {
        // Test case to add a contact
        Contact contact = new Contact("12345", "John", "Doe", "0123456789", "123 Main St");
        // Verify that the contact is added successfully
        assertTrue(service.addContact(contact));
        // Verify that adding a contact with the same ID returns false
        assertFalse(service.addContact(contact)); // Duplicate contact ID
    }

    @Test
    public void testDeleteContact() {
        // Test case to delete a contact
        Contact contact = new Contact("12345", "John", "Doe", "0123456789", "123 Main St");
        service.addContact(contact);
        // Verify that the contact is deleted successfully
        assertTrue(service.deleteContact("12345"));
        // Verify that deleting a non-existent contact returns false
        assertFalse(service.deleteContact("12345")); // Contact already deleted
    }

    @Test
    public void testUpdateContact() {
        // Test case to update a contact
        Contact contact = new Contact("12345", "John", "Doe", "0123456789", "123 Main St");
        service.addContact(contact);
        // Verify that the contact is updated successfully
        assertTrue(service.updateContact("12345", "Jane", "Smith", "9876543210", "456 Elm St"));
        Contact updatedContact = service.getContact("12345");
        // Verify that the fields are updated correctly
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("9876543210", updatedContact.getPhone());
        assertEquals("456 Elm St", updatedContact.getAddress());
    }

    @Test
    public void testUpdateNonExistentContact() {
        // Test case to update a non-existent contact
        assertFalse(service.updateContact("54321", "Jane", "Smith", "9876543210", "456 Elm St"));
    }
}
