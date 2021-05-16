INSERT INTO role (role_id, role_name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO role (role_id, role_name) VALUES (2, 'ROLE_USER');

INSERT INTO user_t (id, username, email, password, account_non_locked, created)
VALUES (1, 'admin', 'admin@admin.com', '$2y$10$J9fde1gcnMfrDqnfgFzLye3j68RSDj7l6Ob4ug2AA1x/8pcD/Of7e', true, current_timestamp);

INSERT INTO user_t (id, username, email, password, account_non_locked, created)
VALUES (2, 'user', 'xx@xxx.com', '$2y$10$J9fde1gcnMfrDqnfgFzLye3j68RSDj7l6Ob4ug2AA1x/8pcD/Of7e', true, current_timestamp);

INSERT INTO user_role(user_id, role_id) VALUES (1, 1);
INSERT INTO user_role(user_id, role_id) VALUES (2, 2);
