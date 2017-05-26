package com.veryworks.android.memo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.veryworks.android.memo.util.FileUtil;

public class DetailActivity extends AppCompatActivity {

    String title = "메모 제목";
    String content = "메모 내용~~ ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.parseColor("#ffff33")); //제목의 칼라
        toolbar.setNavigationIcon(R.mipmap.ic_launcher); //제목앞에 아이콘 넣기
        toolbar.setTitle( "타이틀 제목" );
        toolbar.setSubtitle( "부제목" ); //서브타이틀
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        // 메모 저장
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });

        fab.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                read();
                return true;
            }
        });
    }

    // 파일 읽어오기
    private void read(){
        String content = FileUtil.read(this,"memo000001.txt");
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }

    // 파일 저장
    private void save(){
        FileUtil.write(this,"memo000001.txt",content);
    }

    // 작성된 menu.xml 파일을 실제 메뉴로 화면에 등록
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // 메뉴가 클릭됬을때 호출되는 함수
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_bt1: show("버튼1이 클릭되었습니다"); break;
            case R.id.action_bt2: show("버튼2이 클릭되었습니다"); break;
            case R.id.action_bt3: show("버튼3이 클릭되었습니다"); break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void show(String msg){
        Toast.makeText(DetailActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
}
