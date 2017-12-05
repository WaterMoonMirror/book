package com.wondersgroup.sdemo.book.repository.domains;

import java.util.List;

public abstract class BaseBookDoamin<T> {
	
	
	private List<T> childList ;

	public List<T> getChildList() {
		return childList;
	}

	public void setChildList(List<T> childList) {
		this.childList = childList;
	} 
	

}
