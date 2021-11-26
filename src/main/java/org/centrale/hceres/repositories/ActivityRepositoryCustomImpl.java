/* --------------------------------------------------------------------------------
 * Projet HCERES
 * 
 * Gestion de données pour l'HCERES
 * 
 * Ecole Centrale Nantes - laboratoire CRTI
 * Avril 2021
 * L LETERTRE, S LIMOUX, JY MARTIN
 * -------------------------------------------------------------------------------- */
package org.centrale.hceres.repositories;

import java.util.Calendar;
import java.util.Date;
import org.centrale.hceres.items.Activity;
import org.centrale.hceres.items.Researcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kwyhr
 */
@Repository
public class ActivityRepositoryCustomImpl implements ActivityRepositoryCustom {

    @Autowired
    @Lazy
    ActivityRepository activityRepository;

    @Autowired
    ResearcherRepository researcherRepository;

    @Override
    public void addResearcher(Activity activity,Researcher researcher) {
        if ((activity != null) && (researcher != null)) {
            if (! activity.getResearcherCollection().contains(researcher)) {
                activity.getResearcherCollection().add(researcher);
                activityRepository.save(activity);
            }
            if (! researcher.getActivityCollection().contains(activity)) {
                researcher.getActivityCollection().add(activity);
                researcherRepository.save(researcher);
            }
        }
    }
}
