package com.example.a16_recyclerview_pinterest_cells;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.os.Bundle;

import com.example.a16_recyclerview_pinterest_cells.adapter.CustomAdapter;
import com.example.a16_recyclerview_pinterest_cells.helper.SpacesItemDecoration;
import com.example.a16_recyclerview_pinterest_cells.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        List<Member> members = prepareMemberList();
        refreshAdapter(members);

    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        SpacesItemDecoration decoration = new SpacesItemDecoration(15);
        recyclerView.addItemDecoration(decoration);
    }
    private List<Member> prepareMemberList() {
        List<Member> members = new ArrayList<>();

        for(int i = 0; i < 20; i++){
            members.add(new Member("Nature"," "+i));
        }
        return members;
    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter = new CustomAdapter(context, members);
        recyclerView.setAdapter(adapter);
    }

}