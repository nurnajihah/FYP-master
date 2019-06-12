package sg.edu.rp.c346.smacbizservice;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

public class MainAdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);

        //Set title
        getSupportActionBar().setTitle("Admin");

        BottomNavigationView bottomnav = findViewById(R.id.bottom_nav1);

        bottomnav.setOnNavigationItemSelectedListener(navListener);

        //default page open
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new TaskFrag()).commit();

    }

    //side menu signout
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.signout,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menuLogout:

                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(this, MainActivityLogin.class));
                break;
        }
        return true;
    }

    //For bottom navigation view
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFrag = null;

                    switch (item.getItemId()) {
                        case R.id.nav_task:
                            selectedFrag = new TaskFrag();
                            break;
                        case R.id.nav_alert:
                            selectedFrag = new AlertFrag();
                            break;
                        case R.id.nav_history:
                            selectedFrag = new HistoryFrag();
                            break;
                        case R.id.nav_profile:
                            selectedFrag = new ProfileFrag();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFrag).commit();
                    return true;
                }
            };

}
