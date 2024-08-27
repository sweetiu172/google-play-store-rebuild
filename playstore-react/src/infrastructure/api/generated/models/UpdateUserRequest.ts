/* tslint:disable */
/* eslint-disable */
/**
 * Sample API
 * A sample API for a Flutter application
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { mapValues } from '../runtime';
/**
 * 
 * @export
 * @interface UpdateUserRequest
 */
export interface UpdateUserRequest {
    /**
     * 
     * @type {string}
     * @memberof UpdateUserRequest
     */
    email?: string;
    /**
     * 
     * @type {string}
     * @memberof UpdateUserRequest
     */
    fullName?: string;
    /**
     * 
     * @type {string}
     * @memberof UpdateUserRequest
     */
    password?: string;
}

/**
 * Check if a given object implements the UpdateUserRequest interface.
 */
export function instanceOfUpdateUserRequest(value: object): value is UpdateUserRequest {
    return true;
}

export function UpdateUserRequestFromJSON(json: any): UpdateUserRequest {
    return UpdateUserRequestFromJSONTyped(json, false);
}

export function UpdateUserRequestFromJSONTyped(json: any, ignoreDiscriminator: boolean): UpdateUserRequest {
    if (json == null) {
        return json;
    }
    return {
        
        'email': json['email'] == null ? undefined : json['email'],
        'fullName': json['fullName'] == null ? undefined : json['fullName'],
        'password': json['password'] == null ? undefined : json['password'],
    };
}

export function UpdateUserRequestToJSON(value?: UpdateUserRequest | null): any {
    if (value == null) {
        return value;
    }
    return {
        
        'email': value['email'],
        'fullName': value['fullName'],
        'password': value['password'],
    };
}

