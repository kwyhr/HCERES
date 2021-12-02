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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.centrale.hceres.items.Activity;
import org.centrale.hceres.items.Researcher;
import org.centrale.hceres.items.TypeActivity;
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

    @Autowired
    TypeActivityRepository typeActivityRepository;

    @Override
    public void addResearcher(Activity activity, Researcher researcher) {
        if ((activity != null) && (researcher != null)) {
            if (!activity.getResearcherCollection().contains(researcher)) {
                activity.getResearcherCollection().add(researcher);
                activityRepository.save(activity);
            }
            if (!researcher.getActivityCollection().contains(activity)) {
                researcher.getActivityCollection().add(activity);
                researcherRepository.save(researcher);
            }
        }
    }

    @Override
    public HashMap<Integer, List<Activity>> findResearcherActivities(Researcher researcher) {
        HashMap<Integer, List<Activity>> listActivities = new HashMap<Integer, List<Activity>>();

        List<TypeActivity> listeType = typeActivityRepository.findAll();
        for (TypeActivity typeActivity : listeType) {
            int typeActivityId = typeActivity.getIdTypeActivity();

            List<Activity> listRActivities = activityRepository.findResearcherActivities(researcher, typeActivity);
            listActivities.put(typeActivityId, listRActivities);
        }

        return listActivities;
    }

    @Override
    public List<Activity> findResearcherActivities(Researcher researcher, TypeActivity typeActivity) {
        if ((researcher != null) && (typeActivity != null)) {
            return activityRepository.findResearcherActivities(researcher.getResearcherId(), typeActivity.getIdTypeActivity());
        } else {
            return new ArrayList<Activity>();
        }
    }
}
