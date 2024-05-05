/**
 * Write a description of class Customer here.
 *
 * @authors Steven Coss & Fhaungfha Suvannakajorn
 * @version 5.5.2024
 */
public class Customer
{
    private String name;
    private String phoneNumber;
    
    /**
     * Constructor for objects of class Customer.
     * Initializes a customer with their name, area code, and phone number.
     * Ensures that the area code and phone number meet specific criteria for validity.
     *
     * @param name The full name of the customer.
     * @param areaCode The area code for the customer's phone number, typically 3 digits.
     * @param phoneNumber The phone number, expected to be 7 digits.
     */
    public Customer(String name, String phoneNumber) 
    {
        this.name = name;
 
        if (String.valueOf(phoneNumber).length() == 10) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new IllegalArgumentException("Invalid phone number: Phone number must be 7 digits.");
        }
    }

    /**
     * Returns the customer's full name.
     * 
     * @return The name of the customer.
     */
    public String getName() 
    {
        return name;
    }

    /**
     * Returns the full phone number of the customer.
     * 
     * @return The phone number.
     */
    public String getPhoneNumber() 
    {
        return phoneNumber;
    }
}
