package com.edilson.enums;

public enum Status {
    ACTIVE("Ativo"), INACTIVE("Inativo");

    private String status;

    private Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return status;
    }
}
