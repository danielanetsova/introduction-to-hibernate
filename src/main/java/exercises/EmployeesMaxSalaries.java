package exercises;

import entities.Department;
import entities.Employee;
import utilities.HelperClass;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public class EmployeesMaxSalaries {
    public static void main(String[] args) {
        EntityManager em = HelperClass.createEntityManager();

        try {
            List<Department> departments = em.createQuery("FROM Department", Department.class)
                    .getResultList();

            for (Department department : departments) {
                department
                        .getEmployees()
                        .stream()
                        .map(Employee::getSalary)
                        .max(Comparator.naturalOrder())
                        .filter(salary ->
                                salary.compareTo(BigDecimal.valueOf(70000.00)) > 0
                                        || salary.compareTo(BigDecimal.valueOf(30000.00)) < 0)
                        .ifPresent(salary -> System.out.printf("%s %.2f\n", department.getName(), salary));
            }

        } catch (Exception exception) {
            System.out.println("Error");
        } finally {
            em.close();
        }

        /**
         ~~ result with object array ~~
         Utils.createEntityManager()
         .createQuery("SELECT department.name, max(salary)" +
         " FROM Employee " +
         " GROUP BY department.name" +
         " HAVING max(salary) NOT BETWEEN 30000 AND 70000", Object[].class)
         .getResultList()
         .forEach(objects -> System.out.println(objects[0] + " " + objects[1]));

         System.out.println(System.lineSeparator());

         ~~ result with custom POJO ~~
         Utils.createEntityManager()
         .createQuery("SELECT NEW entities.models.Result(department.name, MAX(salary))" +
         " FROM Employee" +
         " GROUP BY department.name" +
         " HAVING MAX(salary) NOT BETWEEN 30000 AND 70000", Result.class)
         .getResultList()
         .forEach(System.out::println);
         */
    }
}
