export interface PermissionJSON {
  id: number;
  description: string;
  type: string;
}

export class RoleJSON {
  id: number;
  type: string;
  permissions: PermissionJSON[];
}

export class Role {
  id: number;
  type: string;
  permissions: Permission[] = [];

  static fromJSON(json: RoleJSON): Role {
    const result = new Role();
    result.type = json.type;
    result.id = json.id;
    json.permissions.map(p => result.permissions.push(Permission.fromJSON(p)));
    return result;
  }

  static toJSON(role: Role): RoleJSON {
    const permissions = [];
    role.permissions.map(p => permissions.push(Permission.toJSON(p)));
    return <RoleJSON>{
      type: role.type,
      id: role.id,
      permissions: permissions
    };
  }

  static createEmpty(): Role {
    const role = new Role();
    return role;
  }
}

export class Permission {
  id: number;
  description: string;
  type: string;

  static fromJSON(json: PermissionJSON): Permission {
    const termin = new Permission();
    termin.id = json.id;
    termin.type = json.type;
    termin.description = json.description;
    return termin;
  }

  static toJSON(permission: Permission): PermissionJSON {
    return <PermissionJSON>{
      id: permission.id,
      type: permission.type,
      description: permission.description,
    };
  }

  static createEmpty(): Permission {
    const permission = new Permission();
    return permission;
  }
}
