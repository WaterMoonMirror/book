package com.wondersgroup.sdemo.book.repository.domains;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
@Table(name="tb_part")
public class PartDomain {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String Content;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	@ManyToOne
	@JoinColumn(name="cid")
	@JsonBackReference
	private ChapterDomain chapter;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ChapterDomain getChapter() {
		return chapter;
	}

	public void setChapter(ChapterDomain chapter) {
		this.chapter = chapter;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	

}
