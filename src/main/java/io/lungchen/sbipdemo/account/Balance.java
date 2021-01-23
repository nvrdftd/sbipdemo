package io.lungchen.sbipdemo.account;

public class Balance {
    private Integer id;
    private Double amount;
    private String returnCode;

    public Balance(Integer id, Double amount, String returnCode) {
        this.id = id;
        this.amount = amount;
        this.returnCode = returnCode;
    }

    public Integer getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public String getReturnCode() {
        return returnCode;
    }
}
