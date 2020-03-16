package com.example.moderngpa_calculator;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "semester_table")
public class Semester {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String courseDescription;
    private String courseNAME,courseNAME1,courseNAME2,courseNAME3,courseNAME4,courseNAME5,courseNAME6;
    private double credit,credit1,credit2,credit3,credit4,credit5,credit6;
    private double score,score1,score2,score3,score4,score5,score6;
    private String GP,GP1,GP2,GP3,GP4,GP5,GP6;
    private double GPA;

    public Semester(String title, String courseDescription, String courseNAME,
                    String courseNAME1, String courseNAME2, String courseNAME3, String courseNAME4,
                    String courseNAME5, String courseNAME6, double credit, double credit1, double credit2,
                    double credit3, double credit4, double credit5, double credit6, double score, double score1,
                    double score2, double score3, double score4, double score5, double score6,
                    String GP, String GP1, String GP2, String GP3, String GP4, String GP5, String GP6, double GPA) {
        this.title = title;
        this.courseDescription = courseDescription;
        this.courseNAME = courseNAME;
        this.courseNAME1 = courseNAME1;
        this.courseNAME2 = courseNAME2;
        this.courseNAME3 = courseNAME3;
        this.courseNAME4 = courseNAME4;
        this.courseNAME5 = courseNAME5;
        this.courseNAME6 = courseNAME6;
        this.credit = credit;
        this.credit1 = credit1;
        this.credit2 = credit2;
        this.credit3 = credit3;
        this.credit4 = credit4;
        this.credit5 = credit5;
        this.credit6 = credit6;
        this.score = score;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.score4 = score4;
        this.score5 = score5;
        this.score6 = score6;
        this.GP = GP;
        this.GP1 = GP1;
        this.GP2 = GP2;
        this.GP3 = GP3;
        this.GP4 = GP4;
        this.GP5 = GP5;
        this.GP6 = GP6;
        this.GPA = GPA;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCourseNAME() {
        return courseNAME;
    }

    public double getCredit() {
        return credit;
    }

    public double getScore() {
        return score;
    }

    public String getGP() {
        return GP;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public String getCourseNAME1() {
        return courseNAME1;
    }

    public double getCredit1() {
        return credit1;
    }

    public double getScore1() {
        return score1;
    }

    public String getGP1() {
        return GP1;
    }

    public String getCourseNAME2() {
        return courseNAME2;
    }

    public String getCourseNAME3() {
        return courseNAME3;
    }

    public String getCourseNAME4() {
        return courseNAME4;
    }

    public String getCourseNAME5() {
        return courseNAME5;
    }

    public String getCourseNAME6() {
        return courseNAME6;
    }


    public double getCredit2() {
        return credit2;
    }

    public  double getCredit3() {
        return credit3;
    }

    public  double getCredit4() {
        return credit4;
    }

    public double getCredit5() {
        return credit5;
    }

    public double getCredit6() {
        return credit6;
    }


    public double getScore2() {
        return score2;
    }

    public double getScore3() {
        return score3;
    }

    public double getScore4() {
        return score4;
    }

    public double getScore5() {
        return score5;
    }

    public double getScore6() {
        return score6;
    }
    public String getGP3() {
        return GP3;
    }

    public String getGP4() {
        return GP4;
    }

    public String getGP5() {
        return GP5;
    }

    public String getGP6() {
        return GP6;
    }

    public String getGP2() {
        return GP2;
    }

    public double getGPA()
    {
        return GPA;
    }

    public double setGPA(double GPA) {
        return GPA;
    }


}


