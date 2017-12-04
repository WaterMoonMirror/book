package com.wondersgroup.sdemo.book.repository.biuder;

import java.util.List;

import org.apache.log4j.Logger;

import com.wondersgroup.sdemo.book.repository.domains.labelDomain;

public class BookBiuder {
	
	protected static Logger log = Logger.getLogger(BookBiuder.class);
	
	public interface DocumentInter<T>{
		public List<T> getList(List<labelDomain> labels);
	}

}
