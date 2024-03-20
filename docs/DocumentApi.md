# DocumentApi

All URIs are relative to *https://app.onedoclabs.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**generatePdfFromBucket**](DocumentApi.md#generatePdfFromBucket) | **POST** /api/docs/generate | Generates a PDF from a specified bucket. |
| [**renderingBucket**](DocumentApi.md#renderingBucket) | **POST** /api/docs/initiate | Initiates a document&#39;s rendering |


<a name="generatePdfFromBucket"></a>
# **generatePdfFromBucket**
> File generatePdfFromBucket(documentGeneratePdfFromBucketRequest).execute();

Generates a PDF from a specified bucket.

This route is responsible for generating a PDF from a bucket.  It expects a JSON body with details of the bucket, user credentials, and PDF generation options.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.OneDoc;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.DocumentApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://app.onedoclabs.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    OneDoc client = new OneDoc(configuration);
    String title = "document"; // The title of the PDF, defaults to \\\"document\\\".
    String bucket = "bucket_example"; // The identifier of the bucket.
    String password = "password_example"; // The password of the bucket.
    String username = "username_example"; // The username of the bucket.
    Boolean test = true; // Whether or not to generate a test PDF, defaults to true.
    Boolean save = false; // Whether or not to save the PDF to the bucket, defaults to false.
    Integer expiresIn = 56; // The expiration time of the PDF in days, default is 1 day.
    try {
      File result = client
              .document
              .generatePdfFromBucket()
              .title(title)
              .bucket(bucket)
              .password(password)
              .username(username)
              .test(test)
              .save(save)
              .expiresIn(expiresIn)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling DocumentApi#generatePdfFromBucket");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<File> response = client
              .document
              .generatePdfFromBucket()
              .title(title)
              .bucket(bucket)
              .password(password)
              .username(username)
              .test(test)
              .save(save)
              .expiresIn(expiresIn)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling DocumentApi#generatePdfFromBucket");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **documentGeneratePdfFromBucketRequest** | [**DocumentGeneratePdfFromBucketRequest**](DocumentGeneratePdfFromBucketRequest.md)|  | |

### Return type

[**File**](File.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/pdf

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | PDF generated and returned successfully. |  -  |
| **400** | Bad request, missing or incorrect data. |  -  |
| **401** | Unauthorized, no API key found or invalid API key. |  -  |
| **404** | Bucket not found. |  -  |
| **500** | Server error or unable to process the request. |  -  |

<a name="renderingBucket"></a>
# **renderingBucket**
> DocumentRenderingBucketResponse renderingBucket(documentRenderingBucketRequest).execute();

Initiates a document&#39;s rendering

This endpoint creates a bucket for the html and all specified assets. It returns signed urls to the buckets.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.OneDoc;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.DocumentApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://app.onedoclabs.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    OneDoc client = new OneDoc(configuration);
    List<DocumentRenderingBucketRequestAssetsInner> assets = Arrays.asList(); // Array of assets to generate signed URLs for.
    try {
      DocumentRenderingBucketResponse result = client
              .document
              .renderingBucket()
              .assets(assets)
              .execute();
      System.out.println(result);
      System.out.println(result.getUploadURL());
      System.out.println(result.getUsername());
      System.out.println(result.getPassword());
      System.out.println(result.getBucket());
      System.out.println(result.getSignedUrls());
    } catch (ApiException e) {
      System.err.println("Exception when calling DocumentApi#renderingBucket");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<DocumentRenderingBucketResponse> response = client
              .document
              .renderingBucket()
              .assets(assets)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling DocumentApi#renderingBucket");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **documentRenderingBucketRequest** | [**DocumentRenderingBucketRequest**](DocumentRenderingBucketRequest.md)|  | |

### Return type

[**DocumentRenderingBucketResponse**](DocumentRenderingBucketResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully generated and returned signed URLs along with user credentials. |  -  |
| **401** | Unauthorized, no API key found or invalid API key. |  -  |
| **500** | Server error or unable to process the request. |  -  |

