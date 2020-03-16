package com.example.moderngpa_calculator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class SemesterAdapter extends RecyclerView.Adapter<SemesterAdapter.SemesterHolder> {
    List<Semester> semester = new ArrayList<>();
    private onSemesterItemClickListener listener;

    @NonNull
    @Override
    public SemesterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item, parent, false);

        return new SemesterHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SemesterHolder holder, int position) {
        Semester currentSemester = semester.get(position);
        holder.textViewTitle.setText(currentSemester.getTitle());
        NumberFormat nm=NumberFormat.getNumberInstance();
        if(currentSemester.getCourseNAME().trim().isEmpty()||currentSemester.getCourseNAME2().trim().isEmpty())
        {
            holder.courseDescription.setText(("Click to add course"));
        }
        else {

            String des =currentSemester.getCourseNAME() + "," + currentSemester.getCourseNAME1()+","
                    +currentSemester.getCourseNAME2();
            holder.courseDescription.setText(des);
        }



            holder.GPA.setText(nm.format(currentSemester.setGPA((CreateEditCoursesActivity.GPa))));
            holder.GPA.setText(nm.format(currentSemester.getGPA()));







    }

    @Override
    public int getItemCount() {
        return semester.size();
    }

    public void setSemester(List<Semester> semester) {
        this.semester = semester;
        notifyDataSetChanged();
    }


    public Semester getSemesterAt(int position) {
        return semester.get(position);
    }

    class SemesterHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView courseDescription;
        private TextView GPA;

        public SemesterHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            courseDescription=itemView.findViewById(R.id.text_view_description);
            GPA=itemView.findViewById(R.id.GPA);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(semester.get(position));
                }
            });
        }

    }

    public interface onSemesterItemClickListener {
        void onItemClick(Semester semester);

    }


    public void setOnItemClickListener(onSemesterItemClickListener listener) {
        this.listener = listener;
    }

}
