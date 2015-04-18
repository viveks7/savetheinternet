package in.petalappstudio.savetheinternet;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.List;

/**
 * Created by vivek on 18/4/15.
 */
public class SupportTab extends Fragment {
    RelativeLayout contactMp, askSupport, infoStartup, learnMore;
    PackageManager packageManager;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.support_tab,container,false);
        contactMp=(RelativeLayout)v.findViewById(R.id.contact_mp);
        askSupport=(RelativeLayout)v.findViewById(R.id.ask_people);
        infoStartup=(RelativeLayout)v.findViewById(R.id.know_startup);
        learnMore=(RelativeLayout)v.findViewById(R.id.learn_more);
        packageManager=getActivity().getPackageManager();

        contactMp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertMp();
            }
        });
        askSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertSupport();
            }
        });
        infoStartup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertStartup();
            }
        });
        learnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("http://www.netneutrality.in/support/");
            }
        });
        return v;
    }
    private void showAlertMp(){
        new AlertDialog.Builder(getActivity())
            .setTitle(R.string.contact_mp)
            .setMessage(R.string.mp_message)
            .setPositiveButton("Contact your MP", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int which) {
                    goToUrl("http://j.mp/MailMyMP");
                }
            })
        .show();
    }
    private void showAlertStartup(){
        new AlertDialog.Builder(getActivity())
                .setTitle("Are you a Startup? Know a Startup?")
                .setMessage("If you or someone you know runs an internet company or startup, please fill this from. We will be in touch regarding a planned open letter and protest.")
                .setPositiveButton("Fill out the Form", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialogInterface, int which) {
                        goToUrl("https://docs.google.com/forms/d/1lusp9OESUmEdnvaG2r5iU3-wysdIssGeIzE5OHrGb64/viewform");
                    }
                }).show();
    }
    private void showAlertSupport(){
        new AlertDialog.Builder(getActivity())
            .setTitle("Ask for Support")
            .setMessage("Send out a tweet to popular people, asking them to support Net Neutrality. Here's a list of prominent people")
                .setNegativeButton("Influencers", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int which) {
                        goToUrl("https://docs.google.com/spreadsheets/d/1DgHqDqJxVvVlMWE9bstcUvnOkX7jqN4s5pzqyhhtgZ0/edit#gid=2031323282");
                    }
                })
                .setPositiveButton("Indian Politicians", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int which) {
                        goToUrl("https://docs.google.com/spreadsheets/d/1hFECFTMB5sqQVrAqSgdQQ4N9rFxY6-TwzkimhSTOKIw/edit#gid=1511726143");
                    }
                }).show();
    }
    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
