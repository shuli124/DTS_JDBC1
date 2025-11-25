package com.company;

public class ServletException extends Exception {
    public ServletException(String message) {
        super(message);
    }
    
    public ServletException(Exception e) {
        super(e);
    }
}