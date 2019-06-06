import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest,} from '@angular/common/http';
import {Observable} from "rxjs";
import {AuthenticationService} from "../services/authentication/authentication.service";
import {Injectable} from "@angular/core";
import {LoginService} from "../../features/login/services/login.service";

@Injectable()
export class AddHeaderInterceptor implements HttpInterceptor {

  constructor(private permissionService: AuthenticationService) {
  }

  intercept(req: HttpRequest<LoginService>, next: HttpHandler): Observable<HttpEvent<any>> {
    // Clone the request to add the new header
    console.log(req.url)
    if (!new RegExp('^/jbugs/jbugs-api/users/login').test(req.url)) {

      const clonedRequest = req.clone({
        headers: req.headers.set('Authorization', 'Bearer ' + this.permissionService.getToken()),
      });

      return next.handle(clonedRequest);

    } else {
      return next.handle(req);
    }

    // Pass the cloned request instead of the original request to the next handle

  }
}
