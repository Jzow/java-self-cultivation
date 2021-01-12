package com.jameszow.factory;

/**
 * ClassName: UserFactory
 * Description: TODD
 * Author: James Zow
 * Date: 2021/1/6 0006 20:57
 * Version:
 **/
public class UserFactory {

    private final int id;
    private final String username;
    private final String password;
    private final String telephone;
    private final int status;

    public UserFactory(Builder builder) {
       id = builder.id;
       username = builder.username;
       password = builder.password;
       telephone = builder.telephone;
       status = builder.status;
    }

    public static class Builder{

        private final int id;

        private String username;
        private String password;
        private String telephone;
        private int status;

        public Builder(int id) {
            this.id = id;
        }

        public Builder username(String val){
            username = val;
            return this;
        }

        public Builder password(String val){
            password = val;
            return this;
        }

        public Builder telephone(String val){
            telephone = val;
            return this;
        }

        public Builder status(int val){
            status = val;
            return this;
        }

        public UserFactory Builder(){
            return new UserFactory(this);
        }
    }
}
