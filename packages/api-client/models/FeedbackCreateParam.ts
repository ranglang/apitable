/**
 * Api Document
 * Backend_Server Api Document
 *
 * OpenAPI spec version: v1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { HttpFile } from '../http/http';

export class FeedbackCreateParam {
    'trainingId'?: string;
    'conversationId'?: string;
    'like'?: number;
    'messageIndex'?: number;
    'comment'?: string;

    static readonly discriminator: string | undefined = undefined;

    static readonly attributeTypeMap: Array<{name: string, baseName: string, type: string, format: string}> = [
        {
            "name": "trainingId",
            "baseName": "trainingId",
            "type": "string",
            "format": ""
        },
        {
            "name": "conversationId",
            "baseName": "conversationId",
            "type": "string",
            "format": ""
        },
        {
            "name": "like",
            "baseName": "like",
            "type": "number",
            "format": "int32"
        },
        {
            "name": "messageIndex",
            "baseName": "messageIndex",
            "type": "number",
            "format": "int32"
        },
        {
            "name": "comment",
            "baseName": "comment",
            "type": "string",
            "format": ""
        }    ];

    static getAttributeTypeMap() {
        return FeedbackCreateParam.attributeTypeMap;
    }

    public constructor() {
    }
}
