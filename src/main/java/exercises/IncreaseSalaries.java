package exercises;

import entities.Employee;
import utilities.HelperClass;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IncreaseSalaries {
    public static void main(String[] args) {
        EntityManager em = HelperClass.createEntityManager();
        em.getTransaction().begin();

        try {
            List<String> departmentNamesSalaryIncrease =
                    Arrays.asList("Engineering", "Tool Design", "Marketing", "Information Services");

            em.createQuery("SELECT e FROM Employee e WHERE e.department.name IN :names", Employee.class)
                    //"FROM Employee WHERE department.name IN (:names)"
                    .setParameter("names", departmentNamesSalaryIncrease)
                    .getResultList()
                    .forEach(employee -> {
                        employee.setSalary(employee.getSalary().multiply(BigDecimal.valueOf(1.12)));

                        System.out.printf("%s %s ($%.2f)\n",
                                        employee.getFirstName(),
                                        employee.getLastName(),
                                        employee.getSalary()
                                );
                            }
                    );
            em.getTransaction().commit();
        } catch (Exception exception) {
            System.out.println("Error");
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

    }
}
