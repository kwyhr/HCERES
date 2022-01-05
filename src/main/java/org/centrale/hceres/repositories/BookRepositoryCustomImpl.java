/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.hceres.repositories;

import java.util.Collection;
import org.centrale.hceres.items.Book;
import org.springframework.stereotype.Repository;

/**
 *
 * @author twfid
 */
@Repository
public class BookRepositoryCustomImpl implements BookRepositoryCustom{
    
    
    BookRepository bookRepository;
    
    public long countAllBooks()
    {
        return bookRepository.countAllBooks();
    }
    public long countAllForeignLanguageBooks()
    {
        return bookRepository.countAllForeignLanguageBooks();
    }
    public Collection <Book> countBookByLanguageName()
    {
        return bookRepository.countBookByLanguageName();
    }
    
    
    
}
