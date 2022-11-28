package com.uri.tcc.feature.remote.dto.tcc

import com.google.gson.annotations.SerializedName
import com.uri.tcc.feature.model.tcc.TccDocument
import com.uri.tcc.feature.model.tcc.TccFile
import com.uri.tcc.feature.model.tcc.TccUri
import com.uri.tcc.feature.model.tcc.TccUrl

data class TccDocumentDto(
    @SerializedName(value = "description") val description: String?,
    @SerializedName(value = "file") val file: TccFileDto?,
    @SerializedName(value = "filename") val filename: String?,
    @SerializedName(value = "inputStream") val inputStream: Any?,
    @SerializedName(value = "open") val open: Boolean?,
    @SerializedName(value = "readable") val readable: Boolean?,
    @SerializedName(value = "uri") val uri: TccUriDto?,
    @SerializedName(value = "url") val url: TccUrlDto?
) {

    data class TccFileDto(
        @SerializedName(value = "absolute") val absolute: Boolean?,
        @SerializedName(value = "absoluteFile") val absoluteFile: String?,
        @SerializedName(value = "absolutePath") val absolutePath: String?,
        @SerializedName(value = "canonicalFile") val canonicalFile: String?,
        @SerializedName(value = "canonicalPath") val canonicalPath: String?,
        @SerializedName(value = "directory") val directory: Boolean?,
        @SerializedName(value = "executable") val executable: Boolean?,
        @SerializedName(value = "file") val file: Boolean?,
        @SerializedName(value = "freeSpace") val freeSpace: Float?,
        @SerializedName(value = "hidden") val hidden: Boolean?,
        @SerializedName(value = "lastModified") val lastModified: Float?,
        @SerializedName(value = "name") val name: String?,
        @SerializedName(value = "parent") val parent: String?,
        @SerializedName(value = "parentFile") val parentFile: String?,
        @SerializedName(value = "path") val path: String?,
        @SerializedName(value = "readable") val readable: Boolean?,
        @SerializedName(value = "totalSpace") val totalSpace: Float?,
        @SerializedName(value = "usableSpace") val usableSpace: Float?,
        @SerializedName(value = "writable") val writable: Boolean?
    ) {
        val response: TccFile
            get() = TccFile(
                name = name ?: "",
                parent = parent ?: "",
                parentFile = parentFile ?: "",
                path = path ?: "",
                absoluteFile = absoluteFile ?: "",
                absolutePath = absolutePath ?: "",
                canonicalFile = canonicalFile ?: "",
                canonicalPath = canonicalPath ?: "",
                absolute = absolute ?: false,
                directory = directory ?: false,
                executable = executable ?: false,
                hidden = hidden ?: false,
                file = file ?: false,
                readable = readable ?: false,
                writable = writable ?: false,
                freeSpace = freeSpace ?: 0F,
                lastModified = lastModified ?: 0F,
                totalSpace = totalSpace ?: 0F,
                usableSpace = usableSpace ?: 0F
            )
    }

    data class TccUriDto(
        @SerializedName(value = "absolute") val absolute: Boolean?,
        @SerializedName(value = "authority") val authority: String?,
        @SerializedName(value = "fragment") val fragment: String?,
        @SerializedName(value = "host") val host: String?,
        @SerializedName(value = "opaque") val opaque: Boolean?,
        @SerializedName(value = "path") val path: String?,
        @SerializedName(value = "port") val port: Float?,
        @SerializedName(value = "query") val query: String?,
        @SerializedName(value = "rawAuthority") val rawAuthority: String?,
        @SerializedName(value = "rawFragment") val rawFragment: String?,
        @SerializedName(value = "rawPath") val rawPath: String?,
        @SerializedName(value = "rawQuery") val rawQuery: String?,
        @SerializedName(value = "rawSchemeSpecificPart") val rawSchemeSpecificPart: String?,
        @SerializedName(value = "rawUserInfo") val rawUserInfo: String?,
        @SerializedName(value = "scheme") val scheme: String?,
        @SerializedName(value = "schemeSpecificPart") val schemeSpecificPart: String?,
        @SerializedName(value = "userInfo") val userInfo: String?
    ) {
        val response: TccUri
            get() = TccUri(
                port = port ?: 0F,
                absolute = absolute ?: false,
                opaque = opaque ?: false,
                authority = authority ?: "",
                fragment = fragment ?: "",
                host = host ?: "",
                path = path ?: "",
                query = query ?: "",
                rawAuthority = rawAuthority ?: "",
                rawFragment = rawFragment ?: "",
                rawPath = rawPath ?: "",
                rawQuery = rawQuery ?: "",
                rawSchemeSpecificPart = rawSchemeSpecificPart ?: "",
                rawUserInfo = rawUserInfo ?: "",
                scheme = scheme ?: "",
                schemeSpecificPart = schemeSpecificPart ?: "",
                userInfo = userInfo ?: ""
            )
    }

    data class TccUrlDto(
        @SerializedName(value = "authority") val authority: String?,
        @SerializedName(value = "content") val content: Any?,
        @SerializedName(value = "defaultPort") val defaultPort: Float?,
        @SerializedName(value = "file") val file: String?,
        @SerializedName(value = "host") val host: String?,
        @SerializedName(value = "path") val path: String?,
        @SerializedName(value = "port") val port: Float?,
        @SerializedName(value = "protocol") val protocol: String?,
        @SerializedName(value = "query") val query: String?,
        @SerializedName(value = "ref") val ref: String?,
        @SerializedName(value = "userInfo") val userInfo: String?
    ) {
        val response: TccUrl
            get() = TccUrl(
                defaultPort = defaultPort ?: 0F,
                port = port ?: 0F,
                authority = authority ?: "",
                file = file ?: "",
                host = host ?: "",
                path = path ?: "",
                protocol = protocol ?: "",
                query = query ?: "",
                ref = ref ?: "",
                userInfo = userInfo ?: "",
                content = content
            )
    }

    val response: TccDocument
        get() = TccDocument(
            open = open ?: false,
            readable = readable ?: false,
            description = description ?: "",
            filename = description ?: "",
            file = file?.response,
            uri = uri?.response,
            url = url?.response,
            inputStream = inputStream
        )
}