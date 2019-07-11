package com.josephcobbinah.alcphaseonechallenge

import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_b.*
import android.support.v4.view.ViewCompat.setLayerType
import android.os.Build
import android.util.Log
import android.view.View
import android.webkit.*


class ActivityB : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true)
        }
        webView.webChromeClient = WebChromeClient()

        webView.settings.allowUniversalAccessFromFileURLs = true
        webView.settings.javaScriptEnabled = true
        webView.settings.cacheMode = WebSettings.LOAD_NO_CACHE
        webView.settings.setAppCacheEnabled(false)
        webView.settings.domStorageEnabled = true

        webView.webViewClient = object:WebViewClient(){
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
            }

            override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
                Log.d("WebView Error:WebResErr", error.toString())
                super.onReceivedError(view, request, error)
            }

            override fun onReceivedHttpError(
                view: WebView?,
                request: WebResourceRequest?,
                errorResponse: WebResourceResponse?
            ) {
                Log.d("WebView Error: HTTP", errorResponse.toString())
                super.onReceivedHttpError(view, request, errorResponse)
            }

            override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
                Log.d("WebView Error: SslError", error.toString())
//                super.onReceivedSslError(view, handler, error)
                handler?.proceed()
            }
        }

        webView.loadUrl("https://www.andela.com/alc")

    }


}
