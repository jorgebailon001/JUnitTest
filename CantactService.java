import java.util.HashMap;
import java.util.Map;

// ContactService.java
public class ContactService {
    // HashMap to store contacts with their ID as the key
    private Map<String, Contact> contacts;

    // Constructor to initialize the contacts map
    public ContactService() {
        contacts = new HashMap<>();
    }

    // Method to add a contact
    public boolean addContact(Contact contact) {
        // Check if the contact ID already exists
        if (contacts.containsKey(contact.getContactID())) {
            return false; // Contact ID already exists
        }
        contacts.put(contact.getContactID(), contact);
        return true; // Contact added successfully
    }

    // Method to delete a contact by ID
    public boolean deleteContact(String contactID) {
        // Check if the contact ID exists
        if (contacts.containsKey(contactID)) {
            contacts.remove(contactID);
            return true; // Contact deleted successfully
        }
        return false; // Contact ID not found
    }

    // Method to update contact fields by ID
    public boolean updateContact(String contactID, String firstName, String lastName, String phone, String address) {
        // Check if the contact ID exists
        if (contacts.containsKey(contactID)) {
            Contact contact = contacts.get(contactID);
            // Update fields if they are valid
            if (firstName != null && firstName.length() <= 10) {
                contact.setFirstName(firstName);
            }
            if (lastName != null && lastName.length() <= 10) {
                contact.setLastName(lastName);
            }
            if (phone != null && phone.length() == 10) {
                contact.setPhone(phone);
            }
            if (address != null && address.length() <= 30) {
                contact.setAddress(address);
            }
            return true; // Contact updated successfully
        }
        return false; // Contact ID not found
    }

    // Method to get a contact by ID
    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }
}
