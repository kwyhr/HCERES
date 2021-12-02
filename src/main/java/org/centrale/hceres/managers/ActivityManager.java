/* --------------------------------------------------------------------------------
 * Projet HCERES
 * 
 * Gestion de données pour l'HCERES
 * 
 * Ecole Centrale Nantes - laboratoire CRTI
 * Avril 2021
 * L LETERTRE, S LIMOUX, JY MARTIN
 * -------------------------------------------------------------------------------- */
package org.centrale.hceres.managers;

import java.util.ArrayList;
import java.util.List;
import org.centrale.hceres.items.Activity;
import org.centrale.hceres.items.Publication;
import org.centrale.hceres.items.Researcher;
import org.centrale.hceres.repositories.*;

/**
 *
 * @author kwyhr
 */
public class ActivityManager {

    /**
     * Check if author and lastname-firstname matches
     *
     * @param author
     * @param lastName
     * @param firstName
     * @return
     */
    private static boolean matchName(String author, String lastName, String firstName) {
        boolean match = false;
        String[] elements = author.trim().split(" ");

        String name = elements[0];
        if (name.compareToIgnoreCase(lastName) == 0) {
            // Maybe....
            if (!firstName.isEmpty()) {
                String initiales = elements[elements.length - 1].trim();
                String[] splited = firstName.trim().split("- ");
                String computed = "";
                for (String s : splited) {
                    computed += s.charAt(0);
                }
                if (initiales.compareToIgnoreCase(computed) == 0) {
                    match = true;
                }
            }
        }

        return match;
    }

    /**
     * find authors according to author's list
     * @param authors
     * @param listResearcher
     * @return 
     */
    private static List<Researcher> findAuthors(String authors, List<Researcher> listResearcher) {
        List<Researcher> match = new ArrayList<Researcher>();
        String[] authorsList = authors.split(",");

        System.out.println("Authors : " + authors);
        for (String author : authorsList) {
            Researcher found = null;
            for (Researcher researcher : listResearcher) {
                if (matchName(author, researcher.getResearcherSurname(), researcher.getResearcherName())) {
                    found = researcher;
                    break;
                }
            }

            if (found != null) {
                // one researcher matches
                System.out.println(" ->" + found.getResearcherSurname() + " " + found.getResearcherName());
                match.add(found);
            }
        }

        return match;
    }

    /**
     * Link reseachers to activity according to authors
     *
     * @param researcherRepository
     * @param activityRepository
     * @param activity
     * @param listResearchers
     * @param authors
     */
    private static void processActivity(ResearcherRepository researcherRepository, ActivityRepository activityRepository, Activity activity, List<Researcher> listResearchers, String authors) {
        List<Researcher> match = findAuthors(authors, listResearchers);
        for (Researcher researcher : match) {
            activityRepository.addResearcher(activity, researcher);
        }
    }

    /**
     * Manage publication authors
     *
     * @param researcherRepository
     * @param activityRepository
     * @param publicationRepository
     */
    public static void processPublication(ResearcherRepository researcherRepository, ActivityRepository activityRepository, PublicationRepository publicationRepository) {
        List<Researcher> listResearcher = researcherRepository.findAll();
        List<Publication> listPublication = publicationRepository.findAll();

        for (Publication publication : listPublication) {
            Activity activity = publication.getActivity();
            if (activity.getResearcherCollection().isEmpty()) {
                String authors = publication.getAuthors();
                processActivity(researcherRepository, activityRepository, activity, listResearcher, authors);
            }
        }
    }

}
