package com.myboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myboot.entity.Book;

public interface ReadingListRepostitory extends JpaRepository<Book, Long> {
	List<Book> findByReader(String reader);
}
