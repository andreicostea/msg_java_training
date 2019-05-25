package msg.bug;

import msg.exceptions.ExceptionMessage;

public class MessageCatalog {
    public static final ExceptionMessage NULL_FIELD
            = new ExceptionMessage("BUG-01", "The field is null");
    public static final ExceptionMessage LIMIT_EXCEEDED
            = new ExceptionMessage("BUG-02", "The field limit has over 250 characters");
    public static final ExceptionMessage REGEX_VIOLATION
            = new ExceptionMessage("BUG-03", "The version should contain only alphanumeric characters");
}
