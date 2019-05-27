export enum JBugsMessageSeverity {
  SUCCESS = 'SUCCESS',
  INFO = 'INFO',
  WARN = 'WARN',
  ERROR = 'ERROR'
}

/**
 * Message to display in a toast or a popup.
 */
export interface JBugsMessage {
  message: string;
  severity: JBugsMessageSeverity;
  title?: string;
  key?: string;
  errorCode?: string;
}
