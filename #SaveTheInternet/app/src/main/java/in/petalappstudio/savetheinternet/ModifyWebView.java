package in.petalappstudio.savetheinternet;

import android.app.ProgressDialog;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by vivek on 17/4/15.
 */
public class ModifyWebView {
    public static int sendEmail;
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
            sendEmail=0;
            view.loadUrl("javascript:alert(pickOne(bccAddresses))");// get bcc
            view.loadUrl("javascript:alert(getSubject())");// get Subject
            view.loadUrl("javascript:alert(generateResponse())"); //evoke generateResponse()
            progressDialog.dismiss();
        }

    }
}
