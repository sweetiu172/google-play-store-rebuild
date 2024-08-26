# openapi.api.AuthApi

## Load the API package
```dart
import 'package:openapi/api.dart';
```

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**authLoginPost**](AuthApi.md#authloginpost) | **POST** /auth/login | User login


# **authLoginPost**
> LoginResponse authLoginPost(loginRequest)

User login

### Example
```dart
import 'package:openapi/api.dart';

final api_instance = AuthApi();
final loginRequest = LoginRequest(); // LoginRequest | 

try {
    final result = api_instance.authLoginPost(loginRequest);
    print(result);
} catch (e) {
    print('Exception when calling AuthApi->authLoginPost: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **loginRequest** | [**LoginRequest**](LoginRequest.md)|  | 

### Return type

[**LoginResponse**](LoginResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

