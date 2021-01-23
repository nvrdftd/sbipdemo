package io.lungchen.sbipdemo.account;

public class Account {
    private Integer id;
    private String accountId;
    private String key;
    private String returnCode;

    public Account(Integer id, String accountId, String key, String returnCode) {
        this.id = id;
        this.accountId = accountId;
        this.key = key;
        this.returnCode = returnCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }
}
