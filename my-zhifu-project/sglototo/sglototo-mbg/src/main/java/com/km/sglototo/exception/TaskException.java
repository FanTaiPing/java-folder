//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.km.sglototo.exception;

public class TaskException extends RuntimeException {
    private static final long serialVersionUID = 2874510430549463213L;
    private int returnCode;

    public TaskException() {
    }

    public TaskException(String message, Throwable cause) {
        super(message, cause);
    }

    public TaskException(String message) {
        super(message);
    }

    public TaskException(Throwable cause) {
        super(cause);
    }

    public TaskException(int returnCode) {
        this.returnCode = returnCode;
    }

    public TaskException(Exception e, int returnCode) {
        super(e);
        this.returnCode = returnCode;
    }

    public TaskException(String message, int returnCode) {
        super(message);
        this.returnCode = returnCode;
    }

    public TaskException(String message, Exception e, int returnCode) {
        super(message, e);
        this.returnCode = returnCode;
    }

    public int getReturnCode() {
        return this.returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }
}
