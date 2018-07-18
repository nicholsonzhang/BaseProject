package com.user.base.modules.mine;

import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.user.base.AppBaseActivity;
import com.user.base.R;
import com.user.base.utils.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class TestWebViewActivity extends AppBaseActivity {
    @BindView(R.id.web_view)
    WebView webView;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_web_view;
    }

    @Override
    protected void initViews() {

        final WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/android_js.html");
        webView.addJavascriptInterface(new AndroidJSObject(this), "android");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
               Uri uri =  Uri.parse(url);
               if (uri.getScheme().equals("js")){
                   if (uri.getAuthority().equals("hello2")){
                       ToastUtils.show(TestWebViewActivity.this,"JS调用Android发方法(协议拦截)");
                   }

               }else {
                   view.loadUrl(url);
               }

                return true;
            }

        });

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                ToastUtils.show(TestWebViewActivity.this, message);
                //返回true是网页的alert不会弹出
                return true;
            }

            @Override
            public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
                return super.onJsConfirm(view, url, message, result);
            }

            @Override
            public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
                return super.onJsPrompt(view, url, message, defaultValue, result);
            }
        });

    }

    @OnClick(R.id.btn_load_js)
    void loadJS() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            webView.evaluateJavascript("javascript:callJS()", new ValueCallback<String>() {
                @Override
                public void onReceiveValue(String value) {
                    ToastUtils.show(TestWebViewActivity.this, "value22=" + value);
                }
            });
        } else {
            webView.loadUrl("javascript:callJS()");
        }
    }
}
