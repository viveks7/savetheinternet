package in.petalappstudio.savetheinternet;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.apache.http.protocol.HTTP;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.TextNode;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;
import org.w3c.dom.Element;

import java.io.IOException;
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
        isFetched=0;


        r=new Random();
        bcc_list=new String[]{"netneutrality47@gmail.com", "netneutralityindia28@gmail.com", "netneutrality26@gmail.com", "netneutrality59@gmail.com", "netneutralityindia45@gmail.com", "netneutrality19@gmail.com", "netneutrality40@gmail.com", "netneutrality41@gmail.com", "netneutrality29@gmail.com","netneutrality34@gmail.com"};
        respondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isNetworkAvailable()) {
                    /*try {
                        new JsoupGet().execute();
                    }catch (Exception e){
                        e.printStackTrace();
                    }*/
                    webView.getSettings().setJavaScriptEnabled(true);//Enable JS
                    if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN) {
                        webView.getSettings().setAllowFileAccess(true);
                        webView.getSettings().setAllowFileAccessFromFileURLs(true);
                        webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
                    }

                    webView.setWebChromeClient(new MyJsFunctionEvoke());
                    mProgressDialog = new ProgressDialog(getActivity());
                    // Set progressdialog message
                    mProgressDialog.setMessage("Loading...");
                    mProgressDialog.setIndeterminate(false);
                    webView.setWebViewClient(new AppWeb(mProgressDialog));
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

    // Current code>>>>>>
    /*private class JsoupGet extends AsyncTask<Void, Void, Void> {
        String url="http://www.savetheinternet.in/";
        String text;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(getActivity());
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
                try {
                    // Connect to the Website URL
                    org.jsoup.nodes.Document doc = Jsoup.connect(url).get();

                    doc.outputSettings(new Document.OutputSettings().prettyPrint(false));
                    doc.select("p").prepend("\\n");
                    textElem = doc.select("div[id=responseContainer]");
                    String s = textElem.html().replaceAll("\\\\n", "\n");
                    s = s.replaceFirst("The Response", "");
                    text = Jsoup.clean(s, "", Whitelist.none(), new Document.OutputSettings().prettyPrint(false));
                    isFetched=1;

                    //webView.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
                //contentText = text;

                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                i = r.nextInt(10 - 0) - 0;
                String bcc = bcc_list[i];
// The intent does not have a URI, so declare the "text/plain" MIME type
                emailIntent.setType(HTTP.PLAIN_TEXT_TYPE);
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"advqos@trai.gov.in"});// recipients
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
            // Close the progressdialog
            mProgressDialog.dismiss();
        }
    }*/
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }

    private class MyJsFunctionEvoke extends WebChromeClient{
        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result){
            contentText=message;
           // Toast.makeText(getActivity().getApplicationContext(), contentText, Toast.LENGTH_SHORT).show();
            result.confirm();
            email();//email the content, code is messed up now, i know :)
            return true;
        }
    }

    private class AppWeb extends WebViewClient{//sets progress Dialog
        private ProgressDialog progressDialog;
        private AppWeb(ProgressDialog progressDialog){
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

            view.loadUrl("javescript:alert(generateResponse())"); //evoke generateResponse()

            progressDialog.dismiss();
        }

    }
    public void email(){
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        i = r.nextInt(10 - 0) - 0;
        String bcc = bcc_list[i];
// The intent does not have a URI, so declare the "text/plain" MIME type
        emailIntent.setType(HTTP.PLAIN_TEXT_TYPE);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"advqos@trai.gov.in"});// recipients
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
