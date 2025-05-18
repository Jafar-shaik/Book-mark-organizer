package com.jafar.bookmarkorganizer.service;

import com.jafar.bookmarkorganizer.entity.BookMark;
import com.jafar.bookmarkorganizer.repository.BookMarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookMarkService {

    @Autowired
    private BookMarkRepository bookMarkRepository;

    public BookMark createBookMark (BookMark bookMark){
        return bookMarkRepository.save(bookMark);
    }

    public List<BookMark> getAllBookMarks(){
        return bookMarkRepository.findAll();
    }

    public void deleteBookMark(String id){
        bookMarkRepository.deleteById(id);
    }

    public List<BookMark> findByTagContaining(String tag){
        return bookMarkRepository.findByTagsContaining(tag);
    }

    public List<BookMark> searchByKeyWordContaining(String keyword){
        return bookMarkRepository.searchByKeyword(keyword);
    }
}
