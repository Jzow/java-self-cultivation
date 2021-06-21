package com.jameszow.factory;

import javax.security.auth.login.CredentialNotFoundException;

/**
 * 病种实体类
 * 描述: 此类是病种实体类，然后封装Builder 模式
 *
 * @author James Zow
 * @create 2021/6/12
 */
public class Disease {

    private String diseaseName;
    private int diseaseType;
    private String diseaseCase;
    private String diseaseRelation;

    Disease(Builder builder){
        diseaseType = builder.diseaseType;
        diseaseName = builder.diseaseName;
        diseaseCase = builder.diseaseCase;
        diseaseRelation = builder.diseaseRelation;
    }

    static class Builder{

        private final int diseaseType;
        private String diseaseName;
        private String diseaseCase;
        private String diseaseRelation;

        // 有参构造函数
        public Builder(int diseaseType){
            this.diseaseType = diseaseType;
        }

        public Builder diseaseName(String val){
            diseaseName = val;
            return this;
        }

        public Builder diseaseCase(String val){
            diseaseCase = val;
            return this;
        }

        public Builder diseaseRelation(String val){
            diseaseRelation = val;
            return this;
        }

        public Disease Builder(){
            return new Disease(this);
        }
    }
}
