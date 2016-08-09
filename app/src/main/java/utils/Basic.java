package utils;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by monwa on 2016-08-02.
 */
public class Basic extends Application {
    ////general show Toast
    public static void showToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }


    ////general show Toast
    public static void showDialog(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }
}
