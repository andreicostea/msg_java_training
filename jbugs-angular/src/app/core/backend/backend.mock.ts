import { of } from 'rxjs';

export const mockBackend: any = {
  get() {
    return of({});
  },
  put() {},
  post() {},
  delete() {}
};
