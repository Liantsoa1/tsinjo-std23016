-- Table for Donor
CREATE TABLE donor (
                       donor_id BIGINT PRIMARY KEY,
                       full_name VARCHAR(100) NOT NULL
);

-- Table for Beneficiary
CREATE TABLE beneficiary (
                             beneficiary_id BIGINT PRIMARY KEY,
                             full_name VARCHAR(100) NOT NULL
);

-- Enum for Means of Payment
CREATE TYPE means_of_payment AS ENUM ('ORANGE');

-- Enum for Verification Status
CREATE TYPE verification_status AS ENUM ('VERIFYING', 'SUCCEEDED', 'FAILED');

-- Table for Payment
CREATE TABLE payment (
                         payment_id VARCHAR(100) PRIMARY KEY,
                         payment_date DATE NOT NULL,
                         payment_amount INT NOT NULL,
                         means_of_payment means_of_payment NOT NULL,
                         verification_status verification_status NOT NULL
);

-- Table for Donation
CREATE TABLE donation (
                          donation_id BIGINT PRIMARY KEY,
                          donor_id BIGINT NOT NULL,
                          payment_id VARCHAR(100) NOT NULL,
                          FOREIGN KEY (donor_id) REFERENCES donor(donor_id),
                          FOREIGN KEY (payment_id) REFERENCES payment(payment_id)
);

-- Table for Help
CREATE TABLE help (
                      help_id BIGINT PRIMARY KEY,
                      beneficiary_id BIGINT NOT NULL,
                      payment_id VARCHAR(100) NOT NULL,
                      description TEXT NOT NULL,
                      FOREIGN KEY (beneficiary_id) REFERENCES beneficiary(beneficiary_id),
                      FOREIGN KEY (payment_id) REFERENCES payment(payment_id)
);
