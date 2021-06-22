INSERT INTO task (name, description) VALUES ('Factorial', 'Calculate the factorial of a number');

INSERT INTO test_case (uuid, input_data, output_data, task_name) VALUES ('fc00230a-d12b-11eb-b8bc-0242ac130003', '0', '1', 'Factorial');
--INSERT INTO test_case (uuid, input_data, output_data, task_name) VALUES ('36b9c654-d12c-11eb-b8bc-0242ac130003', '1', '1', 'Factorial');
--INSERT INTO test_case (uuid, input_data, output_data, task_name) VALUES ('718f2f30-d12c-11eb-b8bc-0242ac130003', '10', '3628800', 'Factorial')

INSERT INTO `user` (uuid, username, password, score, active) VALUES ('4f6103c0-d1e0-11eb-b8bc-0242ac130003', 'User', '$2a$10$vOVAAZibCCvq.x/eUAgf9O5IjpYm2DDtX6XcnDMvXToaWYuQ8TJym', 2, 1)
INSERT INTO `user` (uuid, username, password, score, active) VALUES ('6d29a362-d1e0-11eb-b8bc-0242ac130003', 'User1', '$2a$10$vOVAAZibCCvq.x/eUAgf9O5IjpYm2DDtX6XcnDMvXToaWYuQ8TJym', 4, 1)
INSERT INTO `user` (uuid, username, password, score, active) VALUES ('71a978cc-d1e0-11eb-b8bc-0242ac130003', 'User2', '$2a$10$vOVAAZibCCvq.x/eUAgf9O5IjpYm2DDtX6XcnDMvXToaWYuQ8TJym', 0, 1)
INSERT INTO `user` (uuid, username, password, score, active) VALUES ('7c85be54-d1e0-11eb-b8bc-0242ac130003', 'User3', '$2a$10$vOVAAZibCCvq.x/eUAgf9O5IjpYm2DDtX6XcnDMvXToaWYuQ8TJym', 0, 1)