package com.wondersgroup.sdemo.book.repository.condion;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.wondersgroup.sdemo.book.repository.domains.BaseBookDoamin;
public abstract class IBookCondion {

	private  Document doc;
	public final static String BOOK_INFO="bookInfo";
	public final static String CHAPTER_INFO="chapterInfo";
	public final static String PART_INFO="partInfo";
	public IBookCondion(String url) {
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Map<String ,BaseBookDoamin> getBook(){
		BaseBookDoamin bookInfo = getBookInfo(doc);
		BaseBookDoamin chapterInfo = getChapterInfo( bookInfo);
		BaseBookDoamin partInfo = getPartInfo( chapterInfo);
		Map<String ,BaseBookDoamin> bookMap=new HashMap<>();
		bookMap.put(BOOK_INFO, bookInfo);
		bookMap
		.put(CHAPTER_INFO, chapterInfo);
		bookMap
		.put(PART_INFO, partInfo);
		return bookMap;

	}
	 protected abstract BaseBookDoamin  getBookInfo(Document doc);
	 protected abstract BaseBookDoamin  getChapterInfo(BaseBookDoamin bookInfo);
	 protected abstract BaseBookDoamin  getPartInfo(BaseBookDoamin chapterInfo);

	

	



}
