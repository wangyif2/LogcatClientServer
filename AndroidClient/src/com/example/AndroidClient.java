package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AndroidClient extends Activity {
    TextView textIn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button buttonSend = (Button) findViewById(R.id.send);
        textIn = (TextView) findViewById(R.id.textin);
        buttonSend.setOnClickListener(buttonSendOnClickListener);
    }

    Button.OnClickListener buttonSendOnClickListener = new Button.OnClickListener() {
        @Override
        public void onClick(View arg0) {
            Thread gThread = new Thread(new GenerateLogThread());
            gThread.start();
            textIn.setText("Done");
        }
    };

    public class GenerateLogThread implements Runnable {
//        public void run() {
//            try {
//                StringBuilder log = AdbLog.generateLogcatLog();
//                Log.d("Client", log.toString());
//                postLog(log);
//            } catch (IOException e) {
//                throw new IllegalStateException(e);
//            }
//        }
        public void run() {
            try {
                String log = AdbLog.generateSysDumpLog();
                Log.d("Client", log);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }

    private String postLog(StringBuilder log) throws IOException {
        HttpClient client = new DefaultHttpClient();
//        HttpPost post = new HttpPost("http://192.168.2.35:443/SubmitLog");
        HttpPost post = new HttpPost("http://192.168.0.10:8080/SubmitLog");

        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        pairs.add(new BasicNameValuePair("device_id", "1234"));
        pairs.add(new BasicNameValuePair("log", log.toString()));

        post.setEntity(new UrlEncodedFormEntity(pairs));
        HttpResponse response = client.execute(post);
        String responseText = EntityUtils.toString(response.getEntity());
        Log.i("AndroidClient", "responseText=" + responseText);
        return responseText;
    }
}
