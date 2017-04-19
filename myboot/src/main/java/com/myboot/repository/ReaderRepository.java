package com.myboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myboot.entity.Reader;

public interface ReaderRepository extends JpaRepository<Reader, String>{

}
