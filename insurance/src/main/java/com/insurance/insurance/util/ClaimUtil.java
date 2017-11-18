package com.insurance.insurance.util;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.insurance.insurance.constants.ClaimConstants;

/**
 * @author divakar
 *
 */
@Component
public class ClaimUtil {

	@Value("${claim.due.date.limit}")
	private static int dueLimit;

	public Date getSubmissiongDate() {
		return new Date();
	}

	public static Date getThatDateAfter(int daysAfter) {
		Calendar dueDate = Calendar.getInstance();
		dueDate.add(Calendar.DATE, daysAfter);
		return dueDate.getTime();
	}

	public Date getDueDate() {
		Calendar dueDate = Calendar.getInstance();
		dueDate.add(Calendar.DATE, dueLimit);
		return dueDate.getTime();
	}

	public static String getSupportingDocumentsString(List<String> supportingDocuments) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(supportingDocuments.get(0));
		for (int i = 1; i < supportingDocuments.size(); i++) {
			buffer.append(ClaimConstants.DELIMITTER).append(supportingDocuments.get(i));
		}
		return buffer.toString();
	}

	public static List<String> getSupportingDocumentsList(String supportingDocuments) {
		String[] documents = supportingDocuments.split(ClaimConstants.DELIMITTER);
		return Arrays.asList(documents);
	}

	public boolean validateClaimDocuments(List<String> supportingDocuments) {
		if (supportingDocuments == null || supportingDocuments.size() <= 0) {
			return false;
		}
		for (String locations : supportingDocuments) {
			if (StringUtils.isEmpty(locations.trim())) {
				return false;
			}
		}
		return true;
	}
}
