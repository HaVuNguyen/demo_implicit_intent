package com.example.dell.demoimplicitintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Phương thức được gọi khi người dùng click vào Button "Go Google".
    public void goGoogle(View view)  {
        String url="http://google.com";

        // Một Intent không tường minh, yêu cầu mở một URL.
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        this.startActivity(intent);
    }

    // Phương thức này được gọi khi người dùng click vào Button "Send Email".
    public void sendEmail(View view)  {

        // Danh sách người nhận
        String[] recipients=new String[]{"havunguyen1791996@gmail.com"};
        // Tiêu đề email.
        String subject="Hi, how are you!";
        // Nội dung email.
        String content ="This is my test email";

        Intent intentEmail = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
        intentEmail.putExtra(Intent.EXTRA_EMAIL, recipients);
        intentEmail.putExtra(Intent.EXTRA_SUBJECT, subject);
        intentEmail.putExtra(Intent.EXTRA_TEXT, content);

        intentEmail.setType("text/plain");

        startActivity(Intent.createChooser(intentEmail, "Choose an email client from..."));
    }



}