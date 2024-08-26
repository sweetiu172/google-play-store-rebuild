# openapi.api.UsersApi

## Load the API package
```dart
import 'package:openapi/api.dart';
```

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**usersGet**](UsersApi.md#usersget) | **GET** /users | Get all users
[**usersPost**](UsersApi.md#userspost) | **POST** /users | Create a new user
[**usersUserIdDelete**](UsersApi.md#usersuseriddelete) | **DELETE** /users/{userId} | Delete user
[**usersUserIdGet**](UsersApi.md#usersuseridget) | **GET** /users/{userId} | Get user by ID
[**usersUserIdPut**](UsersApi.md#usersuseridput) | **PUT** /users/{userId} | Update user


# **usersGet**
> UserList usersGet(page, limit)

Get all users

### Example
```dart
import 'package:openapi/api.dart';

final api_instance = UsersApi();
final page = 56; // int | Page number for pagination
final limit = 56; // int | Number of items per page

try {
    final result = api_instance.usersGet(page, limit);
    print(result);
} catch (e) {
    print('Exception when calling UsersApi->usersGet: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int**| Page number for pagination | [optional] 
 **limit** | **int**| Number of items per page | [optional] 

### Return type

[**UserList**](UserList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **usersPost**
> User usersPost(createUserRequest)

Create a new user

### Example
```dart
import 'package:openapi/api.dart';

final api_instance = UsersApi();
final createUserRequest = CreateUserRequest(); // CreateUserRequest | 

try {
    final result = api_instance.usersPost(createUserRequest);
    print(result);
} catch (e) {
    print('Exception when calling UsersApi->usersPost: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createUserRequest** | [**CreateUserRequest**](CreateUserRequest.md)|  | 

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **usersUserIdDelete**
> usersUserIdDelete(userId)

Delete user

### Example
```dart
import 'package:openapi/api.dart';

final api_instance = UsersApi();
final userId = userId_example; // String | 

try {
    api_instance.usersUserIdDelete(userId);
} catch (e) {
    print('Exception when calling UsersApi->usersUserIdDelete: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**|  | 

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **usersUserIdGet**
> User usersUserIdGet(userId)

Get user by ID

### Example
```dart
import 'package:openapi/api.dart';

final api_instance = UsersApi();
final userId = userId_example; // String | 

try {
    final result = api_instance.usersUserIdGet(userId);
    print(result);
} catch (e) {
    print('Exception when calling UsersApi->usersUserIdGet: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**|  | 

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **usersUserIdPut**
> User usersUserIdPut(userId, updateUserRequest)

Update user

### Example
```dart
import 'package:openapi/api.dart';

final api_instance = UsersApi();
final userId = userId_example; // String | 
final updateUserRequest = UpdateUserRequest(); // UpdateUserRequest | 

try {
    final result = api_instance.usersUserIdPut(userId, updateUserRequest);
    print(result);
} catch (e) {
    print('Exception when calling UsersApi->usersUserIdPut: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**|  | 
 **updateUserRequest** | [**UpdateUserRequest**](UpdateUserRequest.md)|  | 

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

