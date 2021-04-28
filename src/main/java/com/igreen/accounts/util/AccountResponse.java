package com.igreen.accounts.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountResponse {

    private long timestamp;
    private int status;
    private String error;
    private String message;
    private Object payload;
}
