# JUnitTest
# Contact Management System

This is a simple Contact Management System written in Java. The system allows for creating, updating, retrieving, and deleting contact records. It is designed with basic validation to ensure data integrity and comes with unit tests to verify its functionality.

Project Structure

The project consists of the following classes:

1. Contact.java
- Represents a contact with the following fields:
  - `contactID` (final, max length 10 characters)
  - `firstName` (max length 10 characters)
  - `lastName` (max length 10 characters)
  - `phone` (exact length 10 characters)
  - `address` (max length 30 characters)

- The constructor initializes these fields with validation to ensure that:
  - `contactID` is not `null` and does not exceed 10 characters.
  - `firstName` and `lastName` are not `null` and do not exceed 10 characters.
  - `phone` is exactly 10 characters long.
  - `address` is not `null` and does not exceed 30 characters.

- The class provides getter methods for all fields and setter methods for `firstName`, `lastName`, `phone`, and `address`. Setter methods include validation similar to the constructor.

2. ContactService.java
- Manages a collection of `Contact` objects using a `HashMap` where the key is the `contactID`.
- Provides the following methods:
  - `addContact(Contact contact)`: Adds a new contact if the `contactID` does not already exist.
  - `deleteContact(String contactID)`: Deletes a contact by its `contactID`.
  - `updateContact(String contactID, String firstName, String lastName, String phone, String address)`: Updates the contact fields for the specified `contactID`.
  - `getContact(String contactID)`: Retrieves a contact by its `contactID`.

3. ContactServiceTest.java
- Contains JUnit tests for `ContactService`.
- Tests include:
  - Adding a contact and checking for successful addition.
  - Attempting to add a contact with a duplicate `contactID`.
  - Deleting a contact and attempting to delete a non-existent contact.
  - Updating a contact's details and verifying the updates.
  - Attempting to update a non-existent contact.

4. ContactTest.java
- Contains JUnit tests for the `Contact` class.
- Tests include:
  - Validating the creation of a `Contact` with correct input.
  - Testing setter methods to ensure fields are correctly updated.
  - Testing for exceptions when invalid data is provided for any field, such as too long strings or null values.

Getting Started

Prerequisites

- Java Development Kit (JDK) 8 or higher
- Maven (for building and running tests)

Running the Project

1. Clone the repository:
   
   git clone https://github.com/your-username/contact-management-system.git
   cd contact-management-system
   

2. Compile the project:
  
   mvn compile
 

3. Run the tests:
   
   mvn test
   
Usage

You can use the `ContactService` class to manage contacts. Here’s a simple example of how to use it:


ContactService service = new ContactService();
Contact contact = new Contact("12345", "John", "Doe", "0123456789", "123 Main St");

// Add a contact
service.addContact(contact);

// Update a contact
service.updateContact("12345", "Jane", "Smith", "9876543210", "456 Elm St");

// Get a contact
Contact retrieved = service.getContact("12345");

// Delete a contact
service.deleteContact("12345");


