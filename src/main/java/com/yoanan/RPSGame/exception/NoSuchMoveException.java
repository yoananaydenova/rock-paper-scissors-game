package com.yoanan.RPSGame.exception;

public class NoSuchMoveException extends IllegalArgumentException{
    public NoSuchMoveException() {
        super("The move doesn't exist!");
    }

    public NoSuchMoveException(String s) {
        super(s);
    }
}
