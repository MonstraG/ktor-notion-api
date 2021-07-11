package no.pls

import no.pls.adapters.LocalDateTypeAdapter
import com.google.gson.FieldNamingPolicy
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.features.*
import io.ktor.http.*
import no.pls.models.BaseRichText
import no.pls.models.Database
import no.pls.models.ListResponse
import java.io.FileInputStream
import java.time.LocalDateTime
import java.util.*

class NotionAPI {
    private val client: HttpClient

    init {
        val fis = FileInputStream("application.properties")
        val properties = Properties()
        properties.load(fis)
        val token = properties["notionApiToken"] as String

        client = HttpClient(CIO) {
            install(JsonFeature) {
                serializer = GsonSerializer {
                    setPrettyPrinting()
                    disableHtmlEscaping()
                    registerTypeAdapter(LocalDateTime::class.java, LocalDateTypeAdapter().nullSafe())
//                    registerTypeAdapter(BaseRichText::class.java, BaseRichTextAdapter().nullSafe())
                    setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                }
            }
            expectSuccess = false
            defaultRequest {
                if (url.host == "localhost") {
                    url.host = "api.notion.com"
                    url.protocol = URLProtocol.HTTPS
                    url.encodedPath = "/v1/" + url.encodedPath
                }
                header(HttpHeaders.Authorization, "Bearer $token")
                header("Notion-Version", "2021-05-13")
            }
        }
    }

    suspend fun get() {
        val response: ListResponse<Database> = client.get("/databases")
        println(response)
    }
}

