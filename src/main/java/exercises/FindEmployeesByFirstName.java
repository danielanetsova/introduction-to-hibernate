package exercises;

import entities.Employee;
import utilities.HelperClass;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class FindEmployeesByFirstName {
    public static void main(String[] args) {
        EntityManager em = HelperClass.createEntityManager();

        try (Scanner scanner = new Scanner(System.in)) {
            String inputParameter = scanner.nextLine();
            em.createQuery("FROM Employee WHERE firstName LIKE :inputPar", Employee.class)
                    .setParameter("inputPar", inputParameter + "%")
                    .getResultList()
                    .forEach(employee -> System.out.printf("%s %s - %s - ($%.2f)\n",
                            employee.getFirstName(),
                            employee.getLastName(),
                            employee.getJobTitle(),
                            employee.getSalary()));
        } catch (Exception e) {
            System.out.println("Error");
        } finally {
            em.close();
        }
    }
}
