package com.edwborges.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosClienteNotFoundException extends Exception {

    private String msg;

    public DadosClienteNotFoundException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
