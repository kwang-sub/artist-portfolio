/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package org.openapitools.client.apis

import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import org.openapitools.client.infrastructure.ApiClient
import org.openapitools.client.infrastructure.ApiResponse
import org.openapitools.client.infrastructure.ClientError
import org.openapitools.client.infrastructure.ClientException
import org.openapitools.client.infrastructure.MultiValueMap
import org.openapitools.client.infrastructure.RequestConfig
import org.openapitools.client.infrastructure.RequestMethod
import org.openapitools.client.infrastructure.ResponseType
import org.openapitools.client.infrastructure.ServerError
import org.openapitools.client.infrastructure.ServerException
import org.openapitools.client.infrastructure.Success
import org.openapitools.client.infrastructure.toMultiValue
import org.openapitools.client.models.BSDsResponse
import org.openapitools.client.models.BitlinkOverridesData
import java.io.IOException

class BSDsApi(basePath: kotlin.String = defaultBasePath, client: OkHttpClient = ApiClient.defaultClient) : ApiClient(basePath, client) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty(ApiClient.baseUrlKey, "https://api-ssl.bitly.com/v4")
        }
    }

    /**
     * Get BSDs
     * Fetch all Branded Short Domains
     * @return BSDsResponse
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun getBSDs(): BSDsResponse {
        val localVarResponse = getBSDsWithHttpInfo()

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as BSDsResponse
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * Get BSDs
     * Fetch all Branded Short Domains
     * @return ApiResponse<BSDsResponse?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun getBSDsWithHttpInfo(): ApiResponse<BSDsResponse?> {
        val localVariableConfig = getBSDsRequestConfig()

        return request<Unit, BSDsResponse>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation getBSDs
     *
     * @return RequestConfig
     */
    fun getBSDsRequestConfig(): RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/bsds",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = true,
            body = localVariableBody
        )
    }

    /**
     * Group Overrides
     * retrieves all account overrides matching specified group_guid and bsd query filters.
     * @param groupGuid GUIDs for a Bitly group (optional)
     * @param createdAfter Timestamp as an integer unix epoch (optional)
     * @param limit limit the amount of results returned (optional)
     * @param offset set the starting index of the result set (optional)
     * @param bsd a branded short domains to filter results (optional)
     * @return BitlinkOverridesData
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun getOverridesForGroups(groupGuid: kotlin.collections.List<kotlin.String>? = null, createdAfter: kotlin.Int? = null, limit: kotlin.Int? = null, offset: kotlin.Int? = null, bsd: kotlin.collections.List<kotlin.String>? = null): BitlinkOverridesData {
        val localVarResponse = getOverridesForGroupsWithHttpInfo(groupGuid = groupGuid, createdAfter = createdAfter, limit = limit, offset = offset, bsd = bsd)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as BitlinkOverridesData
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * Group Overrides
     * retrieves all account overrides matching specified group_guid and bsd query filters.
     * @param groupGuid GUIDs for a Bitly group (optional)
     * @param createdAfter Timestamp as an integer unix epoch (optional)
     * @param limit limit the amount of results returned (optional)
     * @param offset set the starting index of the result set (optional)
     * @param bsd a branded short domains to filter results (optional)
     * @return ApiResponse<BitlinkOverridesData?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun getOverridesForGroupsWithHttpInfo(groupGuid: kotlin.collections.List<kotlin.String>?, createdAfter: kotlin.Int?, limit: kotlin.Int?, offset: kotlin.Int?, bsd: kotlin.collections.List<kotlin.String>?): ApiResponse<BitlinkOverridesData?> {
        val localVariableConfig = getOverridesForGroupsRequestConfig(groupGuid = groupGuid, createdAfter = createdAfter, limit = limit, offset = offset, bsd = bsd)

        return request<Unit, BitlinkOverridesData>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation getOverridesForGroups
     *
     * @param groupGuid GUIDs for a Bitly group (optional)
     * @param createdAfter Timestamp as an integer unix epoch (optional)
     * @param limit limit the amount of results returned (optional)
     * @param offset set the starting index of the result set (optional)
     * @param bsd a branded short domains to filter results (optional)
     * @return RequestConfig
     */
    fun getOverridesForGroupsRequestConfig(groupGuid: kotlin.collections.List<kotlin.String>?, createdAfter: kotlin.Int?, limit: kotlin.Int?, offset: kotlin.Int?, bsd: kotlin.collections.List<kotlin.String>?): RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, kotlin.collections.List<kotlin.String>>()
            .apply {
                if (groupGuid != null) {
                    put("group_guid", toMultiValue(groupGuid.toList(), "multi"))
                }
                if (createdAfter != null) {
                    put("created_after", listOf(createdAfter.toString()))
                }
                if (limit != null) {
                    put("limit", listOf(limit.toString()))
                }
                if (offset != null) {
                    put("offset", listOf(offset.toString()))
                }
                if (bsd != null) {
                    put("bsd", toMultiValue(bsd.toList(), "multi"))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/groups/{group_guid}/overrides",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = true,
            body = localVariableBody
        )
    }

    private fun encodeURIComponent(uriComponent: kotlin.String): kotlin.String =
        HttpUrl.Builder().scheme("http").host("localhost").addPathSegment(uriComponent).build().encodedPathSegments[0]
}