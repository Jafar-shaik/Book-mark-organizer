package com.jafar.bookmarkorganizer.controller;


import com.jafar.bookmarkorganizer.entity.BookMark;
import com.jafar.bookmarkorganizer.service.BookMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("bookmark")
public class BookMarkController {

    @Autowired
    private BookMarkService bookMarkService;

    @PostMapping("create")
    public BookMark createBookMark(@RequestBody BookMark bookMark){
        return bookMarkService.createBookMark(bookMark);
    }

    @GetMapping
    public List<BookMark> getAllBookMArks(){
        return bookMarkService.getAllBookMarks();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBookMark(@PathVariable String id){
         bookMarkService.deleteBookMark(id);
    }

    @GetMapping("/search")
    public List<BookMark> search(@RequestParam (required = false) String tag, @RequestParam (required = false) String keyword){
        if(tag!=null) return bookMarkService.findByTagContaining(tag);
        if(keyword!=null) return bookMarkService.searchByKeyWordContaining(keyword);

        return bookMarkService.getAllBookMarks();

    }

}
