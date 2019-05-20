// =================================================================================================
// Copyright (c) 2017-2020 BMW Group. All rights reserved.
// =================================================================================================
package msg.right;

/**
 * All user Permissions.
 *
 * @author msg-system ag;  Daniel Donea
 * @since 1.0
 */
public class Permission {
    // a class with Strings is used as JAAS expects String values
    // can be refactored to enum and PermissionEntity.type will be of this enum
    // but adds additional method calls to role checks

    public static final String PERMISSION_MANAGEMENT = "PERMISSION_MANAGEMENT";
    public static final String USER_MANAGEMENT = "USER_MANAGEMENT";
    public static final String BUG_MANAGEMENT = "BUG_MANAGEMENT";

}
