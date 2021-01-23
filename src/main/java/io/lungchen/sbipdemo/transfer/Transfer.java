package io.lungchen.sbipdemo.transfer;

public class Transfer {
    private Integer id;
    private String returnCode;

    public Transfer(Integer id, String returnCode) {
        this.id = id;
        this.returnCode = returnCode;
    }

    public Integer getId() {
        return id;
    }

    public String getReturnCode() {
        return returnCode;
    }
}
