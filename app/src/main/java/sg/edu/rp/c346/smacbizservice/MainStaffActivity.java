package sg.edu.rp.c346.smacbizservice;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainStaffActivity extends AppCompatActivity {

    private ListView lvListView;
    ArrayList<Task> alCategories = new ArrayList<Task>();
    ArrayAdapter<Task> aaCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_staff);

        lvListView = findViewById(R.id.listview);
        //Set title
        getSupportActionBar().setTitle("Staff");

        BottomNavigationView bottomnav = findViewById(R.id.bottom_nav1);

        //bottomnav.setOnNavigationItemSelectedListener(navListener);

        //default page open
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new TaskFrag()).commit();




        lvListView = (ListView) findViewById(R.id.listview);
        aaCategories = new ArrayAdapter<Task>(this, android.R.layout.simple_expandable_list_item_1, alCategories);
        lvListView.setAdapter(aaCategories);


        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://192.168.1.8:8080/smacbiz/getTask.php", new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                // Called when response HTTP status is "200 OK"

                try {

                    for (int i = 0; i < response.length(); i++) {
                        JSONObject task = (JSONObject) response.get(i);
                        int id = task.getInt("task_id");
                        String name = task.getString("name");
                        String type = task.getString("type");
                        String user_incharge = task.getString("user_incharge");
                        String percent_of_uic = task.getString("percent_of_uic");
                        String liaison_person = task.getString("liaison_person");
                        String percent_of_lp = task.getString("percent_of_lp");
                        String client = task.getString("client");
                        String price = task.getString("price");
                        String complete = task.getString("complete");
                        String billed = task.getString("billed");
                        String due_date = task.getString("due_date");
                        Task c = new Task(id, name, type, user_incharge, percent_of_uic, liaison_person, percent_of_lp, client, price, complete, billed,due_date);
                        alCategories.add(c);
                    }
                    aaCategories.notifyDataSetChanged();
                } catch (JSONException e) {

                }
                aaCategories.notifyDataSetChanged();
            }
        });

        lvListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = parent.getItemAtPosition(position).toString();
                //Toast.makeText(MainStaffActivity.this, name,
                //        Toast.LENGTH_LONG).show();

                // inflate the layout of the popup window
                LayoutInflater inflater = (LayoutInflater)
                        getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.popup_window, null);

                // create the popup window
                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable = true; // lets taps outside the popup also dismiss it
                final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                // show the popup window
                // which view you pass in doesn't matter, it is only used for the window tolken
                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
                ((TextView)popupWindow.getContentView().findViewById(R.id.textview)).setText(name);




                // dismiss the popup window when touched
                popupView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        return true;
                    }
                });

            }

        });


    }

}
