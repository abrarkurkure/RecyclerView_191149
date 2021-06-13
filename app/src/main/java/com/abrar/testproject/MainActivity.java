package com.abrar.testproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    private ArrayList<ExampleItem> mExampleList;
    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    //private Button buttonInsert;
    //private Button buttonRemove;
    // private EditText editTextInsert;
    //private EditText editTextRemove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createExampleList();
        buildRecyclerView();
       // setButtons();
    }
   public void insertItem(int position) {
        mExampleList.add(position, new ExampleItem(R.drawable.ic_android, "New Item At Position" + position, "This is Line 2"));
        mAdapter.notifyItemInserted(position);
    }
    public void removeItem(int position) {
        mExampleList.remove(position);
        mAdapter.notifyItemRemoved(position);
   }
    public void changeItem(int position, String text) {
       mExampleList.get(position).changeText1(text);
       mAdapter.notifyItemChanged(position);
    }
    public void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add(new ExampleItem(R.drawable.ic_android, "OBJECT 1", "Item 1"));
        mExampleList.add(new ExampleItem(R.drawable.ic_beach, "OBJECT 2", "Item 2"));
        mExampleList.add(new ExampleItem(R.drawable.ic_sun, "OBJECT 3", "Item 3"));
        mExampleList.add(new ExampleItem(R.drawable.ic_bakery, "OBJECT 4", "Item 4"));
        mExampleList.add(new ExampleItem(R.drawable.ic_focus, "OBJECT 5", "Item 5"));
        mExampleList.add(new ExampleItem(R.drawable.ic_emoji, "OBJECT 6", "Item 6"));
        mExampleList.add(new ExampleItem(R.drawable.ic_palette, "OBJECT 7", "Item 7"));
        mExampleList.add(new ExampleItem(R.drawable.ic_android, "OBJECT 8", "Item 8"));
        mExampleList.add(new ExampleItem(R.drawable.ic_beach, "OBJECT 9", "Item 9"));
    }
    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                changeItem(position, "Clicked");
            }
            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }
        });
    }
    //public void setButtons() {
       // buttonInsert = findViewById(R.id.button_insert);
      //  buttonRemove = findViewById(R.id.button_remove);
      //  editTextInsert = findViewById(R.id.edittext_insert);
       // editTextRemove = findViewById(R.id.edittext_remove);
      //  buttonInsert.setOnClickListener(new View.OnClickListener() {
        //    @Override
         //   public void onClick(View v) {
       //         int position = Integer.parseInt(editTextInsert.getText().toString());
        //        insertItem(position);
      //      }
      //  });
       // buttonRemove.setOnClickListener(new View.OnClickListener() {
       //     @Override
     //       public void onClick(View v) {
      //          int position = Integer.parseInt(editTextRemove.getText().toString());
      //          removeItem(position);
      //      }
     //   });
  //  }
}