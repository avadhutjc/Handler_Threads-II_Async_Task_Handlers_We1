package com.masai.a109handler_threads_async_task_handlers_we1;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;

import com.google.android.material.progressindicator.CircularProgressIndicator;

public class MainActivity extends AppCompatActivity {

    private CircularProgressIndicator progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        WorkerThread workerThread = new WorkerThread("async",mainThreadHandler);
        workerThread.start();
        Toast.makeText(this,"Progress Bar Starting Successfully",Toast.LENGTH_LONG).show();

    }

    private void initViews() {
        progressBar = findViewById(R.id.progress);
    }

    private final Handler mainThreadHandler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            int progress = (int) msg.obj;
            progressBar.setProgress(progress);
        }
    };
}
