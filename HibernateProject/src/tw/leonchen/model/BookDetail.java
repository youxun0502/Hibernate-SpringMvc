package tw.leonchen.model;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity @Table(name = "bookDetail")
public class BookDetail {
	
//	@GeneratedValue(generator = "generator")
//	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name="property", value = "book"))	
	@Id @Column(name = "ID",insertable = false, updatable = false)
	private int id;
	 
	@Column(name = "PUBLISHER")
	private String publisher;
	
	@Column(name = "PUBLISHERADDRESS")
	private String publisheraddress;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Book book;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublisheraddress() {
		return publisheraddress;
	}

	public void setPublisheraddress(String publisheraddress) {
		this.publisheraddress = publisheraddress;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}

