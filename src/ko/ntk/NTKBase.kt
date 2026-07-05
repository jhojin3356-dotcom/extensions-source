package eu.kanade.tachiyomi.extension.ko.ntk

import eu.kanade.tachiyomi.network.GET
import eu.kanade.tachiyomi.network.NetworkHelper
import okhttp3.OkHttpClient
import okhttp3.Request
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import uy.kohesive.injekt.injectLazy

open class NTKBase {

    protected val network: NetworkHelper by injectLazy()
    protected val client: OkHttpClient
        get() = network.client

    protected val baseUrl = "https://newtoki1.org"

    protected fun request(path: String): Request {
        return GET(baseUrl + path)
    }

    protected fun getDocument(path: String): Document {
        val response = client.newCall(request(path)).execute()
        return Jsoup.parse(response.body.string())
    }
}
