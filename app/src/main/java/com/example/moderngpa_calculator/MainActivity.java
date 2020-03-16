package com.example.moderngpa_calculator;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private FirebaseUser currentUser;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        drawer = findViewById(R.id.drawer);
        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);
        //checks if current user isn't null
        if(mAuth.getCurrentUser()!=null)
            UpdateNavHeader();
        else
        {
            //show welcome screen
            startActivity(new Intent(MainActivity.this,WelcomeScreen.class));
            finish();
        }


        //navigation drawer actions
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //shows home fragment if savedinstancestate is null
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.Home);
        }


    }

    //navigation items
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.Home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                        new HomeFragment()).commit();
                break;
            case R.id.feedback:
                showFeedbackDialog();
                break;
            case R.id.info:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                        new AboutAppFragment()).commit();
                break;
            case R.id.logout:
                //log out dialog
                DialogFragment dialogFragment = new LogoutDialogFragment();
                dialogFragment.setCancelable(false);
                dialogFragment.show(getSupportFragmentManager(), "Log out dialog");
                break;
            case R.id.nav_share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_send:
                Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    //update current user email
    public void UpdateNavHeader() {

            NavigationView navigationView = findViewById(R.id.navigationView);
            View headerView = navigationView.getHeaderView(0);
            TextView textViewEmail = headerView.findViewById(R.id.useremail);
            textViewEmail.setText(currentUser.getEmail());

    }

    //show feedback dialog
    public void showFeedbackDialog()
    {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Feedback Form");
        builder.setMessage("please provide us your valuable feedback");
        LayoutInflater inflater = LayoutInflater.from(this);

        View reg_layout = inflater.inflate(R.layout.fragment_feedback, null);
        final TextView tvEmail = reg_layout.findViewById(R.id.emailName);
        tvEmail.setText(currentUser.getEmail());

        final EditText Feedback = reg_layout.findViewById(R.id.Message);
        builder.setView(reg_layout);

        builder.setPositiveButton("SEND", (dialog, which) -> {
            if (TextUtils.isEmpty(Feedback.getText().toString())) {
                Toast.makeText(MainActivity.this, "Please write something", Toast.LENGTH_SHORT).show();
                return;
            }


            FirebaseDatabase database=FirebaseDatabase.getInstance();
            DatabaseReference myRef=database.getReference();

            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Object value=dataSnapshot.getValue();

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(MainActivity.this, "failed to read info", Toast.LENGTH_SHORT).show();
                }
            });
           myRef.child("Users").child(currentUser.getUid()).child("Email").setValue(tvEmail.getText().toString());
            myRef.child("Users").child(currentUser.getUid()).child("Feedback").setValue(Feedback.getText().toString());
            Toast.makeText(this, "Thanks for your feedback", Toast.LENGTH_SHORT).show();
        });
        builder.setNegativeButton("CANCEL", (dialog, which) -> dialog.dismiss());
        builder.setCancelable(false);
        builder.show();
    }



}
