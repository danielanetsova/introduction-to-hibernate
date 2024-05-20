package exercises;

import entities.Project;
import utilities.HelperClass;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.Comparator;

public class FindTheLatestTenProjects {
    public static void main(String[] args) {
        EntityManager em = HelperClass.createEntityManager();
        em.createQuery("FROM Project p ORDER BY p.startDate DESC", Project.class)
                .setMaxResults(10)
                .getResultList()
                .stream().sorted(Comparator.comparing(Project::getName))
                .forEach(p -> {
                    String output = String.format("Project name: %s\n" +
                                    "   Project Description: %s\n" +
                                    "   Project Start Date: %s\n" +
                                    "   Project End Date: ",
                            p.getName(),
                            p.getDescription(),
                            returnDateTimeInFormat(p.getStartDate())
                    );

                    if (p.getEndDate() == null) {
                        output += "null\n";
                    } else {
                        output += returnDateTimeInFormat(p.getEndDate());
                    }

                    System.out.println(output);
                    }
                );

        em.close();
    }
    public static String returnDateTimeInFormat(LocalDateTime dateTime) {
        return String.format("%04d-%02d-%02d %02d:%02d:%02d.%d",
                dateTime.getYear(),
                dateTime.getMonthValue(),
                dateTime.getDayOfMonth(),
                dateTime.getHour(),
                dateTime.getMinute(),
                dateTime.getSecond(),
                dateTime.getNano() / 100_000_000
                );
    }
}
