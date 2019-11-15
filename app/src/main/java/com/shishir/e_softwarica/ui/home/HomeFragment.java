package com.shishir.e_softwarica.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shishir.e_softwarica.R;
import com.shishir.e_softwarica.adapter.StudentAdapter;
import com.shishir.e_softwarica.model.Student;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    //to display the list item of the student in recyclerview

    static List<Student> studentList = new ArrayList<>();

    private RecyclerView recycler_view;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recycler_view = root.findViewById(R.id.recycler_view);

        //Add the contact

        Student student = new Student("shishir", "ktm","Male",23);
        studentList = student.getStudentList();

        if (studentList.isEmpty()){
            studentList.add(new Student("shishir","ktm","Male",22));
            studentList.add(new Student("Basanti", "pok","Female",20));
            student.setStudentList(studentList);

            }
        StudentAdapter studentAdapter = new StudentAdapter(getActivity(),studentList);

        recycler_view.setAdapter(studentAdapter);
        recycler_view.setLayoutManager(new LinearLayoutManager(getActivity()));

        return root;
    }
}