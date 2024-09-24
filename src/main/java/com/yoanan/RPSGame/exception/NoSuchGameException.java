package com.yoanan.RPSGame.exception;

public class NoSuchGameException extends IllegalArgumentException{

    public NoSuchGameException() {
    }

    public NoSuchGameException(String s) {
        super(s);
    }
}
