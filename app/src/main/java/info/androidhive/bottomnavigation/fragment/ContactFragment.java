package info.androidhive.bottomnavigation.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import info.androidhive.bottomnavigation.R;
import info.androidhive.bottomnavigation.helper.InternetChecker;
import info.androidhive.bottomnavigation.helper.NoInternetActivity;


public class ContactFragment extends Fragment {

    InternetChecker internetChecker=InternetChecker.INSTANCE;
    public WebView mWebView;
    public final static String URL="https://himalayanmomos.com/contact-us";
    public ContactFragment() {
        // Required empty public constructor
    }
    public static ContactFragment newInstance(String param1, String param2) {
        ContactFragment fragment = new ContactFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    public void updateIntent() {
        Intent intent = new Intent(getActivity(), NoInternetActivity.class);
        startActivity(intent);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(!isNetworkAvailable()) {
            updateIntent();
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View view=inflater.inflate(R.layout.fragment_contact, container, false);
            mWebView = (WebView) view.findViewById(R.id.webViewContact);
            mWebView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(final WebView view, final String url) {
                    return false;
                }
                @Override
                public void onPageStarted(final WebView view, final String url, final Bitmap favicon) {
                    //pb_per.setVisibility(View.VISIBLE);
                    super.onPageStarted(view, url, favicon);
                    mWebView.loadUrl("javascript:(function(){"+"var head = document.getElementsByClassName('x-el x-el-nav c1-1 c1-2 c1-x c1-y c1-b c1-c c1-d c1-e x-d-ux')[0].style.display='none'; "+" var head = document.getElementsByClassName('x-el x-el-div c1-1 c1-2 c1-18 c1-19 c1-1a c1-1b c1-1c c1-1d c1-1e c1-1f c1-1g c1-b c1-c c1-1h c1-1i c1-1j c1-1k c1-1l c1-d c1-e x-d-ux')[0].style.display='none';"+"var head = document.getElementsByClassName('x-el x-el-nav c1-1 c1-2 c1-x c1-y c1-b c1-c c1-d c1-e x-d-ux')[0].style.display='none';"+"})()");
                    //mWebView.loadUrl("javascript:(function(){"+"var head = document.getElementsByClassName('fusion-header')[0].style.display='none'; "+" var head = document.getElementsByClassName('fusion-contact-info')[0].style.display='none';"+"var head = document.getElementsByClassName('fusion-main-menu')[0].style.display='none';"+"})()");
                }
                @Override
                public void onPageFinished(final WebView view, final String url) {
                    //pb_per.setVisibility(View.GONE);
                    super.onPageFinished(view, url);
                    mWebView.loadUrl("javascript:(function(){"+"var head = document.getElementsByClassName('x-el x-el-nav c1-1 c1-2 c1-x c1-y c1-b c1-c c1-d c1-e x-d-ux')[0].style.display='none'; "+" var head = document.getElementsByClassName('x-el x-el-div c1-1 c1-2 c1-18 c1-19 c1-1a c1-1b c1-1c c1-1d c1-1e c1-1f c1-1g c1-b c1-c c1-1h c1-1i c1-1j c1-1k c1-1l c1-d c1-e x-d-ux')[0].style.display='none';"+"var head = document.getElementsByClassName('x-el x-el-nav c1-1 c1-2 c1-x c1-y c1-b c1-c c1-d c1-e x-d-ux')[0].style.display='none';"+"})()");
                    //mWebView.loadUrl("javascript:(function(){"+"var head = document.getElementsByClassName('fusion-header')[0].style.display='none'; "+" var head = document.getElementsByClassName('fusion-contact-info')[0].style.display='none';"+"var head = document.getElementsByClassName('fusion-main-menu')[0].style.display='none';"+"})()"); // Enable Javascript
                }
            });
            mWebView.setInitialScale(1);
            mWebView.getSettings().setLoadWithOverviewMode(true);
            mWebView.getSettings().setUseWideViewPort(true);
            mWebView.loadUrl(URL);
            WebSettings webSettings = mWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            return view;
    }
}
