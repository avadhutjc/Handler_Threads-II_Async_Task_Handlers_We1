package com.masai.a109handler_threads_async_task_handlers_we1;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

public class WorkerThread extends HandlerThread {

    private final Handler mainThreadHandler;

    public WorkerThread(String name, Handler mainThreadHandler) {
        super(name);
        this.mainThreadHandler = mainThreadHandler;
    }

    @Override
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        int progress = 0;
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(2000);
                progress = progress + 10;
                Message message = Message.obtain();
                message.obj = progress;
                mainThreadHandler.sendMessage(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}