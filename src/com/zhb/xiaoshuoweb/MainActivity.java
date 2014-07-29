package com.zhb.xiaoshuoweb;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
    public static final String url = "http://M.xs1234.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 去掉窗口标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        WebView webView = (WebView) this.findViewById(R.id.webView1);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl(url);
        // 如果页面中链接，如果希望点击链接继续在当前browser中响应，
        // 而不是新开Android的系统browser中响应该链接，必须覆盖webview的WebViewClient对象
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) { // 重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
                view.loadUrl(url);
                return true;
            }
        });
    }
    
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("提示");
        builder.setMessage("是否要退出应用？");
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.this.finish();
            }
        });
        builder.setNegativeButton(android.R.string.cancel, null);
        builder.show();
    }
    
//    /**
//     * 按键响应，在WebView中查看网页时，按返回键的时候按浏览历史退回,如果不做此项处理则整个WebView返回退出
//     */
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event)
//    {
//        // Check if the key event was the Back button and if there's history
//        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack())
//        {
//            // 返回键退回
//            myWebView.goBack();
//            return true;
//        }
//        // If it wasn't the Back key or there's no web page history, bubble up
//        // to the default
//        // system behavior (probably exit the activity)
//        return super.onKeyDown(keyCode, event);
//    }
    
}
