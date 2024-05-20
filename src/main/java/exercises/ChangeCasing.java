package exercises;

import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ChangeCasing {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Town> allTowns = entityManager.createQuery("FROM Town", Town.class).getResultList();
        for (Town town : allTowns) {
            String townName = town.getName();

            if (townName.length() > 5) {
                entityManager.detach(town);
            } else {
                town.setName(townName.toUpperCase());
//              ****  entityManager.flush(); не е необходимо да се пише тъй като commit-a накрая ще въведе промените
//                пише се когато искаме да се запазят промените преди да кажем commit
            }
        }
        entityManager.getTransaction().commit();
    }
}
