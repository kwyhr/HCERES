/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.hceres.repositories;

import java.util.Collection;
import org.centrale.hceres.items.BookChapter;
import org.springframework.stereotype.Repository;

/**
 *
 * @author twfid
 */
@Repository
public class BookChapterRepositoryCustomImpl implements BookChapterRepositoryCustom {
    
    
    BookChapterRepository bookChapterRepository;
    
    public long countAllBookChapter()
    {
        return bookChapterRepository.countAllBookChapter();
    }
    public long countAllForeignLanguageBookChapter()
    {
        return bookChapterRepository.countAllForeignLanguageBookChapter();
    }
    public Collection <BookChapter> countBookChapterByLanguageName()
    {
        return bookChapterRepository.countBookChapterByLanguageName();
    }
    
}
