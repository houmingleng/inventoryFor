package com.examplex.demo.common;

public class Result <V>{
    private String code;
    private String msg;
    private V data;

    public Result() {
    }

    public Result(V data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public V getData() {
        return data;
    }

    public void setData(V data) {
        this.data = data;
    }

    public static Result success(){
        Result result = new Result<>();
        result.setCode("200");
        result.setMsg("success");
        return result;
    }

    public static <V> Result<V> success(V data){
        Result<V> result = new Result<>(data);
        result.setCode("200");
        result.setMsg("success");
        return  result;
    }
    public static Result error(String code, String message){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(message);
        return  result;
    }
}
