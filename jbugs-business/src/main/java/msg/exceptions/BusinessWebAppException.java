package msg.exceptions;

import javax.ejb.ApplicationException;

@ApplicationException
public class BusinessWebAppException extends RuntimeException {

    private ExceptionMessage exceptionMessage;
    private int status;

    public BusinessWebAppException(final ExceptionMessage exceptionMessage, int status) {
        this.exceptionMessage = exceptionMessage;
        this.status = status;
    }

    /**
     * Getter.
     *
     * @return exceptionMessage
     */
    public ExceptionMessage getExceptionMessage() {
        return this.exceptionMessage;
    }

    public void setExceptionMessage(ExceptionMessage exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
