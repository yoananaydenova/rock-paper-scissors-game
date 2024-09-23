package com.yoanan.RPSGame;

public class NoSuchMoveException extends IllegalArgumentException{
    public NoSuchMoveException() {
    }
    public NoSuchMoveException(String s) {
        super(s);
    }
}
