/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.centrale.hceres.repositories;

import java.util.Collection;
import org.centrale.hceres.items.Book;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author twfid
 */
public interface BookRepositoryCustom {
    
    
    /**
     * Calculate the number of books
     * 
     * @return 
     */
    @Query(value="SELECT COUNT(*) FROM books",nativeQuery =true)
    public long countAllBooks();
    
    
    /**
     * Calculate the number of books in Foreign Languages
     * 
     * @return 
     */
    @Query(value="SELECT COUNT(*) FROM book\n" +
                "INNER JOIN language USING(language_id)\n" +
                "WHERE language.language_name NOT LIKE 'Français'",nativeQuery =true)
    public long countAllForeignLanguageBooks();
    
    /**
     * 
     * @return 
     */
    @Query(value="SELECT language.language_name AS bookLanguage,COUNT(*) AS totalBook  FROM book\n" +
                "INNER JOIN language USING(language_id)\n" +
                "GROUP BY language.language_name",nativeQuery =true)
    public Collection <Book> countBookByLanguageName();
            
}
