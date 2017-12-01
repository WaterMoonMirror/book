package com.wondersgroup.sdemo.note.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wondersgroup.sdemo.note.bean.BookBean;

public interface BookRepository extends JpaRepository<BookBean, Integer>  {

}
