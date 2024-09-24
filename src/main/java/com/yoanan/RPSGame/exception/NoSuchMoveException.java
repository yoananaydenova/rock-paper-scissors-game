package com.yoanan.RPSGame.exception;

public class NoSuchMoveException extends IllegalArgumentException{
    public NoSuchMoveException() {
    }
    public NoSuchMoveException(String s) {
        super(s);
    }
}
