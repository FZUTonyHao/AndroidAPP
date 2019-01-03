package com.example.feng.uibestpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Msg> msgList=new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsgs();
        inputText=(EditText)findViewById(R.id.input_text);
        send =(Button)findViewById(R.id.send);
        msgRecyclerView=(RecyclerView)findViewById(R.id.msg_recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        adapter=new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content=inputText.getText().toString();
                if (!"".equals(content)){

                        if (msgList.size() % 2 == 0) {

                            Msg msg = new Msg(content, Msg.TYPE_RECEIVED);
                            msgList.add(0, msg);
                            adapter.notifyDataSetChanged();
                            msgRecyclerView.scrollToPosition(msgList.size() + 1);
                            inputText.setText("");
                        } else {
                            Msg msg = new Msg(content, Msg.TYPE_SENT);
                            msgList.add(0, msg);
                            adapter.notifyDataSetChanged();
                            msgRecyclerView.scrollToPosition(msgList.size() + 1);
                            inputText.setText("");


                    }
                }
            }
        });
    }
    private void initMsgs(){
        Msg msg1=new Msg("《高等数学》",Msg.TYPE_SENT);
        msgList.add(msg1);
        Msg msg2=new Msg("《线性代数》",Msg.TYPE_RECEIVED);
        msgList.add(msg2);
        Msg msg3=new Msg("《大学英语》",Msg.TYPE_SENT);
        msgList.add(msg3);
        Msg msg4=new Msg("《java》",Msg.TYPE_RECEIVED);
        msgList.add(msg4);
        Msg msg5=new Msg("《C语言》",Msg.TYPE_SENT);
        msgList.add(msg5);
        Msg msg6=new Msg("《Android》",Msg.TYPE_RECEIVED);
        msgList.add(msg6);
        Msg msg7=new Msg("《形式与政策》",Msg.TYPE_SENT);
        msgList.add(msg7);
        Msg msg8=new Msg("《中国近代史》",Msg.TYPE_RECEIVED);
        msgList.add(msg8);
        Msg msg9=new Msg("《大学生心理健康教育》",Msg.TYPE_SENT);
        msgList.add(msg9);
        Msg msg10=new Msg("《职业规划》",Msg.TYPE_RECEIVED);
        msgList.add(msg10);
    }
}
