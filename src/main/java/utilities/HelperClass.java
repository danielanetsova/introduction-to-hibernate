package utilities;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class HelperClass {
    public static EntityManager createEntityManager() {
        return Persistence.createEntityManagerFactory
                ("soft_uni").createEntityManager();
    }
}

