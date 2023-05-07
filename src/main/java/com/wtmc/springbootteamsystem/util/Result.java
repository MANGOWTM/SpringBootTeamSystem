package com.wtmc.springbootteamsystem.util;

import cn.dev33.satoken.util.SaResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private int status;
    private Boolean success;
    private String Msg;
    private Object data;
    private Object token;
    public static Result ok() {
        return new Result(200,true,null,null,null);
    }
    public static Result ok(Object data) {
        return new Result(200,true,null,data,null);
    }
    public static Result ok(String msg, Object data,Object token) {
        return new Result(200,true,msg,data,token);
    }
    public static Result ok(String msg, Object data) {
        return new Result(200,true,msg,data,null);
    }
    public static Result ok(String msg) {
        return new Result(200,true,msg,null,null);
    }
    public static Result error(String errMsg) {
        return new Result(401,false,errMsg,null,null);
    }
    public static Result error(String errMsg,Object data) {
        return new Result(401,false,errMsg,data,null);
    }
}
