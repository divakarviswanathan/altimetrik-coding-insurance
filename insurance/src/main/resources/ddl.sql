create TABLE policy (
	id BIGINT PRIMARY KEY auto_increment,
	name VARCHAR(64),
	type VARCHAR(64)
);

CREATE TABLE claim (
  id   BIGINT PRIMARY KEY auto_increment,
  insuranceid BIGINT,
  claimstatus VARCHAR(16),
  description VARCHAR(256),
  manufacturer VARCHAR(32),
  type VARCHAR(32),
  supportingdocuments VARCHAR(512),
  submissiondate date,
  duedate date,
  FOREIGN KEY (insuranceId) REFERENCES policy(id)
);