package com.insurance.insurance.util;

import org.springframework.stereotype.Component;

import com.insurance.insurance.model.Claim;
import com.insurance.insurance.rest.entity.ClaimDTO;

@Component
public class ObjectConverterUtil {

	public Claim convertFromDTO(ClaimDTO claim) {
		Claim claimEntity = new Claim();
		claimEntity.setId(claim.getId());
		claimEntity.setClaimstatus(claim.getClaimStatus());
		claimEntity.setDescription(claim.getDescription());
		claimEntity.setInsuranceid(claim.getInsuranceId());
		claimEntity.setSupportingdocuments(ClaimUtil.getSupportingDocumentsString(claim.getSupportingDocuments()));
		claimEntity.setDuedate(claim.getDueDate());
		claimEntity.setSubmissiondate(claim.getSubmissionDate());
		return claimEntity;
	}

	public ClaimDTO convertFromEntity(Claim claim) {
		if (claim == null || claim.getId() <= 0l) {
			return null;
		}
		ClaimDTO claimEntity = new ClaimDTO();
		claimEntity.setId(claim.getId());
		claimEntity.setClaimStatus(claim.getClaimstatus());
		claimEntity.setDescription(claim.getDescription());
		claimEntity.setSupportingDocuments(ClaimUtil.getSupportingDocumentsList(claim.getSupportingdocuments()));
		claimEntity.setInsuranceId(claim.getInsuranceId());
		claimEntity.setDueDate(claim.getDuedate());
		claimEntity.setSubmissionDate(claim.getSubmissiondate());
		return claimEntity;

	}
}
