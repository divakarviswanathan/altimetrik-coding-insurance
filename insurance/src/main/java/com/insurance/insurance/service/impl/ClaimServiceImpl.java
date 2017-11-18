package com.insurance.insurance.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.insurance.model.Claim;
import com.insurance.insurance.repository.ClaimRepository;
import com.insurance.insurance.rest.entity.ClaimDTO;
import com.insurance.insurance.service.ClaimService;
import com.insurance.insurance.util.ObjectConverterUtil;

/**
 * @author divakar
 *
 */
@Service
public class ClaimServiceImpl implements ClaimService {

	@Autowired
	private ClaimRepository claimRepository;

	@Autowired
	private ObjectConverterUtil objectConverter;

	@Override
	public void saveClaim(Claim claim) {
		claimRepository.save(claim);
	}

	@Override
	public ClaimDTO getClaimById(long id) {
		return objectConverter.convertFromEntity(claimRepository.findOne(id));
	}

	@Override
	public List<ClaimDTO> getAllClaims() {
		List<Claim> claims = claimRepository.findAll();
		List<ClaimDTO> claimDTOs = new ArrayList<>();
		for (Claim claim : claims) {
			claimDTOs.add(objectConverter.convertFromEntity(claim));
		}
		return claimDTOs;
	}

	@Override
	public List<ClaimDTO> getClaimsDueToday() {
		// List<Claim> claims = claimRepository.findClaimsByDueDateBetween(new
		// Date(), ClaimUtil.getThatDateAfter(1));
		List<Claim> claims = claimRepository.findAll();
		List<ClaimDTO> claimDTOs = new ArrayList<>();
		for (Claim claim : claims) {
			claimDTOs.add(objectConverter.convertFromEntity(claim));
		}
		return claimDTOs;
	}

}
