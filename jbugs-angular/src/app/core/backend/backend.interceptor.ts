import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

import { JBugsMessage, JBugsMessageSeverity } from "../messaging/jbugs-message";

/**
 * Backend requests interceptor for formatting error messages.
 * Backend promises to always return errors as an array of { message, severity, errorCode }
 */
export class BackendInterceptor implements HttpInterceptor {
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(req).pipe(
      catchError(err => {
        /**
         * Create an instance of backend error.
         */
        if (err instanceof ErrorEvent) {
          // this is not from backend. Format our own message.
          const error: JBugsMessage = {
            message: err.message,
            severity: JBugsMessageSeverity.ERROR,
            errorCode: 'CONNECTION_ERROR'
          };
          return throwError([error]);
        }

        let errors = [];
        if (Array.isArray(err.error)) {
          errors = <JBugsMessage[]>err.error;
        } else {
          // Message not formatted by backend per expected interface. Standardize it.
          const message = err.status === 0 ? 'Network unavailable!' : err.message;
          errors.push({
            title: err.statusText,
            message: message,
            severity: JBugsMessageSeverity.ERROR,
            errorCode: err.errorCode || 'UNKNOWN_ERROR'
          });
        }
        return throwError(errors);
      })
    );
  }
}
