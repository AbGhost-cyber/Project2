package com.example.moderngpa_calculator;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = Semester.class,version =12)
public abstract class SemesterDatabase extends RoomDatabase {

    private static SemesterDatabase instance;
    public  abstract SemesterDao semesterDao();
    public  static synchronized SemesterDatabase getInstance(Context context)
    {
        if(instance==null)
        {
            instance= Room.databaseBuilder(context.getApplicationContext(),
                    SemesterDatabase.class, "Semester_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private  static Callback roomCallback=new Callback()
    {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static  class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>
    {
        private  SemesterDao semesterDao;

        private  PopulateDbAsyncTask(SemesterDatabase sb)
        {
            semesterDao=sb.semesterDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
         semesterDao.insert(new Semester("Semester","","","","","",
                 "","","",0,0,0,0,0,0,0,
                 0,0,0,0,0,0,0,"","","",
                 "","","","",0.00));

            return null;
        }
    }
}
