// =================================================================================================
// Copyright (c) 2017-2020 BMW Group. All rights reserved.
// =================================================================================================
package msg.permission;

/**
 * All user Permissions.
 *
 * @author msg-system ag;  Daniel Donea
 * @since 1.0
 */
// todo: this should be an enum
    // a class with Strings is used as JAAS expects String values
    // can be refactored to enum and PermissionType.type will be of this enum
    // but adds additional method calls to role checks
public enum PermissionType {
    PERMISSION_MANAGEMENT, USER_MANAGEMENT, BUG_MANAGEMENT, BUG_CLOSED, BUG_UPDATED
}

