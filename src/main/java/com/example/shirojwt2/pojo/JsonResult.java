package com.example.shirojwt2.pojo;

public class JsonResult {

    private Integer status;

    private String msg;

    private Object data;

    public static JsonResult ok(){
        return new JsonResult(200,"请求成功",null);
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public JsonResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public JsonResult() {
    }
}
