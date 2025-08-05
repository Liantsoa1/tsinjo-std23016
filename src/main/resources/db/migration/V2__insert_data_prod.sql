-- Insert donors (prod)
INSERT INTO donor (donor_id, full_name) VALUES
                                            (101, 'Randrianarisoa Lala'),
                                            (102, 'Rakotomahazo Fanja');

-- Insert beneficiaries (prod)
INSERT INTO beneficiary (beneficiary_id, full_name) VALUES
                                                        (101, 'Rakotomalala Harisoa'),
                                                        (102, 'Rasendrasoa Tahina');

-- Insert payments (prod)
INSERT INTO payment (payment_id, payment_date, payment_amount, means_of_payment, verification_status) VALUES
                                                                                                          ('MP250901.0800.A04567', '2025-09-01', 150000, 'ORANGE', 'SUCCEEDED'),
                                                                                                          ('MP250902.0900.B05678', '2025-09-02', 200000, 'ORANGE', 'SUCCEEDED');

-- Insert donations (prod)
INSERT INTO donation (donation_id, donor_id, payment_id) VALUES
                                                             (101, 101, 'MP250901.0800.A04567'),
                                                             (102, 102, 'MP250902.0900.B05678');

-- Insert helps (prod)
INSERT INTO help (help_id, beneficiary_id, payment_id, description) VALUES
                                                                        (101, 101, 'MP250901.0800.A04567', 'Opération chirurgicale'),
                                                                        (102, 102, 'MP250902.0900.B05678', 'Soins intensifs');
