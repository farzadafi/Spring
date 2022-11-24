insert into permission (name) values ('user:write');
insert into permission (name) values ('user:read');
insert into role (is_enabled, name) values (true, 'ROLE_ADMIN');
insert into roles_permissions (role_id, permission_id) values (1, 1);
insert into users (is_enabled, password, username)values (true, 'admin', 'admin');
insert into users_roles (user_id, role_id) values (1, 1);