package com.example.moderngpa_calculator;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class SemesterRepos {
    private SemesterDao semesterDao;
    private LiveData<List<Semester>>allSemesters;


    public SemesterRepos(Application application)
    {
        SemesterDatabase database=SemesterDatabase.getInstance(application);
        semesterDao=database.semesterDao();
        allSemesters=semesterDao.getAllSemesters();
    }

    public void insert(Semester semester)
    {
        new InsertSemesterAsyncTask(semesterDao).execute(semester);
    }

    public void delete(Semester semester)
    {
        new DeleteSemesterAsyncTask(semesterDao).execute(semester);
    }


    public void update(Semester semester)
    {
        new updateSemesterAsyncTask(semesterDao).execute(semester);
    }

    public void deleteAllSemesters()
    {
        new DeleteAllSemesterAsyncTask(semesterDao).execute();
    }

    public LiveData<List<Semester>> getAllSemesters() {
        return allSemesters;
    }

    private static class InsertSemesterAsyncTask extends AsyncTask<Semester,Void,Void>
    {
        private SemesterDao semesterDao;

        private InsertSemesterAsyncTask(SemesterDao semesterDao)
        {
            this.semesterDao=semesterDao;
        }
        @Override
        protected Void doInBackground(Semester... semesters) {
            semesterDao.insert(semesters[0]);
            return null;
        }
    }

    private static class DeleteSemesterAsyncTask extends AsyncTask<Semester,Void,Void>
    {
        private SemesterDao semesterDao;

        private DeleteSemesterAsyncTask(SemesterDao semesterDao)
        {
            this.semesterDao=semesterDao;
        }
        @Override
        protected Void doInBackground(Semester... semesters) {
            semesterDao.delete(semesters[0]);
            return null;
        }
    }


    private static class updateSemesterAsyncTask extends AsyncTask<Semester,Void,Void>
    {
        private SemesterDao semesterDao;

        private updateSemesterAsyncTask(SemesterDao semesterDao)
        {
            this.semesterDao=semesterDao;
        }
        @Override
        protected Void doInBackground(Semester... semesters) {
            semesterDao.update(semesters[0]);
            return null;
        }
    }

    private static class DeleteAllSemesterAsyncTask extends AsyncTask<Void,Void,Void>
    {
        private SemesterDao semesterDao;

        private DeleteAllSemesterAsyncTask(SemesterDao semesterDao)
        {
            this.semesterDao=semesterDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            semesterDao.deleteAllSemesters();
            return null;
        }
    }
}
