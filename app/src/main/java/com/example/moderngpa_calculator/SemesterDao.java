package com.example.moderngpa_calculator;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SemesterDao {

   @Insert
    void insert(Semester semester);

   @Delete
    void delete(Semester semester);

    @Update
    void update(Semester semester);

   @Query("DELETE FROM semester_table")
    void deleteAllSemesters();

   @Query("SELECT * FROM semester_table ORDER BY id ASC")
   LiveData<List<Semester>>getAllSemesters();




}
