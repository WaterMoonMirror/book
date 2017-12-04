package com.wondersgroup.sdemo.book.repository.condion;

import java.util.List;

import org.jsoup.nodes.Document;

public interface IBookCondion<T> {
	
	public List<T> getList(Document doc);

}
