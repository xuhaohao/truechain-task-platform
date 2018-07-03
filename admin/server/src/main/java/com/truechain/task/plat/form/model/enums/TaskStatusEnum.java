package com.truechain.task.plat.form.model.enums;

public enum TaskStatusEnum {

    ENABLE(1), DISABLE(0);

    private int code;


    TaskStatusEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
