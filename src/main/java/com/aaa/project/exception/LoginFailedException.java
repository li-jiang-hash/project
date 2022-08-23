package com.aaa.project.exception;

/**
 * @Author:江Sir
 * @Date:22 2022/08/22 21:39
 * @description: Exercise
 * @Version 1.0.0
 */
public class LoginFailedException extends RuntimeException{

    public LoginFailedException() {}

    public LoginFailedException(String message) {
        super(message);
    }

    public LoginFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginFailedException(Throwable cause) {
        super(cause);
    }

    public LoginFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
