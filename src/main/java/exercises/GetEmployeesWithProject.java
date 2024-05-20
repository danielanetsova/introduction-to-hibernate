package exercises;

import entities.Employee;
import entities.Project;
import utilities.HelperClass;

import javax.persistence.EntityManager;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GetEmployeesWithProject {
    public static void main(String[] args) {


        EntityManager em = HelperClass.createEntityManager();
        try (Scanner scanner = new Scanner(System.in)) {
            int inputId = Integer.parseInt(scanner.nextLine());

            Employee employee = em.createQuery("FROM Employee e WHERE e.id = :id", Employee.class)
                    .setParameter("id", inputId)
                    .getSingleResult();

            String projectNames = employee.getProjects().isEmpty() ? "No Projects" : employee
                    .getProjects()
                    .stream()
                    .map(Project::getName)
                    .sorted()
                    .collect(Collectors.joining("\n"));

            System.out.printf("%s %s - %s%n%s",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getJobTitle(),
                    projectNames);
        } catch (Exception e) {
            System.out.println("No such employee");
        } finally {
            em.close();
        }

    }
}
