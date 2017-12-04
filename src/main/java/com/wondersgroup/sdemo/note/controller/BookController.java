package com.wondersgroup.sdemo.note.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public class BookController {
	@RequestMapping
	public String index(){
		return "rs";
	}
	@RequestMapping(value="save", 
		    method=RequestMethod.POST)
	public String save(@RequestBody Map map){
		System.out.println(map);
		return "rs";
	}

}
