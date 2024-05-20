package exercises;

import entities.Employee;
import utilities.HelperClass;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;



public class ContainsEmployee {
    public static void main(String[] args) {

        EntityManager em = HelperClass.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        String inputName = scanner.nextLine().replaceAll("\\s*", "");
        em.getTransaction().begin();

        String output = em.createQuery("FROM Employee WHERE CONCAT(first_name, last_name) = :fullName OR " +
                        "CONCAT(first_name, middle_name) = :fullName", Employee.class)
                .setParameter("fullName", inputName)
                .getResultList()
                .isEmpty() ? "No" : "Yes";

        em.getTransaction().commit();
        System.out.println(output);

       List<Employee> employees = em.createQuery("FROM Employee", Employee.class).getResultList();
       String output = "";

       for (Employee employee : employees) {
           String firstAndSecondName = employee.getFirstName() + employee.getMiddleName();
           String firstAndLastName = employee.getFirstName() + employee.getLastName();

           if (inputName.equals(firstAndSecondName) || inputName.equals(firstAndLastName)) {
               output = "Yes";
               break;
           }
       }

       if (output.equals("")) {
           output = "No";
       }

       System.out.println(output);

        em.close();
        scanner.close();
    }
}
