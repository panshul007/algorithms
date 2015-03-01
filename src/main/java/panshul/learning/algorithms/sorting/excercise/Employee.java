package panshul.learning.algorithms.sorting.excercise;

public class Employee
{
    private final int    employeeNumber;
    private final String firstName;
    private final String lastName;
    private final String emailId;

    public Employee(int employeeNumber, String firstName, String lastName, String emailId)
    {
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }

    public int getEmployeeNumber()
    {
        return employeeNumber;
    }

    @Override public String toString()
    {
        return "Employee{" +
                "employeeNumber=" + employeeNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
