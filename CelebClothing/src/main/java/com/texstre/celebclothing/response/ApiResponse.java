package com.texstre.celebclothing.response;

public class ApiResponse<T> {
    private Integer httpcode;
    private String message;
    private T data;
    private Object metadata;

    public Integer getHttpcode() {
        return httpcode;
    }

    public void setHttpcode(Integer httpcode) {
        this.httpcode = httpcode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Object getMetadata() {
        return metadata;
    }

    public void setMetadata(Object metadata) {
        this.metadata = metadata;
    }

    public ApiResponse(Integer httpcode, String message, T data, Object metadata) {
        this.httpcode = httpcode;
        this.message = message;
        this.data = data;
        this.metadata = metadata;
    }

}
