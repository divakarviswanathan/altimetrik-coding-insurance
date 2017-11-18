package com.insurance.insurance.rest.entity;

import java.util.Date;
import java.util.List;

/**
 * @author divakar
 *
 */
public class ClaimDTO {
	private long id;
	private long insuranceId;
	private String description;
	private List<String> supportingDocuments;
	private String claimStatus;
	private Date submissionDate;
	private Date dueDate;

	public long getId() {
		return id;
	}

	public long getInsuranceId() {
		return insuranceId;
	}

	public String getDescription() {
		return description;
	}

	public List<String> getSupportingDocuments() {
		return supportingDocuments;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setInsuranceId(long insuranceId) {
		this.insuranceId = insuranceId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setSupportingDocuments(List<String> supportingDocuments) {
		this.supportingDocuments = supportingDocuments;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public Date getSubmissionDate() {
		return submissionDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

}
