package com.mirea.kateninva.domain;

public interface ApiCallback<T> {

    public void onSuccess(T result);
    public void onFailure(Exception e);

}
