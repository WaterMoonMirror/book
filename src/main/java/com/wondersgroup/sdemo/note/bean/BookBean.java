package com.wondersgroup.sdemo.note.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="book")
public class BookBean implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createdate;
	private String image;
	private String description;
	private String author;
	
	@ManyToMany(cascade={},fetch=FetchType.EAGER)
	@JoinTable(name="book_label",
			joinColumns={@JoinColumn(name="book_id")},
			inverseJoinColumns={@JoinColumn(name="label_id")})
	private List<LabelBean> labels;
	
	public BookBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public String toString() {
		return "BookBean [id=" + id + ", name=" + name + ", createdate=" + createdate + ", image=" + image
				+ ", description=" + description + ", author=" + author + ", labels=" + labels + "]";
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}



	public List<LabelBean> getLabels() {
		return labels;
	}



	public void setLabels(List<LabelBean> labels) {
		this.labels = labels;
	}

	
	
	
	
}
