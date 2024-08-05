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
import org.openapitools.client.models.Webhook
import org.openapitools.client.models.WebhookCreate
import org.openapitools.client.models.WebhookUpdate
import org.openapitools.client.models.Webhooks
import java.io.IOException

class WebhooksApi(basePath: kotlin.String = defaultBasePath, client: OkHttpClient = ApiClient.defaultClient) : ApiClient(basePath, client) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty(ApiClient.baseUrlKey, "https://api-ssl.bitly.com/v4")
        }
    }

    /**
     * Create Webhook
     * Creates a webhook.
     * @param webhookCreate
     * @return Webhook
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun createWebhook(webhookCreate: WebhookCreate): Webhook {
        val localVarResponse = createWebhookWithHttpInfo(webhookCreate = webhookCreate)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as Webhook
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
     * Create Webhook
     * Creates a webhook.
     * @param webhookCreate
     * @return ApiResponse<Webhook?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun createWebhookWithHttpInfo(webhookCreate: WebhookCreate): ApiResponse<Webhook?> {
        val localVariableConfig = createWebhookRequestConfig(webhookCreate = webhookCreate)

        return request<WebhookCreate, Webhook>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation createWebhook
     *
     * @param webhookCreate
     * @return RequestConfig
     */
    fun createWebhookRequestConfig(webhookCreate: WebhookCreate): RequestConfig<WebhookCreate> {
        val localVariableBody = webhookCreate
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Content-Type"] = "application/json"
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/webhooks",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = true,
            body = localVariableBody
        )
    }

    /**
     * Delete Webhook
     * Deletes a webhook.
     * @param webhookGuid A GUID for a Bitly webhook
     * @return void
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun deleteWebhook(webhookGuid: kotlin.String) {
        val localVarResponse = deleteWebhookWithHttpInfo(webhookGuid = webhookGuid)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> Unit
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
     * Delete Webhook
     * Deletes a webhook.
     * @param webhookGuid A GUID for a Bitly webhook
     * @return ApiResponse<Unit?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Throws(IllegalStateException::class, IOException::class)
    fun deleteWebhookWithHttpInfo(webhookGuid: kotlin.String): ApiResponse<Unit?> {
        val localVariableConfig = deleteWebhookRequestConfig(webhookGuid = webhookGuid)

        return request<Unit, Unit>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation deleteWebhook
     *
     * @param webhookGuid A GUID for a Bitly webhook
     * @return RequestConfig
     */
    fun deleteWebhookRequestConfig(webhookGuid: kotlin.String): RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.DELETE,
            path = "/webhooks/{webhook_guid}".replace("{" + "webhook_guid" + "}", encodeURIComponent(webhookGuid.toString())),
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = true,
            body = localVariableBody
        )
    }

    /**
     * Retrieve Webhook
     * Returns a webhook.
     * @param webhookGuid A GUID for a Bitly webhook
     * @return Webhook
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun getWebhook(webhookGuid: kotlin.String): Webhook {
        val localVarResponse = getWebhookWithHttpInfo(webhookGuid = webhookGuid)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as Webhook
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
     * Retrieve Webhook
     * Returns a webhook.
     * @param webhookGuid A GUID for a Bitly webhook
     * @return ApiResponse<Webhook?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun getWebhookWithHttpInfo(webhookGuid: kotlin.String): ApiResponse<Webhook?> {
        val localVariableConfig = getWebhookRequestConfig(webhookGuid = webhookGuid)

        return request<Unit, Webhook>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation getWebhook
     *
     * @param webhookGuid A GUID for a Bitly webhook
     * @return RequestConfig
     */
    fun getWebhookRequestConfig(webhookGuid: kotlin.String): RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/webhooks/{webhook_guid}".replace("{" + "webhook_guid" + "}", encodeURIComponent(webhookGuid.toString())),
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = true,
            body = localVariableBody
        )
    }

    /**
     * Get Webhooks
     * Fetch all webhooks available for an Organization
     * @param organizationGuid A GUID for a Bitly organization
     * @return Webhooks
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun getWebhooks(organizationGuid: kotlin.String): Webhooks {
        val localVarResponse = getWebhooksWithHttpInfo(organizationGuid = organizationGuid)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as Webhooks
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
     * Get Webhooks
     * Fetch all webhooks available for an Organization
     * @param organizationGuid A GUID for a Bitly organization
     * @return ApiResponse<Webhooks?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun getWebhooksWithHttpInfo(organizationGuid: kotlin.String): ApiResponse<Webhooks?> {
        val localVariableConfig = getWebhooksRequestConfig(organizationGuid = organizationGuid)

        return request<Unit, Webhooks>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation getWebhooks
     *
     * @param organizationGuid A GUID for a Bitly organization
     * @return RequestConfig
     */
    fun getWebhooksRequestConfig(organizationGuid: kotlin.String): RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/organizations/{organization_guid}/webhooks".replace("{" + "organization_guid" + "}", encodeURIComponent(organizationGuid.toString())),
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = true,
            body = localVariableBody
        )
    }

    /**
     * Update Webhook
     * Update a webhook
     * @param webhookGuid A GUID for a Bitly webhook
     * @param webhookUpdate
     * @return Webhook
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun updateWebhook(webhookGuid: kotlin.String, webhookUpdate: WebhookUpdate): Webhook {
        val localVarResponse = updateWebhookWithHttpInfo(webhookGuid = webhookGuid, webhookUpdate = webhookUpdate)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as Webhook
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
     * Update Webhook
     * Update a webhook
     * @param webhookGuid A GUID for a Bitly webhook
     * @param webhookUpdate
     * @return ApiResponse<Webhook?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun updateWebhookWithHttpInfo(webhookGuid: kotlin.String, webhookUpdate: WebhookUpdate): ApiResponse<Webhook?> {
        val localVariableConfig = updateWebhookRequestConfig(webhookGuid = webhookGuid, webhookUpdate = webhookUpdate)

        return request<WebhookUpdate, Webhook>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation updateWebhook
     *
     * @param webhookGuid A GUID for a Bitly webhook
     * @param webhookUpdate
     * @return RequestConfig
     */
    fun updateWebhookRequestConfig(webhookGuid: kotlin.String, webhookUpdate: WebhookUpdate): RequestConfig<WebhookUpdate> {
        val localVariableBody = webhookUpdate
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Content-Type"] = "application/json"
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.PATCH,
            path = "/webhooks/{webhook_guid}".replace("{" + "webhook_guid" + "}", encodeURIComponent(webhookGuid.toString())),
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = true,
            body = localVariableBody
        )
    }

    /**
     * Verify Webhook
     * Sends ping event to test webhook configuration.
     * @param webhookGuid A GUID for a Bitly webhook
     * @return Webhook
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun verifyWebhook(webhookGuid: kotlin.String): Webhook {
        val localVarResponse = verifyWebhookWithHttpInfo(webhookGuid = webhookGuid)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as Webhook
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
     * Verify Webhook
     * Sends ping event to test webhook configuration.
     * @param webhookGuid A GUID for a Bitly webhook
     * @return ApiResponse<Webhook?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun verifyWebhookWithHttpInfo(webhookGuid: kotlin.String): ApiResponse<Webhook?> {
        val localVariableConfig = verifyWebhookRequestConfig(webhookGuid = webhookGuid)

        return request<Unit, Webhook>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation verifyWebhook
     *
     * @param webhookGuid A GUID for a Bitly webhook
     * @return RequestConfig
     */
    fun verifyWebhookRequestConfig(webhookGuid: kotlin.String): RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/webhooks/{webhook_guid}/verify".replace("{" + "webhook_guid" + "}", encodeURIComponent(webhookGuid.toString())),
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = true,
            body = localVariableBody
        )
    }

    private fun encodeURIComponent(uriComponent: kotlin.String): kotlin.String =
        HttpUrl.Builder().scheme("http").host("localhost").addPathSegment(uriComponent).build().encodedPathSegments[0]
}
