package com.jafar.bookmarkorganizer.repository;

import com.jafar.bookmarkorganizer.entity.BookMark;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookMarkRepository extends MongoRepository<BookMark,String > {
    List<BookMark> findByTagsContaining(String tag);
    @Query("{ $text: { $search: ?0 } }")
    List<BookMark> searchByKeyword(String keyword);
}
