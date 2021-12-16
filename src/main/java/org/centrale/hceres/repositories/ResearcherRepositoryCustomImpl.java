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
import java.util.List;
import java.util.Optional;
import org.centrale.hceres.items.Nationality;
import org.centrale.hceres.items.Researcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kwyhr
 */
@Repository
public class ResearcherRepositoryCustomImpl implements ResearcherRepositoryCustom {

    @Autowired
    @Lazy
    ResearcherRepository researcherRepository;

    @Autowired
    @Lazy
    NationalityRepository nationalityRepository;

    @Override
    public Researcher create(String name, String surname, String email) {
        if ((name != null) && (surname != null) & (email != null)
                & (!name.trim().isEmpty()) & (!surname.trim().isEmpty()) & (!email.trim().isEmpty())) {
            Researcher item = new Researcher();
            item.setResearcherName(name);
            item.setResearcherSurname(surname);
            item.setResearcherEmail(email);
            researcherRepository.save(item);

            Optional<Researcher> researcherResult = researcherRepository.findById(item.getResearcherId());
            if (researcherResult.isPresent()) {
                return researcherResult.get();
            }
        }
        return null;
    }

    @Override
    public Researcher find(int researcherId) {
        Researcher returnedValue = null;
        Optional<Researcher> researcherResult = researcherRepository.findById(researcherId);
        if (researcherResult.isPresent()) {
            returnedValue = researcherResult.get();
        }
        return returnedValue;
    }

    @Override
    public void delete(int researcherId) {
        Researcher researcher = find(researcherId);
        if (researcher != null) {
            researcherRepository.delete(researcher);
        }
    }

    @Override
    public void setNationality(Researcher researcher, Nationality nationality) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNationalities(Researcher researcher, List<Nationality> nationalities) {
        List<Nationality> added = new ArrayList<Nationality>();
        List<Nationality> removed = new ArrayList<Nationality>();

        // fill arrays
        for (Nationality nationality : researcher.getNationalityCollection()) {
            removed.add(nationality);
        }

        for (Nationality nationality : nationalities) {
            if (removed.contains(nationality)) {
                removed.remove(nationality);
            } else {
                added.add(nationality);
            }
        }

        // Take into account
        boolean hasChanged = false;
        for (Nationality nationality : added) {
            researcher.getNationalityCollection().add(nationality);
            nationality.getResearcherCollection().add(researcher);
            hasChanged = true;
        }

        for (Nationality nationality : removed) {
            researcher.getNationalityCollection().remove(nationality);
            nationality.getResearcherCollection().remove(researcher);
            hasChanged = true;
        }

        // repository save
        if (hasChanged) {
            for (Nationality nationality : added) {
                nationalityRepository.save(nationality);
            }
            for (Nationality nationality : removed) {
                nationalityRepository.save(nationality);
            }
            researcherRepository.save(researcher);
        }
    }
    
    public long countAllResearchers()
    {
        return researcherRepository.countAllResearchers();
    }
    
    public long countAllInternationalResearchers()
    {
        return researcherRepository.countAllInternationalResearchers();
    }

}
