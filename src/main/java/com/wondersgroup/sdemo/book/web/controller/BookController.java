package com.wondersgroup.sdemo.book.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wondersgroup.sdemo.book.service.BookService;
import com.wondersgroup.sdemo.book.web.beans.BookBean;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	BookService bookService;
	@RequestMapping("save")
	public String save( BookBean bookBean){
		bookService.saveBook(bookBean);
		return "success";
	}

}
