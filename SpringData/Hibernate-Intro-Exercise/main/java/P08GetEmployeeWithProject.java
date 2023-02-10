import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class P08GetEmployeeWithProject {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);
        int id = Integer.parseInt(scanner.nextLine());

        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e" +
                " WHERE e.id = :id", Employee.class).setParameter("id", id).getResultList();

        for (Employee employee : employees) {
            Set<Project> projects = employee.getProjects();
            System.out.printf("%s %s - %s%n", employee.getFirstName(), employee.getLastName(), employee.getJobTitle());
            projects.stream().sorted(Comparator.comparing(Project::getName)).forEach(p -> System.out.printf("\t%s\n", p.getName()));
        }


        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
