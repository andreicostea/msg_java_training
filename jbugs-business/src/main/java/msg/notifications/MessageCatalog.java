// =================================================================================================
// Copyright (c) 2017-2020 BMW Group. All rights reserved.
// =================================================================================================
package msg.notifications;

import msg.exeptions.ExceptionMessage;

/**
 * A catalog of all the Messages thrown from the Notification component.
 *
 * @author msg-system ag;  Daniel Donea
 * @since 1.0
 */
public class MessageCatalog {

    /** A message for the case when a user already exists with the same email. */
    public static final ExceptionMessage MESSAGE_PARAMS_AND_TYPE_ARE_INCOMPATIBLE
            = new ExceptionMessage("NOTIF-01", "The input message parameters do not correspond to "
                + " the sent message type.");
}
