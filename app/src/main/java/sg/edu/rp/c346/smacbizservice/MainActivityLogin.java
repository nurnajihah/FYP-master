package sg.edu.rp.c346.smacbizservice;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Header;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivityLogin extends AppCompatActivity {

    private EditText Username, Password;
    private Button Login;
    public static TextView test;

    private FirebaseAuth mAuth;

    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        mAuth = FirebaseAuth.getInstance();

        //Set title
        getSupportActionBar().setTitle("Login");

        Username = findViewById(R.id.editTextEmail);
        Password = findViewById(R.id.editTextPassword);
        Login = findViewById(R.id.btnLogin);
        test = findViewById(R.id.textViewTEST);

        final String role = "";

        //AsyncHttpClient client = new AsyncHttpClient();
        //client.get("https:/10.0.2.2/smacbiz/StaffLogin.php?username=&password=", new JsonHttpResponseHandler() {

        //    @Override
        //    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                // Called when response HTTP status is "200 OK"

        //        try {

        //            for (int i = 0; i < response.length(); i++) {
        //                JSONObject category = (JSONObject) response.get(i);
                        //Category c = new Category(category.getInt("category_id"), category.getString("name"));
                        //alCategories.add(c);
        //            }
        //        } catch (JSONException e) {

        //        }
        //    }
        //});
        //Toast.makeText(MainActivityLogin.this, "Not an admin", Toast.LENGTH_LONG).show();
        startActivity(new Intent(MainActivityLogin.this, MainAdminActivity.class));



    }


}

