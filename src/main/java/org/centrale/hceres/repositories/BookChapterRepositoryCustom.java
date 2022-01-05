/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.centrale.hceres.repositories;

import java.util.Collection;
import org.centrale.hceres.items.BookChapter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author twfid
 */
@Repository
public interface BookChapterRepositoryCustom {
     /**
     * Calculate the number of books Chapters
     * 
     * @return 
     */
    @Query(value="SELECT COUNT(*) FROM books",nativeQuery =true)
    public long countAllBookChapter();
    
    
    /**
     * Calculate the number of books Chapters in Foreign Languages
     * 
     * @return 
     */
    @Query(value="SELECT COUNT(*) FROM book_chapter\n" +
                "INNER JOIN language USING(language_id)\n" +
                "WHERE language.language_name NOT LIKE 'Français'",nativeQuery =true)
    public long countAllForeignLanguageBookChapter();
    
    /**
     * 
     * Count books by Language
     * @return 
     */
    @Query(value="SELECT language.language_name AS bookLanguage,COUNT(*) AS totalBook  FROM book\n" +
                "INNER JOIN language USING(language_id)\n" +
                "GROUP BY language.language_name",nativeQuery =true)
    public Collection <BookChapter> countBookChapterByLanguageName();   
    
}
