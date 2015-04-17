package in.petalappstudio.savetheinternet;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.apache.http.protocol.HTTP;

import java.net.URLDecoder;
import java.util.List;
import java.util.Random;

/**
 * Created by vivek on 14/4/15.
 */
public class HomeTab extends Fragment {
    RelativeLayout respondButton, visitWebsite1, visitWebsite2;
    Random r;
    int i, isFetched;
    String contentText;
    ProgressDialog mProgressDialog;
    PackageManager packageManager;
    String[] bcc_list;
    WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.home_tab,container,false);
        respondButton=(RelativeLayout)v.findViewById(R.id.respondButton);
        visitWebsite1=(RelativeLayout)v.findViewById(R.id.visitWebsite1);
        visitWebsite2=(RelativeLayout)v.findViewById(R.id.visitWebsite2);
        webView=(WebView)v.findViewById(R.id.wv);
        packageManager=getActivity().getPackageManager();
        r=new Random();
        bcc_list=new String[]{"netneutrality58@gmail.com", "netneutrality59@gmail.com", "netneutrality60@gmail.com", "netneutrality61@gmail.com", "netneutrality56@gmail.com", "netneutrality55@gmail.com", "netneutrality57@gmail.com", "netneutrality41@gmail.com", "netneutrality29@gmail.com","netneutrality34@gmail.com"};
        respondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isNetworkAvailable()) {
                    webView.getSettings().setJavaScriptEnabled(true);
                    webView.getSettings().setLoadsImagesAutomatically(false);
                    webView.getSettings().setBlockNetworkLoads(false);
                    webView.setWebChromeClient(new MyJsFunctionEvoke());
                    mProgressDialog = new ProgressDialog(getActivity());
                    mProgressDialog.setMessage("Loading...");
                    mProgressDialog.setIndeterminate(false);
                    webView.setWebViewClient(new ModifyWebView.AppWeb(mProgressDialog));
                    webView.loadUrl("http://www.savetheinternet.in/");


                }else {
                Toast.makeText(getActivity().getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
            }
            }
        });
          visitWebsite1.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  goToUrl("http://www.savetheinternet.in/");
              }
          });
           visitWebsite2.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   goToUrl("http://www.netneutrality.in/");
               }
           });
        return v;

    }
    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }

    private class MyJsFunctionEvoke extends WebChromeClient{
        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result){
            result.confirm();
            try {
                contentText = URLDecoder.decode(message, "UTF-8");
            }catch (Exception e){
                e.printStackTrace();
            }
            email();
            return true;
        }
    }
    public void email(){
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        i = r.nextInt(10 - 0) - 0;
        String bcc = bcc_list[i];
        emailIntent.setType(HTTP.PLAIN_TEXT_TYPE);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"advqos@trai.gov.in"});
        emailIntent.putExtra(Intent.EXTRA_BCC, new String[]{bcc});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "About the proposal about Breaking net neutrality");
        emailIntent.putExtra(Intent.EXTRA_TEXT, contentText);
        List activities = packageManager.queryIntentActivities(emailIntent,
                PackageManager.MATCH_DEFAULT_ONLY);
        boolean isIntentSafe = activities.size() > 0;
        if (isIntentSafe) {
            startActivity(emailIntent);
        } else {
            Toast.makeText(getActivity().getApplicationContext(), "Email client Required: You don't have a EMail client installed", Toast.LENGTH_SHORT).show();
        }
    }
}
