package com.texstre.celebclothing.response;

public class ApiResponse<T> {
    private String httpcode;
    private String message;
    private T data;
    private Object metadata;

    public String getHttpcode() {
        return httpcode;
    }

    public void setHttpcode(String httpcode) {
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

    public ApiResponse(String httpcode, String message, T data, Object metadata) {
        this.httpcode = httpcode;
        this.message = message;
        this.data = data;
        this.metadata = metadata;
    }

}
