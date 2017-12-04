package com.wondersgroup.sdemo.book.service.impl;

import java.io.IOException;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wondersgroup.sdemo.book.repository.dao.BookDao;
import com.wondersgroup.sdemo.book.repository.domains.BookDomain;
import com.wondersgroup.sdemo.book.service.BookService;
import com.wondersgroup.sdemo.book.web.beans.BookBean;
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao bookDao;
	@Override
	public void saveBook(BookBean bookBean) {
		
		saveBook(bookBean.getUrl());
	}
	private   void saveBook(String url) {
        try {
         Document doc = Jsoup.connect(url) 
          //.data("query", "Java")
          //.userAgent("头部")
          //.cookie("auth", "token")
          //.timeout(3000)
          //.post()
          .get();
         String bookName=doc.select("meta[name$=book_name]").attr("content");
         String author=doc.select("meta[name$=author]").attr("content");
         String description=doc.select("meta[property$=description]").attr("content");
         BookDomain bookDomain=new BookDomain();
         bookDomain.setAuthor(author);
         bookDomain.setCreateTime(new Date());
         bookDomain.setName(bookName);
         bookDomain.setDescription(description);
         bookDao.save(bookDomain);
         String chapterUrl=doc.select("a[href^=http://book.zongheng.com/showchapter]").attr("href");
         saveChapter(chapterUrl);
//        //得到html的所有东西
//        Element content = doc.getElementById("content");
//        //分离出html下<a>...</a>之间的所有东西
//        Elements links = content.getElementsByTag("a");
//        //Elements links = doc.select("a[href]");
//        // 扩展名为.png的图片
//        Elements pngs = doc.select("img[src$=.png]");
//        // class等于masthead的div标签
//        Element masthead = doc.select("div.masthead").first();
//            
//        for (Element link : links) {
//              //得到<a>...</a>里面的网址
//              String linkHref = link.attr("href");
//              //得到<a>...</a>里面的汉字
//              String linkText = link.text();
//              System.out.println(linkText);
//            }
        } catch (IOException e) {
              e.printStackTrace();
        }
    }
	private static void saveChapter(String url){
		
		 try {
			Document doc = Jsoup.connect(url) 
			          //.data("query", "Java")
			          //.userAgent("头部")
			          //.cookie("auth", "token")
			          //.timeout(3000)
			          //.post()
			          .get();
			
			Elements booklists = doc.getElementsByClass("booklist tomeBean");
			for (Element element : booklists) {
				System.out.println(element.attr("tomename"));
				Elements chapters = element.getElementsByTag("td");
				for (Element chapter : chapters) {
					System.out.println(chapter.getElementsByTag("a").text());
				}
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		saveChapter("http://book.zongheng.com/showchapter/39813.html");
	}

}
