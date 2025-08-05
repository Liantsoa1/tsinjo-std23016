-- Insert donors
INSERT INTO donor (donor_id, full_name) VALUES
                                            (1, 'Rakoto Jean'),
                                            (2, 'Rajaonarivelo Naina');

-- Insert beneficiaries
INSERT INTO beneficiary (beneficiary_id, full_name) VALUES
                                                        (1, 'Andriamampianina Mamy'),
                                                        (2, 'Rasoa Tiana');

-- Insert payments
INSERT INTO payment (payment_id, payment_date, payment_amount, means_of_payment, verification_status) VALUES
                                                                                                          ('MP250804.0904.A01637', '2025-08-01', 50000, 'ORANGE', 'SUCCEEDED'),
                                                                                                          ('MP250805.1015.B02745', '2025-08-02', 100000, 'ORANGE', 'SUCCEEDED'),
                                                                                                          ('MP250806.1105.C03756', '2025-08-03', 75000, 'ORANGE', 'VERIFYING'),
                                                                                                          ('MP250807.1207.D04789', '2025-08-04', 30000, 'ORANGE', 'FAILED');

-- Insert donations
INSERT INTO donation (donation_id, donor_id, payment_id) VALUES
                                                             (1, 1, 'MP250804.0904.A01637'),
                                                             (2, 2, 'MP250805.1015.B02745');

-- Insert helps
INSERT INTO help (help_id, beneficiary_id, payment_id, description) VALUES
                                                                        (1, 1, 'MP250806.1105.C03756', 'Accident voiture'),
                                                                        (2, 2, 'MP250807.1207.D04789', 'Hospitalisation');
