package com.example.moderngpa_calculator;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class SemesterViewModel extends AndroidViewModel {
    private SemesterRepos repos;
    private LiveData<List<Semester>>allSemesters;

    public SemesterViewModel(@NonNull Application application) {
        super(application);
        repos=new SemesterRepos(application);
        allSemesters=repos.getAllSemesters();
    }

    public void insert(Semester semester)
    {
        repos.insert(semester);
    }
    public void delete(Semester semester)
    {
        repos.delete(semester);
    }

    public void update(Semester semester)
    {
        repos.update(semester);
    }

    public void deleteAll()
    {
        repos.deleteAllSemesters();
    }

    public LiveData<List<Semester>> getAllSemesters() {
        return allSemesters;
    }
}
