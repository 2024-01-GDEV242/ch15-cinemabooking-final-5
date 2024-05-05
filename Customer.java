/**
 * Write a description of class Customer here.
 *
 * @authors Steven Coss &
 * @version 5.5.2024
 */
public class Customer
{
    private int areaCode;
    private int phoneNumber;
    /**
     * Constructor for objects of class Customer
     */
    public Customer(int areaCode, int phoneNumber)
    { 
        //test to make sure areaCode is legal
        this.areaCode = areaCode;
        //test to make sure phone number is right size
        this.phoneNumber = phoneNumber;
    }
}
