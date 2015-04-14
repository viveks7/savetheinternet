package in.petalappstudio.savetheinternet;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by vivek on 14/4/15.
 */
public class NeutralityTab extends Fragment {
    RelativeLayout visitWebsite1, visitWebsite2;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.neutrality_tab,container,false);
        visitWebsite1=(RelativeLayout)v.findViewById(R.id.visitWebsite1);
        visitWebsite2=(RelativeLayout)v.findViewById(R.id.visitWebsite2);
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
}
