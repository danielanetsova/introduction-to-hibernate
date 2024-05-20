package exercises;

import entities.Address;
import entities.Town;
import utilities.HelperClass;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class RemoveTowns {
    public static void main(String[] args) {
        EntityManager em = HelperClass.createEntityManager();

        try (Scanner sc = new Scanner(System.in)){
            em.getTransaction().begin();

            String inputName = sc.nextLine();

            int deletedAddresses = em.createQuery("DELETE FROM Address WHERE town.name = :townName")
                    .setParameter("townName", inputName)
                    .executeUpdate();

            em.createQuery("DELETE FROM Town WHERE name = :townName")
                    .setParameter("townName", inputName)
                    .executeUpdate();

            System.out.printf("%d address in %s deleted", deletedAddresses, inputName);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        //String selectQuery = "SELECT m FROM Mother m WHERE some_condition";
        //List<Mother> mothersToRemove = entityManager
        //    .createQuery(selectQuery)
        //    .getResultStream()
        //    .forEach(em::remove);
    }
}
