package com.insurance.insurance.service;

import java.util.List;

import com.insurance.insurance.model.Claim;
import com.insurance.insurance.rest.entity.ClaimDTO;

/**
 * @author divakar
 *
 */
public interface ClaimService {

	public void saveClaim(Claim claim);

	public ClaimDTO getClaimById(long id);

	public List<ClaimDTO> getAllClaims();

	public List<ClaimDTO> getClaimsDueToday();

}
