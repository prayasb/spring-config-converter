package com.prayasb.springconfigconverter.model;

public class BeanMethod {
    private String scope;

    public BeanMethod(String scope, String methodName, String methodBody, String methodReturnType) {
        this.scope = scope;
        this.methodName = methodName;
        this.methodBody = methodBody;
        this.methodReturnType = methodReturnType;
    }

    private String methodName;
    private String methodBody;

    public String getMethodReturnType() {
        return methodReturnType;
    }

    public void setMethodReturnType(String methodReturnType) {
        this.methodReturnType = methodReturnType;
    }

    private String methodReturnType;

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodBody() {
        return methodBody;
    }

    public void setMethodBody(String methodBody) {
        this.methodBody = methodBody;
    }
}
