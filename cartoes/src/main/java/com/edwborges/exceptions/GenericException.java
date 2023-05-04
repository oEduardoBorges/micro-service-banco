package com.edwborges.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericException extends RuntimeException {
    private static final long serialVersion = 1L;

    private String msg;

    public GenericException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
