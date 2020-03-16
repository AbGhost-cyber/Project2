package com.example.moderngpa_calculator;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

public class HomeFragment extends Fragment {
    public static final int ADD_COURSES_REQUEST = 1;
    public static final int EDIT_NOTE_REQUEST = 2;
    private TextView swipe;
    private SemesterViewModel semesterViewModel;
    EditText semesterName;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate (R.layout.fragment_home, container, false);

        swipe = v.findViewById (R.id.swipe);

        FloatingActionButton buttonAddSemester = v.findViewById (R.id.button_add_semester);

        buttonAddSemester.setOnClickListener (v12 -> {
            AlertDialog.Builder builder = new AlertDialog.Builder (Objects.requireNonNull (getContext ()));
            builder.setTitle ("Create new Semester");

            LinearLayout layout = new LinearLayout (getContext ());

            semesterName = new EditText (getContext ());
            semesterName.setMinEms (19);
            semesterName.setHint ("please input semester name");
            semesterName.setInputType (InputType.TYPE_CLASS_TEXT);
            semesterName.setTextColor (getResources ().getColor (R.color.black));
            layout.addView (semesterName);
            layout.setPadding (10, 10, 10, 10);
            builder.setView (layout);
            builder.setCancelable (false);
            builder.setPositiveButton ("Ok", (dialog, which) -> {
                String title = semesterName.getText ().toString ();
                if (title.trim ().isEmpty ()) {
                    ToastMesage ("please input semester name");
                }
                else{
                    Semester semester=new Semester (title,"","","",""
                            ,"","","","",0,0,0,0,0,
                            0,0,0,0,0,0,0,0,0,"","",
                            "","","","","",0);
                    semesterViewModel.insert (semester);
                }

            });
            builder.setNegativeButton ("Cancel", (dialog, which) -> dialog.dismiss ());
            builder.create ().show ();
        });

        RecyclerView recyclerView = v.findViewById (R.id.recycler_view);
        recyclerView.setLayoutManager (new LinearLayoutManager (HomeFragment.this.getActivity ()));
        recyclerView.setHasFixedSize (true);

        final SemesterAdapter adapter = new SemesterAdapter ();
        recyclerView.setAdapter (adapter);

        semesterViewModel = ViewModelProviders.of (Objects.requireNonNull (getActivity ())).get (SemesterViewModel.class);
        semesterViewModel.getAllSemesters ().observe (HomeFragment.this, semester1 -> {
            if (semester1.size () <= 0) {
                swipe.setVisibility (View.INVISIBLE);
            } else {
                swipe.setVisibility (View.VISIBLE);
            }
            adapter.setSemester (semester1);
        });


        new ItemTouchHelper (new ItemTouchHelper.SimpleCallback (0,
                ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                if (direction == ItemTouchHelper.LEFT) {
                    final int adapterPosition = viewHolder.getAdapterPosition ();
                    final Semester deletedSemester = adapter.getSemesterAt (adapterPosition);
                    semesterViewModel.delete (deletedSemester);
                    swipe.setVisibility (View.INVISIBLE);
                    Snackbar.make (recyclerView, "semester deleted", Snackbar.LENGTH_LONG)
                            .setActionTextColor (getResources ().getColor (R.color.white))
                            .setAction ("Undo", v1 -> {
                                semesterViewModel.insert (deletedSemester);
                                swipe.setVisibility (View.VISIBLE);

                            })
                            .show ();
                    return;
                }

                SemesterAdapter.SemesterHolder semesterHolder = (SemesterAdapter.SemesterHolder) viewHolder;

            }

            @Override
            public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                new RecyclerViewSwipeDecorator.Builder (c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                        .addBackgroundColor (ContextCompat.getColor (getActivity (), R.color.red))
                        .addActionIcon (R.drawable.ic_delete_black_24dp)
                        .create ()
                        .decorate ();
                super.onChildDraw (c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }
        }).attachToRecyclerView (recyclerView);


        adapter.setOnItemClickListener (semester -> {
            Intent intent = new Intent (HomeFragment.this.getActivity (), CreateEditCoursesActivity.class);

            intent.putExtra (CreateEditCoursesActivity.EXTRA_ID, semester.getId ());
            intent.putExtra (CreateEditCoursesActivity.EXTRA_TITLE, semester.getTitle ());

            intent.putExtra (CreateEditCoursesActivity.EXTRA_COURSENAME, semester.getCourseNAME ());
            intent.putExtra (CreateEditCoursesActivity.EXTRA_COURSENAME1, semester.getCourseNAME1 ());
            intent.putExtra (CreateEditCoursesActivity.EXTRA_COURSENAME2, semester.getCourseNAME2 ());
            intent.putExtra (CreateEditCoursesActivity.EXTRA_COURSENAME3, semester.getCourseNAME3 ());
            intent.putExtra (CreateEditCoursesActivity.EXTRA_COURSENAME4, semester.getCourseNAME4 ());
            intent.putExtra (CreateEditCoursesActivity.EXTRA_COURSENAME5, semester.getCourseNAME5 ());
            intent.putExtra (CreateEditCoursesActivity.EXTRA_COURSENAME6, semester.getCourseNAME6 ());

            intent.putExtra (CreateEditCoursesActivity.EXTRA_COURSECREDIT, semester.getCredit ());
            intent.putExtra (CreateEditCoursesActivity.EXTRA_COURSECREDIT1, semester.getCredit1 ());
            intent.putExtra (CreateEditCoursesActivity.EXTRA_COURSECREDIT2, semester.getCredit2 ());
            intent.putExtra (CreateEditCoursesActivity.EXTRA_COURSECREDIT3, semester.getCredit3 ());
            intent.putExtra (CreateEditCoursesActivity.EXTRA_COURSECREDIT4, semester.getCredit4 ());
            intent.putExtra (CreateEditCoursesActivity.EXTRA_COURSECREDIT5, semester.getCredit5 ());
            intent.putExtra (CreateEditCoursesActivity.EXTRA_COURSECREDIT6, semester.getCredit6 ());


            intent.putExtra (CreateEditCoursesActivity.EXTRA_COURSESCORE, semester.getScore ());
            intent.putExtra (CreateEditCoursesActivity.EXTRA_COURSESCORE1, semester.getScore1 ());
            intent.putExtra (CreateEditCoursesActivity.EXTRA_COURSESCORE2, semester.getScore2 ());
            intent.putExtra (CreateEditCoursesActivity.EXTRA_COURSESCORE3, semester.getScore3 ());
            intent.putExtra (CreateEditCoursesActivity.EXTRA_COURSESCORE4, semester.getScore4 ());
            intent.putExtra (CreateEditCoursesActivity.EXTRA_COURSESCORE5, semester.getScore5 ());
            intent.putExtra (CreateEditCoursesActivity.EXTRA_COURSESCORE6, semester.getScore6 ());

            intent.putExtra (CreateEditCoursesActivity.EXTRA_GPA, semester.getGPA ());

            intent.putExtra (CreateEditCoursesActivity.EXTRA_GRADEPOINT, semester.getGP ());
            intent.putExtra (CreateEditCoursesActivity.EXTRA_GRADEPOINT1, semester.getGP1 ());
            intent.putExtra (CreateEditCoursesActivity.EXTRA_GRADEPOINT2, semester.getGP2 ());
            intent.putExtra (CreateEditCoursesActivity.EXTRA_GRADEPOINT3, semester.getGP3 ());
            intent.putExtra (CreateEditCoursesActivity.EXTRA_GRADEPOINT4, semester.getGP4 ());
            intent.putExtra (CreateEditCoursesActivity.EXTRA_GRADEPOINT5, semester.getGP5 ());
            intent.putExtra (CreateEditCoursesActivity.EXTRA_GRADEPOINT6, semester.getGP6 ());


            HomeFragment.this.startActivityForResult (intent, ADD_COURSES_REQUEST);

        });


        HomeFragment.this.setHasOptionsMenu (true);
        return v;
    }


    private void ToastMesage(String message) {
        Toast.makeText (HomeFragment.this.getActivity (), message, Toast.LENGTH_SHORT).show ();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        HomeFragment.super.onActivityResult (requestCode, resultCode, data);

         if (requestCode == ADD_COURSES_REQUEST && resultCode == Activity.RESULT_OK) {
             int id = data.getIntExtra (CreateEditCoursesActivity.EXTRA_ID, -1);

             if (id == -1) {
                ToastMesage ("semester can't be created");
                 return;
             }

            String title = data.getStringExtra (CreateEditCoursesActivity.EXTRA_TITLE);

            String course = data.getStringExtra (CreateEditCoursesActivity.EXTRA_COURSENAME);
            String course1 = data.getStringExtra (CreateEditCoursesActivity.EXTRA_COURSENAME1);
            String course2 = data.getStringExtra (CreateEditCoursesActivity.EXTRA_COURSENAME2);
            String course3 = data.getStringExtra (CreateEditCoursesActivity.EXTRA_COURSENAME3);
            String course4 = data.getStringExtra (CreateEditCoursesActivity.EXTRA_COURSENAME4);
            String course5 = data.getStringExtra (CreateEditCoursesActivity.EXTRA_COURSENAME5);
            String course6 = data.getStringExtra (CreateEditCoursesActivity.EXTRA_COURSENAME6);

            double credit = data.getDoubleExtra (CreateEditCoursesActivity.EXTRA_COURSECREDIT, 0);
            double credit1 = data.getDoubleExtra (CreateEditCoursesActivity.EXTRA_COURSECREDIT1, 0);
            double credit2 = data.getDoubleExtra (CreateEditCoursesActivity.EXTRA_COURSECREDIT2, 0);
            double credit3 = data.getDoubleExtra (CreateEditCoursesActivity.EXTRA_COURSECREDIT3, 0);
            double credit4 = data.getDoubleExtra (CreateEditCoursesActivity.EXTRA_COURSECREDIT4, 0);
            double credit5 = data.getDoubleExtra (CreateEditCoursesActivity.EXTRA_COURSECREDIT5, 0);
            double credit6 = data.getDoubleExtra (CreateEditCoursesActivity.EXTRA_COURSECREDIT6, 0);

            double score = data.getDoubleExtra (CreateEditCoursesActivity.EXTRA_COURSESCORE, 0);
            double score1 = data.getDoubleExtra (CreateEditCoursesActivity.EXTRA_COURSESCORE1, 0);
            double score2 = data.getDoubleExtra (CreateEditCoursesActivity.EXTRA_COURSESCORE2, 0);
            double score3 = data.getDoubleExtra (CreateEditCoursesActivity.EXTRA_COURSESCORE3, 0);
            double score4 = data.getDoubleExtra (CreateEditCoursesActivity.EXTRA_COURSESCORE4, 0);
            double score5 = data.getDoubleExtra (CreateEditCoursesActivity.EXTRA_COURSESCORE5, 0);
            double score6 = data.getDoubleExtra (CreateEditCoursesActivity.EXTRA_COURSESCORE6, 0);
            double gpa = data.getDoubleExtra (CreateEditCoursesActivity.EXTRA_GPA, 0.00);


            String gradepoint = data.getStringExtra (CreateEditCoursesActivity.EXTRA_GRADEPOINT);
            String gradepoint1 = data.getStringExtra (CreateEditCoursesActivity.EXTRA_GRADEPOINT1);
            String gradepoint2 = data.getStringExtra (CreateEditCoursesActivity.EXTRA_GRADEPOINT2);
            String gradepoint3 = data.getStringExtra (CreateEditCoursesActivity.EXTRA_GRADEPOINT3);
            String gradepoint4 = data.getStringExtra (CreateEditCoursesActivity.EXTRA_GRADEPOINT4);
            String gradepoint5 = data.getStringExtra (CreateEditCoursesActivity.EXTRA_GRADEPOINT5);
            String gradepoint6 = data.getStringExtra (CreateEditCoursesActivity.EXTRA_GRADEPOINT6);


            Semester semester = new Semester (title, "", course, course1, course2, course3, course4, course5, course6,
                    credit, credit1, credit2, credit3, credit4, credit5, credit6, score, score1, score2, score3, score4, score5, score6, gradepoint,
                    gradepoint1, gradepoint2, gradepoint3, gradepoint4, gradepoint5, gradepoint6, gpa);
            semesterViewModel.update (semester);
            semester.setId (id);

            ToastMesage ("Saved");
        } else {
            ToastMesage ("cancelled");
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate (R.menu.main_menu, menu);
        HomeFragment.super.onCreateOptionsMenu (menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId () == R.id.deleteAllsemesters) {

            if (Objects.requireNonNull (semesterViewModel.getAllSemesters ().getValue ()).isEmpty ()) {
                ToastMesage ("no semester created yet");

            } else {
                AlertDialog.Builder builder=new AlertDialog.Builder (Objects.requireNonNull (getContext ()));
                builder.setTitle ("Delete all semesters?")
                        .setCancelable (false)
                        .setMessage ("this operation cannot be undone when clicked, do you wish to continue?")
                        .setPositiveButton ("Yes", (dialog, which) -> {
                            semesterViewModel.deleteAll ();
                            ToastMesage ("all semester deleted");
                            swipe.setVisibility (View.INVISIBLE);
                        }).setNegativeButton ("No", (dialog, which) -> dialog.dismiss ()).create ().show ();


            }
            return true;
        }
        return HomeFragment.super.onOptionsItemSelected (item);
    }

}