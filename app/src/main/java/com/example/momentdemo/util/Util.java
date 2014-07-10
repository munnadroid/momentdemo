package com.example.momentdemo.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by munnadroid on 7/10/14.
 */
public class Util {

    public static void showToast(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
}
