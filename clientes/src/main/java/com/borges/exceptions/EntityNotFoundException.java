package com.borges.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntityNotFoundException extends RuntimeException {
    private static final long serialVersion = 1L;

    private String msg;

    public EntityNotFoundException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
