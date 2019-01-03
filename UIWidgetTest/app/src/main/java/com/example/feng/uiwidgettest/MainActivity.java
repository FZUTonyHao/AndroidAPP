package com.example.feng.uiwidgettest;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //    //___________________________________________________
    private EditText editText;
    private List<Fruit> fruitList ;
    private  FruitAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        editText=(EditText)findViewById(R.id.edit_text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button:

                        String inputText = editText.getText().toString();

                        Toast.makeText(MainActivity.this, inputText,
                                Toast.LENGTH_SHORT).show();
                        if(!TextUtils.isEmpty(inputText)){
                            Fruit fruit = new Fruit();
                            fruit.setName(inputText);
                            fruit.setImageId(R.drawable.book);
                            fruitList.add(0,fruit);
                            adapter.notifyDataSetChanged();

                        }

                        break;
                    default:
                        break;
                }
            }
        });



        //    _____________________________________________
//    private List<Fruit>fruitList=new ArrayList<>();
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        //  ________________________



        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
         adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);

    }

    /**
     * 初始化书名
     */
    private void initFruits () {
            fruitList = new ArrayList<>();
            Fruit book1 = new Fruit("《高等数学》", R.drawable.book);
            fruitList.add(book1);
            Fruit book2 = new Fruit("《线性代数》", R.drawable.book);
            fruitList.add(book2);
            Fruit book3 = new Fruit("《大学英语》", R.drawable.book);
            fruitList.add(book3);
            Fruit book4 = new Fruit("《大学物理》", R.drawable.book);
            fruitList.add(book4);
            Fruit book5 = new Fruit("《解析几何》", R.drawable.book);
            fruitList.add(book5);
            Fruit book6 = new Fruit("《JAVA》", R.drawable.book);
            fruitList.add(book6);
            Fruit book7 = new Fruit("《Android》", R.drawable.book);
            fruitList.add(book7);
            Fruit book8 = new Fruit("《C Primer Plus》", R.drawable.book);
            fruitList.add(book8);
            Fruit book9 = new Fruit("《计算机科学导论》", R.drawable.book);
            fruitList.add(book9);
            Fruit book10 = new Fruit("《中国近现代史纲要》", R.drawable.book);
            fruitList.add(book10);
        }
    }



