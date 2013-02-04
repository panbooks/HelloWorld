package com.android.panbook;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

public class MovieClient extends Activity {
	
	private OutputStream outputStream = null;
	private Socket socket = null;
	private InputMethodManager m = null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  
		Log.e("panbook", "start");
		setContentView(R.layout.main);

		try {
			socket = new Socket("222.20.101.168", 6000);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		Button button1 = (Button) findViewById(R.id.Button01);
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				m = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				m.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
			}
		});

	}
    
    
    public boolean onKeyDown(int keyCode, KeyEvent msg) {

    	Log.e("panbook", "press a key");
    	
        if (keyCode == KeyEvent.KEYCODE_1) {
        	sendchar('1');
            return true;
        }
        
        if (keyCode == KeyEvent.KEYCODE_2) {
        	sendchar('2');
            return true;
        }
        
        if (keyCode == KeyEvent.KEYCODE_3) {
        	sendchar('3');
            return true;
        }
        
        if (keyCode == KeyEvent.KEYCODE_4) {
        	sendchar('4');
            return true;
        }
        
        if (keyCode == KeyEvent.KEYCODE_5) {
        	sendchar('5');
            return true;
        }
        
        if (keyCode == KeyEvent.KEYCODE_6) {
        	sendchar('6');
            return true;
        }
        
        if (keyCode == KeyEvent.KEYCODE_7) {
        	sendchar('7');
            return true;
        }
        
        if (keyCode == KeyEvent.KEYCODE_8) {
        	sendchar('8');
            return true;
        }

        if (keyCode == KeyEvent.KEYCODE_9) {
        	sendchar('9');
            return true;
        }
        
        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
        	sendchar('5');
            return true;
        }
        
        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
        	sendchar('6');
            return true;
        }
        
        if (keyCode == KeyEvent.KEYCODE_STAR) {
            return true;
        }

        return super.onKeyDown(keyCode, msg);
    }
    
    public void sendchar(char c) {
    	
    	Log.e("panbook", "in sendchar()");
		try {
			//socket = new Socket("222.20.101.168", 6000);
			outputStream = socket.getOutputStream();
			outputStream.write(c);
			outputStream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}