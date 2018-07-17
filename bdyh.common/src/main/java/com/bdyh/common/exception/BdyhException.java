package com.bdyh.common.exception;

import com.bdyh.common.enums.ResultEnum;

public class BdyhException extends  RuntimeException {

    private Integer code;

    public BdyhException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public  BdyhException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
