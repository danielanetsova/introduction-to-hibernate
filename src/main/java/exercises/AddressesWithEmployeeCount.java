package exercises;

import entities.Address;
import utilities.HelperClass;

import javax.persistence.EntityManager;

public class AddressesWithEmployeeCount {
    public static void main(String[] args) {
        EntityManager em = HelperClass.createEntityManager();

        em.createQuery("FROM Address a ORDER BY SIZE(a.employees) DESC", Address.class)
                .setMaxResults(10)
                .getResultList()
                .forEach(address -> System.out.printf("%s, %s - %d employees%n",
                                address.getText(),
                                address.getTown() == null ? "Null" : address.getTown().getName(),
                                address.getEmployees().size()));
        em.close();
    }
}
