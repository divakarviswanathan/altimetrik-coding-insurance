package com.insurance.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.insurance.model.Claim;

/**
 * @author divakar
 *
 */
public interface ClaimRepository extends JpaRepository<Claim, Long> {
	// List<Claim> findClaimsByDueDateBetween(Date date1, Date date2);
}
