package com.konfigthis.client;

import com.konfigthis.client.api.DocumentApi;

public class OneDoc {
    private ApiClient apiClient;
    public final DocumentApi document;

    public OneDoc() {
        this(null);
    }

    public OneDoc(Configuration configuration) {
        this.apiClient = new ApiClient(null, configuration);
        this.document = new DocumentApi(this.apiClient);
    }

}
