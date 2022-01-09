package course2.lesson_2_5.servise;

import course2.lesson_2_5.Employee;

import java.util.Collection;

public interface EmployeeService {

    Employee  add (String firstName, String lastName);
    Employee  add (Employee employee);
    Employee remove (String firstName, String lastName);
    Employee remove (Employee employee);
    Employee find (String firstName, String lastName);
    Employee find (Employee employee);

    Collection<Employee> getAll();
}
