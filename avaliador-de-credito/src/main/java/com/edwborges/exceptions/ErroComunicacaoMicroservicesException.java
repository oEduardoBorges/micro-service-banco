package com.edwborges.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErroComunicacaoMicroservicesException extends Exception{

    private String msg;
    private Integer status;

    public ErroComunicacaoMicroservicesException(String msg, Integer status) {
        super(msg);
        this.msg = msg;
        this.status = status;
    }
}
