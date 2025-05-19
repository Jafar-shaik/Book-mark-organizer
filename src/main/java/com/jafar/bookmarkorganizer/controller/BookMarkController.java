package com.jafar.bookmarkorganizer.controller;


import com.jafar.bookmarkorganizer.entity.BookMark;
import com.jafar.bookmarkorganizer.service.BookMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bookmark")
public class BookMarkController {

    @Autowired
    private BookMarkService bookMarkService;

    @PostMapping("create")
    public ResponseEntity<?> createBookMark(@RequestBody BookMark myBookMark) {
        try {
            BookMark bookMark = bookMarkService.createBookMark(myBookMark);
            return new ResponseEntity<>(bookMark, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    @GetMapping
    public ResponseEntity<?> getAllBookMArks() {
        List<BookMark> list = bookMarkService.getAllBookMarks();
        if (list != null && !list.isEmpty())
            return new ResponseEntity<>(list, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBookMark(@PathVariable String id) {
        bookMarkService.deleteBookMark(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam(required = false) String tag, @RequestParam(required = false) String keyword) {
        if (tag != null) {
            List<BookMark> byTagContaining = bookMarkService.findByTagContaining(tag);
            return new ResponseEntity<>(byTagContaining,HttpStatus.FOUND);
        }
        if (keyword != null) {
            List<BookMark> bookMarks = bookMarkService.searchByKeyWordContaining(keyword);
            return new ResponseEntity<>(bookMarks,HttpStatus.FOUND);
        }

        List<BookMark> list = bookMarkService.getAllBookMarks();
        return new ResponseEntity<>(list,HttpStatus.FOUND);

    }

}
