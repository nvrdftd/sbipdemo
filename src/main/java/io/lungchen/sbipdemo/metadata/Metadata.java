package io.lungchen.sbipdemo.metadata;

public class Metadata {
    private Integer id;
    private Long timestamp;

    public Metadata(Integer id, Long timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public Long getTimestamp() {
        return timestamp;
    }
}
