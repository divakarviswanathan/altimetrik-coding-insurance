package com.insurance.insurance.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="claim")
public class Claim {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private long insuranceid;
	@Column
	private String description;
	@Column
	private String supportingdocuments;
	@Column
	private String claimstatus;
	@Column
	private Date submissiondate;
	@Column
	private Date duedate;

	public long getId() {
		return id;
	}

	public long getInsuranceId() {
		return insuranceid;
	}

	public String getDescription() {
		return description;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setInsuranceid(long insuranceId) {
		this.insuranceid = insuranceId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSupportingdocuments() {
		return supportingdocuments;
	}

	public String getClaimstatus() {
		return claimstatus;
	}

	public Date getSubmissiondate() {
		return submissiondate;
	}

	public Date getDuedate() {
		return duedate;
	}

	public void setSupportingdocuments(String supportingdocuments) {
		this.supportingdocuments = supportingdocuments;
	}

	public void setClaimstatus(String claimstatus) {
		this.claimstatus = claimstatus;
	}

	public void setSubmissiondate(Date submissiondate) {
		this.submissiondate = submissiondate;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}

}
