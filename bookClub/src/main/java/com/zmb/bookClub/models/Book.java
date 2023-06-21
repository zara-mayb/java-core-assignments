package com.zmb.bookClub.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="books")
public class Book {
	// ========== Primary Key ===================
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		// ========== Member Variables ==============
		@NotNull
		@Size(min=1, max=30, message="Must provide a title!")
		private String title;
		
		@NotNull
		@Size(min=1, max=30, message="Must provide a author!")
		private String author;
		
		@NotNull
		@Size(min=1, max=300, message="Must provide a comment!")
		private String thoughts;

		// ========== Data Creation Trackers ========

		@Column(updatable = false) // annotations only apply to the direct line of java code below it
		
		@DateTimeFormat(pattern="yyyy-MM-dd")
		 private Date createdAt;
		@DateTimeFormat(pattern="yyyy-MM-dd")
		 private Date updatedAt;
		// ========== Constructors ===================
		public Book() {}
		// ========== Data Creation Event ===========
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="user_id")
		private User user;
		
		@PrePersist
		protected void onCreate() {
		this.createdAt = new Date();
				}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		@PreUpdate
		protected void onUpdate() {
		this.updatedAt = new Date();
				}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getThoughts() {
			return thoughts;
		}

		public void setThoughts(String thoughts) {
			this.thoughts = thoughts;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

		// ========== Getters and Setters ===========

}
