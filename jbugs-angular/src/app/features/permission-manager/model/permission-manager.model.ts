export interface PermissionJSON {
  type: string;
  description: string;
}

export class Role {
  id: number;
  type: string;
}

export class Permission {
  type: string;
  description: string;

  static fromJSON(json: PermissionJSON): Permission {
    const termin = new Permission();
    termin.type = json.type;
    termin.description = json.description;
    return termin;
  }

  static toJSON(permission: Permission): PermissionJSON {
    return <PermissionJSON>{
      type: permission.type,
      description: permission.description,
    };
  }

  static createEmpty(): Permission {
    const permission = new Permission();
    return permission;
  }
}
