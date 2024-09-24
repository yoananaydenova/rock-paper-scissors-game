package com.yoanan.RPSGame.exception;

public class NoSuchGameException extends IllegalArgumentException{

    public NoSuchGameException() {
        super("The game doesn't exist!");
    }

    public NoSuchGameException(String s) {
        super(s);
    }
}
