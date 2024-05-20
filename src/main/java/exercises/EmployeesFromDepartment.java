package exercises;

import entities.Employee;
import utilities.HelperClass;

import javax.persistence.EntityManager;

public class EmployeesFromDepartment {
    public static void main(String[] args) {
        EntityManager em = HelperClass.createEntityManager();
//        em.getTransaction().begin(); 

        em.createQuery("FROM Employee" +
                        " WHERE department.name = 'Research and Development'" +
                        " ORDER BY salary, id", Employee.class)
                .getResultList()
                .forEach(e ->
                System.out.printf("%s %s from Research and Development - $%.2f%n",
                        e.getFirstName(),
                        e.getLastName(),
                        e.getSalary()));
        em.close();
    }
}
