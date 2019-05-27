import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


/**
 * Base backend service. Business services should import this instead of using HttpClient directly.
 */
@Injectable({
  providedIn: 'root'
})
export class BackendService {

  constructor(private http: HttpClient) {}

  /**
   *
   * @param url URL to call
   * @param params optional parameters such as HttpHeaders, HttpParams, reportProgress etc.
   * @param others additional attrs
   */
  public get(url: string, params?: any, others?: any): Observable<any> {
    return this.invoke('GET', url, null, params, others);
  }

  /**
   *
   * @param url URL to call
   * @param data payload
   * @param params parameters such as HttpHeaders, HttpParams, reportProgress etc.
   */
  public put(url: string, data: any, params?: any): Observable<any> {
    return this.invoke('PUT', url, data, params);
  }

  /**
   *
   * @param url URL to call
   * @param data payload
   * @param params parameters such as HttpHeaders, HttpParams, reportProgress etc.
   */
  public patch(url: string, data: any, params?: any): Observable<any> {
    return this.invoke('PATCH', url, data, params);
  }

  /**
   *
   * @param url URL to call
   * @param data payload
   * @param params parameters such as HttpHeaders, HttpParams, reportProgress etc.
   * @param others additional attrs
   */
  public post(url: string, data: any, params?: any, others?: any): Observable<any> {
    return this.invoke('POST', url, data, params, others);
  }

  /**
   *
   * @param url URL to call
   * @param params parameters such as HttpHeaders, HttpParams, reportProgress etc.
   */
  public delete(url: string, params?: any): Observable<any> {
    return this.invoke('DELETE', url, null, params);
  }

  private invoke(method: string, url: string, data: any = {}, params?: any, others?: any): Observable<any> {
    const options = {
      body: data,
      params,
      headers: {
        'Accept-Language': 'en',
        // "Authorization": "Basic " + btoa("admi2n" + ":" + "admin"),
        // "X-Requested-With": 'XMLHttpRequest'
      },
      ...others
    };
    if (!url) {
      throw new Error('No URL provided.');
    }
    const requestUrl = `${url}`;
    return this.http.request(method, requestUrl, options);
  }
}
