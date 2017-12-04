package com.wondersgroup.sdemo.book.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wondersgroup.sdemo.book.repository.domains.BookDomain;
@Repository
public interface BookDao extends JpaRepository<BookDomain, Integer>  {

}
