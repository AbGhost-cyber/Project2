package com.example.moderngpa_calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class CreateEditCoursesActivity extends AppCompatActivity {
    public static final String EXTRA_ID = "com.example.calculategpa.EXTRA_ID";
    public static final String EXTRA_TITLE = "com.example.calculategpa.EXTRA_TITLE";
    public static final String EXTRA_COURSENAME = "com.example.calculategpa.EXTRA_COURSENAME";
    public static final String EXTRA_COURSECREDIT = "com.example.calculategpa.EXTRA_COURSECREDIT";
    public static final String EXTRA_COURSESCORE = "com.example.calculategpa.EXTRA_COURSESCORE";
    public static final String EXTRA_GRADEPOINT = "com.example.calculategpa.EXTRA_GRADEPOINT";

    public static final String EXTRA_COURSENAME1 = "com.example.calculategpa.EXTRA_COURSENAME1";
    public static final String EXTRA_COURSECREDIT1 = "com.example.calculategpa.EXTRA_COURSECREDIT1";
    public static final String EXTRA_COURSESCORE1 = "com.example.calculategpa.EXTRA_COURSESCORE1";
    public static final String EXTRA_GRADEPOINT1 = "com.example.calculategpa.EXTRA_GRADEPOINT1";

    public static final String EXTRA_COURSENAME2 = "com.example.calculategpa.EXTRA_COURSENAME2";
    public static final String EXTRA_COURSECREDIT2 = "com.example.calculategpa.EXTRA_COURSECREDIT2";
    public static final String EXTRA_COURSESCORE2 = "com.example.calculategpa.EXTRA_COURSESCORE2";
    public static final String EXTRA_GRADEPOINT2 = "com.example.calculategpa.EXTRA_GRADEPOINT2";

    public static final String EXTRA_COURSENAME3 = "com.example.calculategpa.EXTRA_COURSENAME3";
    public static final String EXTRA_COURSECREDIT3 = "com.example.calculategpa.EXTRA_COURSECREDIT3";
    public static final String EXTRA_COURSESCORE3 = "com.example.calculategpa.EXTRA_COURSESCORE3";
    public static final String EXTRA_GRADEPOINT3 = "com.example.calculategpa.EXTRA_GRADEPOINT3";

    public static final String EXTRA_COURSENAME4 = "com.example.calculategpa.EXTRA_COURSENAME4";
    public static final String EXTRA_COURSECREDIT4 = "com.example.calculategpa.EXTRA_COURSECREDIT4";
    public static final String EXTRA_COURSESCORE4 = "com.example.calculategpa.EXTRA_COURSESCORE4";
    public static final String EXTRA_GRADEPOINT4 = "com.example.calculategpa.EXTRA_GRADEPOINT4";

    public static final String EXTRA_COURSENAME5 = "com.example.calculategpa.EXTRA_COURSENAME3";
    public static final String EXTRA_COURSECREDIT5 = "com.example.calculategpa.EXTRA_COURSECREDIT3";
    public static final String EXTRA_COURSESCORE5 = "com.example.calculategpa.EXTRA_COURSESCORE3";
    public static final String EXTRA_GRADEPOINT5 = "com.example.calculategpa.EXTRA_GRADEPOINT3";

    public static final String EXTRA_COURSENAME6 = "com.example.calculategpa.EXTRA_COURSENAME6";
    public static final String EXTRA_COURSECREDIT6 = "com.example.calculategpa.EXTRA_COURSECREDIT6";
    public static final String EXTRA_COURSESCORE6 = "com.example.calculategpa.EXTRA_COURSESCORE6";
    public static final String EXTRA_GRADEPOINT6 = "com.example.calculategpa.EXTRA_GRADEPOINT6";
    public static final String EXTRA_GPA = "com.example.calculategpa.EXTRA_GPA";
    private EditText editTextTitle;
    private EditText editTextCourseName, editTextCourseName1, editTextCourseName2, editTextCourseName3,
            editTextCourseName4, editTextCourseName5, editTextCourseName6;
    private EditText score, credit, score1, credit1, score2, credit2, score3, credit3, score4, credit4, score5, credit5,
            score6, credit6;
    private TextView Gradepoint, Gradepoint1, Gradepoint2, Gradepoint3, Gradepoint4, Gradepoint5, Gradepoint6;
    protected static double GPa;

    private double gradepoint = 0.0;
    private double CreditRate = 0, CreditRate1 = 0, CreditRate2 = 0, CreditRate3 = 0, CreditRate4 = 0, CreditRate5 = 0,
            CreditRate6 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_add_note);

        editTextTitle = findViewById (R.id.edit_text_title);

        editTextCourseName = findViewById (R.id.CourseNamee);
        editTextCourseName1 = findViewById (R.id.CourseNamee1);
        editTextCourseName2 = findViewById (R.id.CourseNamee2);
        editTextCourseName3 = findViewById (R.id.CourseNamee3);
        editTextCourseName4 = findViewById (R.id.CourseNamee4);
        editTextCourseName5 = findViewById (R.id.CourseNamee5);
        editTextCourseName6 = findViewById (R.id.CourseNamee6);

        score = findViewById (R.id.CourseScore);
        score1 = findViewById (R.id.CourseScore1);
        score2 = findViewById (R.id.CourseScore2);
        score3 = findViewById (R.id.CourseScore3);
        score4 = findViewById (R.id.CourseScore4);
        score5 = findViewById (R.id.CourseScore5);
        score6 = findViewById (R.id.CourseScore6);

        credit = findViewById (R.id.CourseCredit);
        credit1 = findViewById (R.id.CourseCredit1);
        credit2 = findViewById (R.id.CourseCredit2);
        credit3 = findViewById (R.id.CourseCredit3);
        credit4 = findViewById (R.id.CourseCredit4);
        credit5 = findViewById (R.id.CourseCredit5);
        credit6 = findViewById (R.id.CourseCredit6);


        Gradepoint = findViewById (R.id.textview_GP);
        Gradepoint1 = findViewById (R.id.textview_GP1);
        Gradepoint2 = findViewById (R.id.textview_GP2);
        Gradepoint3 = findViewById (R.id.textview_GP3);
        Gradepoint4 = findViewById (R.id.textview_GP4);
        Gradepoint5 = findViewById (R.id.textview_GP5);
        Gradepoint6 = findViewById (R.id.textview_GP6);


        Objects.requireNonNull (getSupportActionBar ()).setHomeAsUpIndicator (R.drawable.ic_close_24dp);

        Intent intent = getIntent ();
        if (intent.hasExtra (EXTRA_ID)) {

            editTextTitle.setText (intent.getStringExtra (EXTRA_TITLE));

            editTextCourseName.setText (intent.getStringExtra (EXTRA_COURSENAME));
            editTextCourseName1.setText (intent.getStringExtra (EXTRA_COURSENAME1));
            editTextCourseName2.setText (intent.getStringExtra (EXTRA_COURSENAME2));
            editTextCourseName3.setText (intent.getStringExtra (EXTRA_COURSENAME3));
            editTextCourseName4.setText (intent.getStringExtra (EXTRA_COURSENAME4));
            editTextCourseName5.setText (intent.getStringExtra (EXTRA_COURSENAME5));
            editTextCourseName6.setText (intent.getStringExtra (EXTRA_COURSENAME6));

            score.setText (String.valueOf (intent.getDoubleExtra (EXTRA_COURSESCORE, 0)));
            score1.setText (String.valueOf (intent.getDoubleExtra (EXTRA_COURSESCORE1, 0)));
            score2.setText (String.valueOf (intent.getDoubleExtra (EXTRA_COURSESCORE2, 0)));
            score3.setText (String.valueOf (intent.getDoubleExtra (EXTRA_COURSESCORE3, 0)));
            score4.setText (String.valueOf (intent.getDoubleExtra (EXTRA_COURSESCORE4, 0)));
            score5.setText (String.valueOf (intent.getDoubleExtra (EXTRA_COURSESCORE5, 0)));
            score6.setText (String.valueOf (intent.getDoubleExtra (EXTRA_COURSESCORE6, 0)));

            credit.setText (String.valueOf (intent.getDoubleExtra (EXTRA_COURSECREDIT, 0)));
            credit1.setText (String.valueOf (intent.getDoubleExtra (EXTRA_COURSECREDIT1, 0)));
            credit2.setText (String.valueOf (intent.getDoubleExtra (EXTRA_COURSECREDIT2, 0)));
            credit3.setText (String.valueOf (intent.getDoubleExtra (EXTRA_COURSECREDIT3, 0)));
            credit4.setText (String.valueOf (intent.getDoubleExtra (EXTRA_COURSECREDIT4, 0)));
            credit5.setText (String.valueOf (intent.getDoubleExtra (EXTRA_COURSECREDIT5, 0)));
            credit6.setText (String.valueOf (intent.getDoubleExtra (EXTRA_COURSECREDIT6, 0)));

            Gradepoint.setText (intent.getStringExtra (EXTRA_GRADEPOINT));
            Gradepoint1.setText (intent.getStringExtra (EXTRA_GRADEPOINT1));
            Gradepoint2.setText (intent.getStringExtra (EXTRA_GRADEPOINT2));
            Gradepoint3.setText (intent.getStringExtra (EXTRA_GRADEPOINT3));
            Gradepoint4.setText (intent.getStringExtra (EXTRA_GRADEPOINT4));
            Gradepoint5.setText (intent.getStringExtra (EXTRA_GRADEPOINT5));
            Gradepoint6.setText (intent.getStringExtra (EXTRA_GRADEPOINT6));

            setTitle ("Add courses");
        }



    }

    private void saveSemester() {
        String title = editTextTitle.getText ().toString ();
        if (title.trim ().isEmpty ()) {
            Toast.makeText (this, "please insert a semester", Toast.LENGTH_SHORT).show ();
            return;
        }

        String courseName = editTextCourseName.getText ().toString ();
        String courseName1 = editTextCourseName1.getText ().toString ();
        String courseName2 = editTextCourseName2.getText ().toString ();
        String courseName3 = editTextCourseName3.getText ().toString ();
        String courseName4 = editTextCourseName4.getText ().toString ();
        String courseName5 = editTextCourseName5.getText ().toString ();
        String courseName6 = editTextCourseName6.getText ().toString ();


        Intent data = new Intent ();
        data.putExtra (EXTRA_TITLE, title);
        data.putExtra (EXTRA_COURSENAME, courseName);
        data.putExtra (EXTRA_COURSENAME1, courseName1);
        data.putExtra (EXTRA_COURSENAME2, courseName2);
        data.putExtra (EXTRA_COURSENAME3, courseName3);
        data.putExtra (EXTRA_COURSENAME4, courseName4);
        data.putExtra (EXTRA_COURSENAME5, courseName5);
        data.putExtra (EXTRA_COURSENAME6, courseName6);

        int id = getIntent ().getIntExtra (EXTRA_ID, -1);
        if (id != -1) {
            data.putExtra (EXTRA_ID, id);


            double courseCredit, courseScore, courseCredit1, courseScore1, courseCredit2, courseScore2,
                    courseCredit3, courseScore3,
                    courseCredit4, courseScore4, courseCredit5, courseScore5, courseCredit6, courseScore6;

            courseCredit = Double.parseDouble (credit.getText ().toString ());
            courseCredit1 = Double.parseDouble (credit1.getText ().toString ());
            courseCredit2 = Double.parseDouble (credit2.getText ().toString ());
            courseCredit3 = Double.parseDouble (credit3.getText ().toString ());
            courseCredit4 = Double.parseDouble (credit4.getText ().toString ());
            courseCredit5 = Double.parseDouble (credit5.getText ().toString ());
            courseCredit6 = Double.parseDouble (credit6.getText ().toString ());

            courseScore = Double.parseDouble (score.getText ().toString ());
            courseScore1 = Double.parseDouble (score1.getText ().toString ());
            courseScore2 = Double.parseDouble (score2.getText ().toString ());
            courseScore3 = Double.parseDouble (score3.getText ().toString ());
            courseScore4 = Double.parseDouble (score4.getText ().toString ());
            courseScore5 = Double.parseDouble (score5.getText ().toString ());
            courseScore6 = Double.parseDouble (score6.getText ().toString ());

            if (courseScore <= 59 && courseScore <= 55) {
                gradepoint = 0.0;
                CreditRate = gradepoint * courseCredit;
                Gradepoint.setText ("F");
            } else if (courseScore <= 64 && courseScore >= 60) {
                gradepoint = 1.0;
                CreditRate = gradepoint * courseCredit;
                Gradepoint.setText ("D-");
            } else if (courseScore <= 69 && courseScore >= 65) {

                gradepoint = 1.5;
                CreditRate = gradepoint * courseCredit;
                Gradepoint.setText ("D+");

            } else if (courseScore <= 74 && courseScore >= 70) {
                gradepoint = 2.0;
                CreditRate = gradepoint * courseCredit;
                Gradepoint.setText ("C-");
            } else if (courseScore <= 79 && courseScore >= 75) {
                gradepoint = 2.5;
                CreditRate = gradepoint * courseCredit;
                Gradepoint.setText ("C+");
            } else if (courseScore <= 84 && courseScore >= 80) {
                gradepoint = 3.0;
                CreditRate = gradepoint * courseCredit;
                Gradepoint.setText ("B-");
            } else if (courseScore <= 89 && courseScore >= 85) {
                gradepoint = 3.5;
                CreditRate = gradepoint * courseCredit;
                Gradepoint.setText ("B+");
            } else if (courseScore <= 100 && courseScore >= 90) {
                gradepoint = 4.0;
                CreditRate = gradepoint * courseCredit;
                Gradepoint.setText ("A+");
            } else {
                Gradepoint.setText ("");
            }


            if (courseScore1 <= 59 && courseScore1 <= 55) {
                gradepoint = 0.0;
                CreditRate1 = gradepoint * courseCredit1;
                Gradepoint1.setText ("F");
            } else if (courseScore1 <= 64 && courseScore1 >= 60) {
                gradepoint = 1.0;
                CreditRate1 = gradepoint * courseCredit1;
                Gradepoint1.setText ("D-");
            } else if (courseScore1 <= 69 && courseScore1 >= 65) {

                gradepoint = 1.5;
                CreditRate1 = gradepoint * courseCredit1;
                Gradepoint1.setText ("D+");

            } else if (courseScore1 <= 74 && courseScore1 >= 70) {
                gradepoint = 2.0;
                CreditRate1 = gradepoint * courseCredit1;
                Gradepoint1.setText ("C-");
            } else if (courseScore1 <= 79 && courseScore1 >= 75) {
                gradepoint = 2.5;
                CreditRate1 = gradepoint * courseCredit1;
                Gradepoint1.setText ("C+");
            } else if (courseScore1 <= 84 && courseScore1 >= 80) {
                gradepoint = 3.0;
                CreditRate1 = gradepoint * courseCredit1;
                Gradepoint1.setText ("B-");
            } else if (courseScore1 <= 89 && courseScore1 >= 85) {
                gradepoint = 3.5;
                CreditRate = gradepoint * courseCredit1;
                Gradepoint1.setText ("B+");
            } else if (courseScore1 <= 100 && courseScore1 >= 90) {
                gradepoint = 4.0;
                CreditRate1 = gradepoint * courseCredit1;
                Gradepoint1.setText ("A+");
            } else {
                Gradepoint1.setText ("");
            }


            if (courseScore2 <= 59 && courseScore2 <= 55) {
                gradepoint = 0.0;
                CreditRate2 = gradepoint * courseCredit2;
                Gradepoint2.setText ("F");
            } else if (courseScore2 <= 64 && courseScore2 >= 60) {
                gradepoint = 1.0;
                CreditRate2 = gradepoint * courseCredit2;
                Gradepoint2.setText ("D-");
            } else if (courseScore2 <= 69 && courseScore2 >= 65) {

                gradepoint = 1.5;
                CreditRate2 = gradepoint * courseCredit2;
                Gradepoint2.setText ("D+");

            } else if (courseScore2 <= 74 && courseScore2 >= 70) {
                gradepoint = 2.0;
                CreditRate2 = gradepoint * courseCredit2;
                Gradepoint2.setText ("C-");
            } else if (courseScore2 <= 79 && courseScore2 >= 75) {
                gradepoint = 2.5;
                CreditRate2 = gradepoint * courseCredit2;
                Gradepoint2.setText ("C+");
            } else if (courseScore2 <= 84 && courseScore2 >= 80) {
                gradepoint = 3.0;
                CreditRate2 = gradepoint * courseCredit2;
                Gradepoint2.setText ("B-");
            } else if (courseScore2 <= 89 && courseScore2 >= 85) {
                gradepoint = 3.5;
                CreditRate2 = gradepoint * courseCredit2;
                Gradepoint2.setText ("B+");
            } else if (courseScore2 <= 100 && courseScore2 >= 90) {
                gradepoint = 4.0;
                CreditRate2 = gradepoint * courseCredit2;
                Gradepoint2.setText ("A+");
            } else {
                Gradepoint2.setText ("");
            }


            if (courseScore3 <= 59 && courseScore3 <= 55) {
                gradepoint = 0.0;
                CreditRate3 = gradepoint * courseCredit3;
                Gradepoint3.setText ("F");
            } else if (courseScore3 <= 64 && courseScore3 >= 60) {
                gradepoint = 1.0;
                CreditRate3 = gradepoint * courseCredit3;
                Gradepoint3.setText ("D-");
            } else if (courseScore3 <= 69 && courseScore3 >= 65) {

                gradepoint = 1.5;
                CreditRate3 = gradepoint * courseCredit3;
                Gradepoint3.setText ("D+");

            } else if (courseScore3 <= 74 && courseScore3 >= 70) {
                gradepoint = 2.0;
                CreditRate3 = gradepoint * courseCredit3;
                Gradepoint3.setText ("C-");
            } else if (courseScore3 <= 79 && courseScore3 >= 75) {
                gradepoint = 2.5;
                CreditRate3 = gradepoint * courseCredit3;
                Gradepoint3.setText ("C+");
            } else if (courseScore3 <= 84 && courseScore3 >= 80) {
                gradepoint = 3.0;
                CreditRate3 = gradepoint * courseCredit3;
                Gradepoint3.setText ("B-");
            } else if (courseScore3 <= 89 && courseScore3 >= 85) {
                gradepoint = 3.5;
                CreditRate3 = gradepoint * courseCredit3;
                Gradepoint3.setText ("B+");
            } else if (courseScore3 <= 100 && courseScore3 >= 90) {
                gradepoint = 4.0;
                CreditRate3 = gradepoint * courseCredit3;
                Gradepoint3.setText ("A+");
            } else {
                Gradepoint3.setText ("");
            }


            if (courseScore4 <= 59 && courseScore4 <= 55) {
                gradepoint = 0.0;
                CreditRate4 = gradepoint * courseCredit4;
                Gradepoint4.setText ("F");
            } else if (courseScore4 <= 64 && courseScore4 >= 60) {
                gradepoint = 1.0;
                CreditRate4 = gradepoint * courseCredit4;
                Gradepoint4.setText ("D-");
            } else if (courseScore4 <= 69 && courseScore4 >= 65) {

                gradepoint = 1.5;
                CreditRate4 = gradepoint * courseCredit4;
                Gradepoint4.setText ("D+");

            } else if (courseScore4 <= 74 && courseScore4 >= 70) {
                gradepoint = 2.0;
                CreditRate2 = gradepoint * courseCredit2;
                Gradepoint4.setText ("C-");
            } else if (courseScore4 <= 79 && courseScore4 >= 75) {
                gradepoint = 2.5;
                CreditRate4 = gradepoint * courseCredit4;
                Gradepoint4.setText ("C+");
            } else if (courseScore4 <= 84 && courseScore4 >= 80) {
                gradepoint = 3.0;
                CreditRate4 = gradepoint * courseCredit4;
                Gradepoint4.setText ("B-");
            } else if (courseScore4 <= 89 && courseScore4 >= 85) {
                gradepoint = 3.5;
                CreditRate4 = gradepoint * courseCredit4;
                Gradepoint4.setText ("B+");
            } else if (courseScore4 <= 100 && courseScore4 >= 90) {
                gradepoint = 4.0;
                CreditRate4 = gradepoint * courseCredit4;
                Gradepoint4.setText ("A+");
            } else {
                Gradepoint4.setText ("");
            }


            if (courseScore5 <= 59 && courseScore5 <= 55) {
                gradepoint = 0.0;
                CreditRate5 = gradepoint * courseCredit5;
                Gradepoint5.setText ("F");
            } else if (courseScore5 <= 64 && courseScore5 >= 60) {
                gradepoint = 1.0;
                CreditRate5 = gradepoint * courseCredit5;
                Gradepoint5.setText ("D-");
            } else if (courseScore5 <= 69 && courseScore5 >= 65) {

                gradepoint = 1.5;
                CreditRate5 = gradepoint * courseCredit5;
                Gradepoint5.setText ("D+");

            } else if (courseScore5 <= 74 && courseScore5 >= 70) {
                gradepoint = 2.0;
                CreditRate5 = gradepoint * courseCredit5;
                Gradepoint5.setText ("C-");
            } else if (courseScore5 <= 79 && courseScore5 >= 75) {
                gradepoint = 2.5;
                CreditRate5 = gradepoint * courseCredit5;
                Gradepoint5.setText ("C+");
            } else if (courseScore5 <= 84 && courseScore5 >= 80) {
                gradepoint = 3.0;
                CreditRate5 = gradepoint * courseCredit5;
                Gradepoint5.setText ("B-");
            } else if (courseScore5 <= 89 && courseScore5 >= 85) {
                gradepoint = 3.5;
                CreditRate5 = gradepoint * courseCredit5;
                Gradepoint5.setText ("B+");
            } else if (courseScore5 <= 100 && courseScore5 >= 90) {
                gradepoint = 4.0;
                CreditRate5 = gradepoint * courseCredit5;
                Gradepoint5.setText ("A+");
            } else {
                Gradepoint5.setText ("");
            }


            if (courseScore6 <= 59 && courseScore6 <= 55) {
                gradepoint = 0;
                CreditRate6 = gradepoint * courseCredit6;
                Gradepoint6.setText ("F");
            } else if (courseScore6 <= 64 && courseScore6 >= 60) {
                gradepoint = 1.0;
                CreditRate6 = gradepoint * courseCredit6;
                Gradepoint6.setText ("D-");
            } else if (courseScore6 <= 69 && courseScore6 >= 65) {

                gradepoint = 1.5;
                CreditRate6 = gradepoint * courseCredit6;
                Gradepoint6.setText ("D+");

            } else if (courseScore6 <= 74 && courseScore6 >= 70) {
                gradepoint = 2.0;
                CreditRate6 = gradepoint * courseCredit6;
                Gradepoint6.setText ("C-");
            } else if (courseScore6 <= 79 && courseScore6 >= 75) {
                gradepoint = 2.5;
                CreditRate6 = gradepoint * courseCredit6;
                Gradepoint6.setText ("C+");
            } else if (courseScore6 <= 84 && courseScore6 >= 80) {
                gradepoint = 3.0;
                CreditRate6 = gradepoint * courseCredit6;
                Gradepoint6.setText ("B-");
            } else if (courseScore6 <= 89 && courseScore6 >= 85) {
                gradepoint = 3.5;
                CreditRate6 = gradepoint * courseCredit6;
                Gradepoint6.setText ("B+");
            } else if (courseScore6 <= 100 && courseScore6 >= 90) {
                gradepoint = 4.0;
                CreditRate6 = gradepoint * courseCredit6;
                Gradepoint6.setText ("A+");
            } else {
                Gradepoint6.setText ("");
            }
            double totalCU = courseCredit + courseCredit1 + courseCredit2 + courseCredit3 + courseCredit4 + courseCredit5 + courseCredit6;
            double totalCR = CreditRate + CreditRate1 + CreditRate2 + CreditRate3 + CreditRate4 + CreditRate5 + CreditRate6;
            double MyGPA = (totalCR / totalCU);
            GPa = Math.round (MyGPA * 100.0) / 100.0;


            data.putExtra (EXTRA_GRADEPOINT, Gradepoint.getText ());
            data.putExtra (EXTRA_GRADEPOINT1, Gradepoint1.getText ());
            data.putExtra (EXTRA_GRADEPOINT2, Gradepoint2.getText ());
            data.putExtra (EXTRA_GRADEPOINT3, Gradepoint3.getText ());
            data.putExtra (EXTRA_GRADEPOINT4, Gradepoint4.getText ());
            data.putExtra (EXTRA_GRADEPOINT5, Gradepoint5.getText ());
            data.putExtra (EXTRA_GRADEPOINT6, Gradepoint6.getText ());
            data.putExtra (EXTRA_GPA, GPa);

            data.putExtra (EXTRA_COURSECREDIT, courseCredit);
            data.putExtra (EXTRA_COURSECREDIT1, courseCredit1);
            data.putExtra (EXTRA_COURSECREDIT2, courseCredit2);
            data.putExtra (EXTRA_COURSECREDIT3, courseCredit3);
            data.putExtra (EXTRA_COURSECREDIT4, courseCredit4);
            data.putExtra (EXTRA_COURSECREDIT5, courseCredit5);
            data.putExtra (EXTRA_COURSECREDIT6, courseCredit6);

            data.putExtra (EXTRA_COURSESCORE, courseScore);
            data.putExtra (EXTRA_COURSESCORE1, courseScore1);
            data.putExtra (EXTRA_COURSESCORE2, courseScore2);
            data.putExtra (EXTRA_COURSESCORE3, courseScore3);
            data.putExtra (EXTRA_COURSESCORE4, courseScore4);
            data.putExtra (EXTRA_COURSESCORE5, courseScore5);
            data.putExtra (EXTRA_COURSESCORE6, courseScore6);

            setResult (RESULT_OK, data);

            finish ();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater ();
        menuInflater.inflate (R.menu.save_semester, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId () == R.id.save_semester_item) {
            saveSemester ();
            return true;
        }
        return super.onOptionsItemSelected (item);

    }
}

