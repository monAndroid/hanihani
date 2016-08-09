package utils;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.moonhani.hanihani.AppController;
//import utils.AppController;
//import utils.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class Util extends Application {

    public String res;

    //interfaces
    public interface VMCallback_JSONObj {
        void onSuccess(JSONObject result);
    }

    public interface VMCallback_JSONArr {
        void onSuccess(JSONArray result);
    }





    private void getJsonObject(String url) {
        String tag_json_obj = "json_obj_req";
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, new JSONObject(),
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(AppController.TAG, response.toString());
                        //pDialog.hide();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(AppController.TAG, "Error: " + error.getMessage());
                // hide the progress dialog
                //pDialog.hide();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
    }

    private void getJsonArray(String url) {
        // Tag used to cancel the request
        String tag_json_arry = "json_array_req";

        //String url = "http://api.androidhive.info/volley/person_array.json";

        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(AppController.TAG, response.toString());
                        //pDialog.hide();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(AppController.TAG, "Error: " + error.getMessage());
                //pDialog.hide();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(req, tag_json_arry);
    }


    private void getStringReq(String url) {
        // Tag used to cancel the request
        String  tag_string_req = "string_req";
        //ProgressDialog pDialog = new ProgressDialog(this);
        //pDialog.setMessage("Loading...");
        //pDialog.show();

        StringRequest strReq = new StringRequest(Request.Method.GET,
                url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                //Log.d(AppController.TAG, response.toString());
                Log.d(AppController.TAG, response);
                //pDialog.hide();

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(AppController.TAG, "Error: " + error.getMessage());
                //pDialog.hide();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }


    public static void getPostReq(String url, Map<String, String> params) {

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(params),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            VolleyLog.v("Response:%n %s", response.toString());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
            }
        });

        // add the request object to the queue to be executed
        AppController.getInstance().addToRequestQueue(req);

    }


    private void getHeaderReq(String url) {
        // Tag used to cancel the request
        String tag_json_obj = "json_obj_req";

        //ProgressDialog pDialog = new ProgressDialog(this);
        //pDialog.setMessage("Loading...");
        //pDialog.show();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, new JSONObject(),
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(AppController.TAG, response.toString());
                        //pDialog.hide();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(AppController.TAG, "Error: " + error.getMessage());
                //pDialog.hide();
            }
        }) {

            /**
             * Passing some request headers
             **/
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                headers.put("apiKey", "xxxxxxxxxxxxxxx");
                return headers;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
    }


    private void getImageReq(String url, ImageView imageView) {
        ImageLoader imageLoader = AppController.getInstance().getImageLoader();
        final ImageView imgView = imageView;

        imageLoader.get(url, new ImageLoader.ImageListener() {

            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {

                imgView.setImageBitmap(response.getBitmap());
            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }

    private void getNetImageReq(String url, NetworkImageView networkImageView) {
        // Loading image with placeholder and error image
        ImageLoader imageLoader = AppController.getInstance().getImageLoader();  ////

        networkImageView.setImageUrl(url, imageLoader);
    }


    private void handleCache(String url) {
        Cache cache = AppController.getInstance().getRequestQueue().getCache();
        Cache.Entry entry = cache.get(url);
        if(entry != null){
            try {
                String data = new String(entry.data, "UTF-8");
                // handle data, like converting it to xml, json, bitmap etc.,
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            // Cached response doesn't exists. Make network call here
        }
    }

    public static void VMGetJsonObj(final String url, final Context context, final VMCallback_JSONObj callback)  {

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            VolleyLog.v("Response:%n %s", response.toString());
                            callback.onSuccess(response); // call call back function here
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
            }
        });

        // add the request object to the queue to be executed
        AppController.getInstance().addToRequestQueue(req);

    }


    public static void VMGetJsonArr(final String url, final Context context, final VMCallback_JSONArr callback)  {

        JsonArrayRequest req = new JsonArrayRequest(Request.Method.GET, url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(AppController.TAG, response.toString());
                        try {
                            VolleyLog.v("Response:%n %s", response.toString());
                            callback.onSuccess(response); // call call back function here
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(AppController.TAG, "Error: " + error.getMessage());
                //pDialog.hide();
            }
        });

        // add the request object to the queue to be executed
        AppController.getInstance().addToRequestQueue(req);

    }


    public static void VMPostJsonObj(final String url, JSONObject params, final Context context, final VMCallback_JSONObj callback)  {

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, url, params,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            VolleyLog.v("Response:%n %s", response.toString());
                            callback.onSuccess(response); // call call back function here
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
            }
        });

        // add the request object to the queue to be executed
        AppController.getInstance().addToRequestQueue(req);

    }


    public static void VMPostJsonArr(final String url, JSONObject params, final Context context, final VMCallback_JSONArr callback)  {

        JsonArrayRequest req = new JsonArrayRequest(Request.Method.POST, url, params,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(AppController.TAG, response.toString());
                        try {
                            VolleyLog.v("Response:%n %s", response.toString());
                            callback.onSuccess(response); // call call back function here
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(AppController.TAG, "Error: " + error.getMessage());
                //pDialog.hide();
            }
        });

        // add the request object to the queue to be executed
        AppController.getInstance().addToRequestQueue(req);

    }


    public static void VMNetImageReq(String url, NetworkImageView networkImageView) {
        // Loading image with placeholder and error image
        ImageLoader imageLoader = AppController.getInstance().getImageLoader();  ////

        networkImageView.setImageUrl(url, imageLoader);
    }

}
