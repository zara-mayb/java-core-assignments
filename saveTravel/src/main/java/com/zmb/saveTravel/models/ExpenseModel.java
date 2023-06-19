package com.zmb.saveTravel.models;

import java.util.Date; 

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="expenses")
public class ExpenseModel {
	// ========== Primary Key ===================
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		// ========== Member Variables ==============
		
		@NotNull
		@Size(min=1, max=25, message="must provide a name")
		private String name;
		
		@NotNull
		@Size(min=1, max=25, message="must provide a vendor name")
		private String vendor;
		
		@NotNull
		private Double amount;
		
		@NotNull
		@Size(min=1, max=300, message="must provide a description")
		private String description;
		


		// ========== Data Creation Trackers ========

		@Column(updatable = false) // annotations only apply to the direct line of java code below it
		 private Date createdAt;
		 private Date updatedAt;
		// ========== Constructors ===================
		 
		 public ExpenseModel() {}
		 
		 public ExpenseModel(String name, String vendor, Double amount, String description) {
			 this.name = name;
			 this.vendor = vendor;
			 this.amount = amount;
			 this.description = description;
		 }
		 
		// ========== Data Creation Event ===========

		@PrePersist
		protected void onCreate() {
		this.createdAt = new Date();
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

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getVendor() {
			return vendor;
		}

		public void setVendor(String vendor) {
			this.vendor = vendor;
		}

		public Double getAmount() {
			return amount;
		}

		public void setAmount(Double amount) {
			this.amount = amount;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
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
