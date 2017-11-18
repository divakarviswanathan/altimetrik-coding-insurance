package com.insurance.insurance.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.insurance.constants.ClaimStatus;
import com.insurance.insurance.exception.InsufficientDocumentsException;
import com.insurance.insurance.rest.entity.ClaimDTO;
import com.insurance.insurance.service.ClaimService;
import com.insurance.insurance.util.ClaimUtil;
import com.insurance.insurance.util.ObjectConverterUtil;

/**
 * @author divakar
 *
 */
@RestController
@RequestMapping("v1/claims")
public class ClaimsController {

	private final Logger logger = LoggerFactory.getLogger(ClaimsController.class);

	@Autowired
	private ClaimService claimService;

	@Autowired
	private ClaimUtil claimUtil;

	@Autowired
	private ObjectConverterUtil objectConverter;

	@RequestMapping(method = RequestMethod.POST)
	public String submitClaim(@RequestBody ClaimDTO claimDTO) throws InsufficientDocumentsException, Exception {
		logger.info("Entering subtmit claims");
		if (!claimUtil.validateClaimDocuments(claimDTO.getSupportingDocuments())) {
			throw new InsufficientDocumentsException();
		}
		claimDTO.setSubmissionDate(claimUtil.getSubmissiongDate());
		claimDTO.setDueDate(claimUtil.getDueDate());
		claimDTO.setClaimStatus(ClaimStatus.SUBMITTED.toString());
		claimService.saveClaim(objectConverter.convertFromDTO(claimDTO));
		return "SUCCESS";
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<ClaimDTO> getAllClaims() throws Exception {
		logger.info("Entering get all claims");
		return claimService.getAllClaims();
	}

	@RequestMapping(value = "/claimstoday", method = RequestMethod.GET)
	public List<ClaimDTO> getPendingClaimsToday() throws Exception {
		logger.info("Entering claims today");
		return claimService.getClaimsDueToday();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ClaimDTO getClaim(@PathVariable("id") long id) throws Exception {
		logger.info("Entering get claim");
		return claimService.getClaimById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String updateClaim(@RequestBody ClaimDTO claimDTO) throws InsufficientDocumentsException, Exception {
		logger.info("Entering update claim");
		if (!claimUtil.validateClaimDocuments(claimDTO.getSupportingDocuments())) {
			throw new InsufficientDocumentsException();
		}
		claimService.saveClaim(objectConverter.convertFromDTO(claimDTO));
		return "DATAUPDATED";
	}
}
