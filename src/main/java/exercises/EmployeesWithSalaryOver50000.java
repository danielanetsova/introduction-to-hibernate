package exercises;

import entities.Employee;
import utilities.HelperClass;

import javax.persistence.EntityManager;

public class EmployeesWithSalaryOver50000 {
    public static void main(String[] args) {
        EntityManager em = HelperClass.createEntityManager();
        em.getTransaction().begin();

        em.createQuery("FROM Employee WHERE salary > 50000", Employee.class)
                .getResultList()
                .forEach(e -> System.out.println(e.getFirstName()));

        em.getTransaction().commit();
        em.close();
    }
}
