package in.petalappstudio.savetheinternet;

import android.app.ProgressDialog;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URLDecoder;

/**
 * Created by vivek on 17/4/15.
 */
public class ModifyWebView {
    public static class AppWeb extends WebViewClient {//sets progress Dialog
        private ProgressDialog progressDialog;
        public AppWeb(ProgressDialog progressDialog){
            this.progressDialog=progressDialog;
            progressDialog.show();
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            view.loadUrl(url);
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url){
            super.onPageFinished(view, url);
            view.loadUrl("javascript:alert(generateResponse())"); //evoke generateResponse()
            progressDialog.dismiss();
        }

    }
}
