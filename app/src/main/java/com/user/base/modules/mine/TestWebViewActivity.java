package com.user.base.modules.mine;

import android.webkit.WebSettings;
import android.webkit.WebView;

import com.user.base.R;
import com.user.base.base.BaseActivity;

import butterknife.BindView;

public class TestWebViewActivity extends BaseActivity {
    @BindView(R.id.web_view)
    WebView webView;
    @Override
    protected int getContentViewId() {
        return R.layout.activity_web_view;
    }

    @Override
    protected void initViews() {

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("http://www.baidu.com");

    }
}
