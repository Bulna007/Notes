package com.idgen.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

@Entity
@Table(name = "orders")
public class Order implements Serializable {
	private static final long serialVersionUID = 2200094262458866684L;

	@Id
	@Column(name = "order_no")
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbgen")
	@TableGenerator(name = "tbgen", table = "unique_keys", pkColumnName = "pk_column", valueColumnName = "pk_val", pkColumnValue = "order_no", allocationSize = 1)
	private int orderNo;
	@Column(name = "customer_nm")
	private String customerName;
	@Column(name = "ordered_dt")
	private LocalDate orderedDate;
	private double amount;

//	public UUID getOrderNo() {
//		return orderNo;
//	}
//
//	public void setOrderNo(UUID orderNo) {
//		this.orderNo = orderNo;
//	}

	public String getCustomerName() {
		return customerName;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public LocalDate getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(LocalDate orderedDate) {
		this.orderedDate = orderedDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
