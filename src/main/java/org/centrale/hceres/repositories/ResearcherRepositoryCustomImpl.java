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

import java.util.Optional;
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

}
