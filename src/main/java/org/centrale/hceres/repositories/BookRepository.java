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

import java.util.Collection;
import java.util.Date;
import org.centrale.hceres.items.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ECN
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer>,BookRepositoryCustom{
    
    @Query("SELECT b FROM Book b WHERE b.editor = :editor")
    public Collection<Book> findAllByEditor(@Param("editor")String editor);
}
