package com.sobatambyar.foodcourtamikom3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText email, password;
    private Button btn_login;
    private TextView link_regist;
    private ProgressBar loading;
    private static String URL_LOGIN = "http://10.0.2.2/android/login.php";
    SessionManager sessionManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManager(this);

        loading = findViewById(R.id.loading);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btn_login = findViewById(R.id.btn_login);
        link_regist = findViewById(R.id.link_regist);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mEmail = email.getText().toString().trim();
                String mPass = password.getText().toString().trim();

                if (!mEmail.isEmpty() || !mPass.isEmpty()) {
                    Login(mEmail,mPass);
                } else {
                    email.setError("please insert email");
                    password.setError("please insert passwod");
                }

            }
        });
        link_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Register.class));
            }
        });
    }
    private void  Login(final String email, final String password){
        loading.setVisibility(View.VISIBLE);
        btn_login.setVisibility(View.GONE);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject= new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("login");
                            if (success.equals("1")){
                                for (int i = 0; i < jsonArray.length();i++){
                                    JSONObject object= jsonArray.getJSONObject(i);

                                    String name = object.getString("name").trim();
                                    String email = object.getString("email").trim();
                                    String id = object.getString("id").trim();

                                    sessionManager.createSession(name, email, id);

                                    Toast.makeText(MainActivity.this, "Success Login. \nYour Name : "
                                            +name+"\nYour Email"
                                            +email, Toast.LENGTH_SHORT).show();
                                    loading.setVisibility(View.GONE);

                                    startActivity(new Intent(MainActivity.this, Home.class));

                                }
                            }
                        } catch (JSONException e){
                            e.printStackTrace();
                            loading.setVisibility(View.GONE);
                            btn_login.setVisibility(View.VISIBLE);
                            Toast.makeText(MainActivity.this, "Error" +e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loading.setVisibility(View.GONE);
                        Toast.makeText(MainActivity.this, "Error" +error.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("email", email);
                params.put("password", password);

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}





//    private EditText email, password;
//    private Button btn_login;
//    private TextView link_regist;
//    private ProgressBar loading;
//<<<<<<< HEAD
//    private static String URL_LOGIN = "http://192.168.18.60/android/login.php";
//=======
//    private static String URL_LOGIN = "http://192.168.1.104/php/login.php";
//    SessionManager sessionManager;
//>>>>>>> master
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        sessionManager = new SessionManager(this);
//
//        loading = findViewById(R.id.loading);
//        email = findViewById(R.id.email);
//        password = findViewById(R.id.password);
//        btn_login = findViewById(R.id.btn_login);
//        link_regist = findViewById(R.id.link_regist);
//
//
//<<<<<<< HEAD
//        btn_login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String mEmail = email.getText().toString().trim();
//                String mPass = password.getText().toString().trim();
//
//                if (!mEmail.isEmpty() || !mPass.isEmpty()) {
//                    Login(mEmail,mPass);
//                } else {
//                    email.setError("please insert email");
//                    password.setError("please insert passwod");
//                }
//
//            }
//        });
//        link_regist.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, Register.class));
//            }
//        });
//    }
//    private void  Login(final String email, final String password){
//        loading.setVisibility(View.VISIBLE);
//        btn_login.setVisibility(View.GONE);
//
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//
//                        try {
//                            JSONObject jsonObject = new JSONObject(response);
//                            String success = jsonObject.getString("success");
//                            JSONArray jsonArray = jsonObject.getJSONArray("login");
//                            if (success.equals("1")){
//                                for (int i = 0; i < jsonArray.length(); i++){
//                                    JSONObject object= jsonArray.getJSONObject(i);
//
//                                    String name = object.getString("name").trim();
//                                    String email = object.getString("email").trim();
//                                    Toast.makeText(MainActivity.this, "Success Login. \nYour Name : "
//                                            +name+"\nYour Email"
//                                            +email, Toast.LENGTH_SHORT).show();
//                                    loading.setVisibility(View.GONE);
//                                }
//                            }
//                        } catch (JSONException e){
//                            e.printStackTrace();
//                            loading.setVisibility(View.GONE);
//                            btn_login.setVisibility(View.VISIBLE);
//                            Toast.makeText(MainActivity.this, "Error" +e.toString(), Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        loading.setVisibility(View.GONE);
//                        btn_login.setVisibility(View.VISIBLE);
//                        Toast.makeText(MainActivity.this, "Error" +error.toString(), Toast.LENGTH_SHORT).show();
//                    }
//                })
//        {
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> params = new HashMap<>();
//                params.put("email", email);
//                params.put("password", password);
//                return params;
//            }
//            //            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> params = new HashMap<>();
//                params.put("email", email);
//                params.put("password", password);
//
//                return params;
//=======
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//
//                        try {
//                            JSONObject jsonObject= new JSONObject(response);
//                            String success = jsonObject.getString("success");
//                            JSONArray jsonArray = jsonObject.getJSONArray("login");
//                            if (success.equals("1")){
//                                for (int i = 0; i < jsonArray.length();i++){
//                                    JSONObject object= jsonArray.getJSONObject(i);
//
//                                    String name = object.getString("name").trim();
//                                    String email = object.getString("email").trim();
//                                    String id = object.getString("id").trim();
//
//                                    sessionManager.createSession(name, email, id);
//
//                                    Toast.makeText(MainActivity.this, "Success Login. \nYour Name : "
//                                            +name+"\nYour Email"
//                                            +email, Toast.LENGTH_SHORT).show();
//                                    loading.setVisibility(View.GONE);
//                                }
//                            }
//                        } catch (JSONException e){
//                            e.printStackTrace();
//                            loading.setVisibility(View.GONE);
//                            btn_login.setVisibility(View.VISIBLE);
//                            Toast.makeText(MainActivity.this, "Error" +e.toString(), Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        loading.setVisibility(View.GONE);
//                        Toast.makeText(MainActivity.this, "Error" +error.toString(), Toast.LENGTH_SHORT).show();
//                    }
//                })
//        {
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> params = new HashMap<>();
//                params.put("email", email);
//                params.put("password", password);
//
//                return params;
//            }
//        };
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        requestQueue.add(stringRequest);
//>>>>>>> master

//        };
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        requestQueue.add(stringRequest);
//
//    }
//}


//    TextView textView;
//    Button btnsignin;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        textView=(TextView)findViewById(R.id.textregister);
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent1=new Intent(MainActivity.this,Register.class);
//                startActivity(intent1);
//            }
//
//        });
//
//        btnsignin=(Button)findViewById(R.id.btnlogin);
//        btnsignin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent3=new Intent( MainActivity.this,Home.class);
//                startActivity(intent3);
//
//            }
//        });
//
//
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayShowHomeEnabled(true);
//        actionBar.setIcon(R.drawable.ic_syifalogo);
//
//
//
//        btn_login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this,Home.class));
//            }
//        });
//    }
//}
