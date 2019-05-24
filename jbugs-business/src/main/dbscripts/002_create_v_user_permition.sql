create view v_user_permission
  as select distinct u.username, p.type from users u
                                      inner join users_roles r on u.ID = r.user_id
                                      inner join roles r2 on r.role_id = r2.ID
                                      inner join roles_permissions role on r2.ID = role.role_id
                                      inner join permissions p on role.permission_id = p.ID;