package io.lungchen.sbipdemo.transfer;

import io.lungchen.sbipdemo.request.RequestBody;

public class TransferRequestBody extends RequestBody {
    private String from;
    private String to;
    private Double amount;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return getId().toString() + getTimestamp().toString()
                + "from" + getFrom() + "to" + getTo() + "amount" + getAmount().toString() + getKey();
    }
}
