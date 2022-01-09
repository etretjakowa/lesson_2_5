package course2.lesson_2_5.servise;

import course2.lesson_2_5.Employee;
import course2.lesson_2_5.exception.EmployeeExistsException;
import course2.lesson_2_5.exception.EmployeeIsNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Set<Employee> employees;

    public EmployeeServiceImpl() {
        employees = new HashSet<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        return add(newEmployee);
    }

    @Override
    public Employee add(Employee employee) {
        boolean employeeAlreadyExists = !employees.add(employee);
        if (employeeAlreadyExists) {
            throw new EmployeeExistsException();
        }
        return employee;
    }


    @Override
    public Employee remove(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
      return remove(newEmployee);
    }

    @Override
    public Employee remove(Employee employee) {
        boolean employeeNotFound = !employees.remove(employee);
        if (employeeNotFound) {
            throw new EmployeeIsNotFoundException();
        }
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        return find(newEmployee);
    }

    @Override
    public Employee find(Employee employee) {
        boolean employeeNotContains = !employees.contains(employee);
        if (employeeNotContains) {
            throw new EmployeeIsNotFoundException();
        }
        return employee;
    }

    @Override
    public Collection<Employee> getAll() {
        return Set.copyOf(employees);
    }

}