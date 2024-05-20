package exercises;

import entities.Address;
import entities.Employee;
import entities.Town;
import utilities.HelperClass;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class AddingNewAddressUpdatingEmployee {
    public static void main(String[] args) {
        EntityManager em = HelperClass.createEntityManager();
        em.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);
        String inputLastName = scanner.nextLine();

        Town town = em.createQuery("FROM Town WHERE name = 'SOFIA'", Town.class).getSingleResult();

        List<Employee> employeeList = em.createQuery("FROM Employee WHERE lastName = :inputLastName", Employee.class)
                .setParameter("inputLastName", inputLastName)
                .getResultList();

        Address newAddress = new Address();
        newAddress.setText("Vitoshka 6");
        newAddress.setTown(town);

        em.persist(newAddress);

        if (!employeeList.isEmpty()) {
            employeeList.forEach(e -> e.setAddress(newAddress));
        }

        em.getTransaction().commit();
        em.close();
        scanner.close();
    }
}
