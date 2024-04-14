package com.jpaorm.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "insurance_plan")
public class InsurancePlan implements Serializable {
	private static final long serialVersionUID = -7719609288998030553L;
	@Id
	@Column(name = "plan_no")
	private int planNo;
	@Column(name = "plan_nm")
	private String planName;
	@Column(name = "plan_type")
	private String planType;
	@Column(name = "min_tenure")
	private int minTenure;
	@Column(name = "min_insurred_amt")
	private double minInsurredAmount;
	@Column(name = "min_age")
	private int minAge;
	@Column(name = "maturity_bonus_percentage")
	private double maturityBonusPercentage;

}
