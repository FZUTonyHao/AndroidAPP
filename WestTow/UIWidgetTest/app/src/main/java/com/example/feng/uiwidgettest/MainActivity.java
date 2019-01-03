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
    private List<Book> bookList;
    private  BookAdapter adapter;

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
                            Book book = new Book();
                            book.setName(inputText);
                            book.setImageId(R.drawable.book);
                            bookList.add(0, book);
                            adapter.notifyDataSetChanged();

                        }

                        break;
                    default:
                        break;
                }
            }
        });



        //    _____________________________________________
//    private List<Book>bookList=new ArrayList<>();
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        //  ________________________



        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
         adapter = new BookAdapter(bookList);
        recyclerView.setAdapter(adapter);

    }

    /**
     * 初始化书名
     */
    private void initFruits () {
            bookList = new ArrayList<>();
            Book book1 = new Book("《高等数学》", R.drawable.book);
            bookList.add(book1);
            Book book2 = new Book("《线性代数》", R.drawable.book);
            bookList.add(book2);
            Book book3 = new Book("《大学英语》", R.drawable.book);
            bookList.add(book3);
            Book book4 = new Book("《大学物理》", R.drawable.book);
            bookList.add(book4);
            Book book5 = new Book("《解析几何》", R.drawable.book);
            bookList.add(book5);
            Book book6 = new Book("《JAVA》", R.drawable.book);
            bookList.add(book6);
            Book book7 = new Book("《Android》", R.drawable.book);
            bookList.add(book7);
            Book book8 = new Book("《C Primer Plus》", R.drawable.book);
            bookList.add(book8);
            Book book9 = new Book("《计算机科学导论》", R.drawable.book);
            bookList.add(book9);
            Book book10 = new Book("《中国近现代史纲要》", R.drawable.book);
            bookList.add(book10);
        }
    }



