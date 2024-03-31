package ru.mirea.kateninva.looper;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import ru.mirea.kateninva.looper.databinding.ActivityMainBinding;

public	class	MyLooper	extends	Thread{
    public	Handler	mHandler;
    private	Handler	mainHandler;
    public	MyLooper(Handler	mainThreadHandler)	{
        mainHandler	=mainThreadHandler;
    }
    public	void	run()	{
        Log.d("MyLooper",	"run");
        Looper.prepare();
        mHandler	=	new	Handler(Looper.myLooper())	{
            public	void	handleMessage(Message msg)	{
                String	data	=	msg.getData().getString("KEY");
                Log.d("MyLooper	get	message:	", data);

                int	count	=	data.length();
                Message	message	=	new	Message();
                Bundle bundle	=	new	Bundle();
                message.setData(bundle);
                //	Send	the	message	back	to	main	thread	message	queue	use	main	thread	message	Handler.
                mainHandler.postDelayed(() -> {mainHandler.sendMessage(message);}, 20);
                // mainHandler.sendMessage(message);
            }
        };
        Looper.loop();
    }
}