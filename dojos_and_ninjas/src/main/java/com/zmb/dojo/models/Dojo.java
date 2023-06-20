package com.zmb.dojo.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="dojos")
public class Dojo {
	// ========== Primary Key ===================
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		// ========== Member Variables ==============
		@NotNull
		@Size(min=1, max=35, message="must provide a name")
		private String name;

		// ========== Data Creation Trackers ========

		@Column(updatable = false) // annotations only apply to the direct line of java code below it
		 private Date createdAt;
		 private Date updatedAt;
		// ========== Constructors ===================
		public Dojo() {}
		// ========== Data Creation Event ===========
		@OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
	    private List<Ninjas> ninjas;

		@PrePersist
		protected void onCreate() {
		this.createdAt = new Date();
		}

		@PreUpdate
		protected void onUpdate() {
		this.updatedAt = new Date();
		}


		// ========== Getters and Setters ===========
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

		public List<Ninjas> getNinjas() {
			return ninjas;
		}

		public void setNinjas(List<Ninjas> ninjas) {
			this.ninjas = ninjas;
		}

}
