package com.wondersgroup.sdemo.book.repository.domains;

import org.jsoup.nodes.Document;

import com.wondersgroup.sdemo.book.repository.condion.IBookCondion;

public class ZhzwBookDomain extends IBookCondion {

	public ZhzwBookDomain(String url) {
		super(url);
	}

	@Override
	protected BaseBookDoamin getBookInfo(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected BaseBookDoamin getChapterInfo(BaseBookDoamin bookInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected BaseBookDoamin getPartInfo(BaseBookDoamin chapterInfo) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
