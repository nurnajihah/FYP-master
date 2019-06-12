package sg.edu.rp.c346.smacbizservice;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class TaskFrag extends Fragment {

    ArrayList<Task> alCategories = new ArrayList<Task>();
    ArrayAdapter<Task> aaCategories;

    public TaskFrag() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.task_frag,container,false);

        String[] menuitems = {"test1", "test2", "test3"};

        ListView listview = (ListView) view.findViewById(R.id.listview);

        //ArrayList<Task> alCategories = new ArrayList<Task>();

        ArrayAdapter<String> listViewAdapter  = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_expandable_list_item_1,
                menuitems
        );

        listview.setAdapter(listViewAdapter);


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

        return view;

    }
}
