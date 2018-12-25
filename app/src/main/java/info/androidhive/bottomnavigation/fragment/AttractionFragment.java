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


public class AttractionFragment extends Fragment {

    InternetChecker internetChecker=InternetChecker.INSTANCE;
    public WebView mWebView;
    public final static String URL="http://www.tawangadventuregroup.com/tours/";
    public AttractionFragment() {
        // Required empty public constructor
    }
    public static AttractionFragment newInstance(String param1, String param2) {
        AttractionFragment fragment = new AttractionFragment();
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
            View view=inflater.inflate(R.layout.fragment_attraction, container, false);
            mWebView = (WebView) view.findViewById(R.id.webViewAttraction);
            mWebView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(final WebView view, final String url) {
                    return false;
                }
                @Override
                public void onPageStarted(final WebView view, final String url, final Bitmap favicon) {
                    //pb_per.setVisibility(View.VISIBLE);
                    super.onPageStarted(view, url, favicon);
                    mWebView.loadUrl("javascript:(function(){"+"var head = document.getElementsByClassName('fusion-header')[0].style.display='none'; "+" var head = document.getElementsByClassName('fusion-contact-info')[0].style.display='none';"+"var head = document.getElementsByClassName('fusion-main-menu')[0].style.display='none';"+"})()");
                }
                @Override
                public void onPageFinished(final WebView view, final String url) {
                    //pb_per.setVisibility(View.GONE);
                    super.onPageFinished(view, url);
                    mWebView.loadUrl("javascript:(function(){"+"var head = document.getElementsByClassName('fusion-header')[0].style.display='none'; "+" var head = document.getElementsByClassName('fusion-contact-info')[0].style.display='none';"+"var head = document.getElementsByClassName('fusion-main-menu')[0].style.display='none';"+"})()"); // Enable Javascript
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
