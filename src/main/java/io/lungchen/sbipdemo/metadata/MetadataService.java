package io.lungchen.sbipdemo.metadata;

public class MetadataService {
    private static MetadataService metadataService;
    private Integer id;

    private MetadataService(Integer id) {
        this.id = id;
    }

    public static MetadataService getMetadataService() {
        if (metadataService == null) {
            metadataService = new MetadataService(0);
        }

        return metadataService;
    }

    public Metadata nextMetadata() {
        return new Metadata(id++, System.currentTimeMillis());
    }
}
