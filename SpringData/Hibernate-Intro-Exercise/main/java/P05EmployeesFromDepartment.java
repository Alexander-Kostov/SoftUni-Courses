import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class P05EmployeesFromDepartment {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        String department = "Research and Development";

        List<Employee> employeeList = entityManager.createQuery("FROM Employee e WHERE e.department.name = :departmentName" +
                " ORDER BY e.salary, e.id", Employee.class).setParameter("departmentName", department).getResultList();

        for (Employee employee : employeeList) {
            System.out.printf("%s %s from %s - $%.2f%n", employee.getFirstName(), employee.getLastName(), department, employee.getSalary());
        }


        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
