package io.lungchen.sbipdemo.account;

import io.lungchen.sbipdemo.request.RequestBody;

public class BalanceRequestBody extends RequestBody {
    private String accountId;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return getId().toString() + getTimestamp().toString() + "accountId" + getAccountId() + getKey();
    }
}
