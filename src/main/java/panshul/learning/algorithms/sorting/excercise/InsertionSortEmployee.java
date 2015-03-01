package panshul.learning.algorithms.sorting.excercise;

public class InsertionSortEmployee
{
    /**
     *Write a class Employee, which represents an employee in a company.
     *The employee has a employeeNumber (9 digit number), firstName, lastName and emailId as member variables.
     *Create a few employee objects and store them in an array.
     *Write the insertion sort algorithm, which takes an array of employee and sorts them in order of their employee number.
     */

    public static void main(String[] args)
    {
        Employee[] employees = generateEmployees();
        employees = sort(employees);
        for (Employee emp : employees)
        {
            System.out.println(emp.toString());
        }
    }

    private static Employee[] sort(Employee[] employees)
    {
        for (int i = 0; i < employees.length; i++)
        {

            Employee current = employees[i];
            int j = i - 1;
            while (j >= 0 && employees[j].getEmployeeNumber() > current.getEmployeeNumber())
            {
                employees[j + 1] = employees[j];
                j -= 1;
            }
            employees[j + 1] = current;
        }
        return employees;
    }

    private static Employee[] generateEmployees()
    {
        Employee[] employees = new Employee[6];
        employees[0] = new Employee(123456789, "first", "employee", "first@employee.com");
        employees[1] = new Employee(123456788, "second", "employee", "second@employee.com");
        employees[2] = new Employee(123456787, "third", "employee", "third@employee.com");
        employees[3] = new Employee(123456786, "fourth", "employee", "fourth@employee.com");
        employees[4] = new Employee(123456785, "fifth", "employee", "fifth@employee.com");
        employees[5] = new Employee(123456784, "sixth", "employee", "sixth@employee.com");
        return employees;
    }
}
