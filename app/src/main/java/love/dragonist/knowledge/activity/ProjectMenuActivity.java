package love.dragonist.knowledge.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import love.dragonist.knowledge.R;

public class ProjectMenuActivity extends AppCompatActivity {
    private ImageButton btnBack;
    private TextView textProject;
    private ImageView imgKnowledgePoint;

    private String project;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_menu);

        //获取前面传过来的数据
        Intent intent = getIntent();
        project = intent.getStringExtra("project");

        //设置标题
        textProject = findViewById(R.id.projectTitle);
        textProject.setText(project);

        //返回按钮
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //跳转到知识点
        imgKnowledgePoint = findViewById(R.id.img_knowledge_point);
        imgKnowledgePoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProjectMenuActivity.this, MenuActivity.class).putExtra("project", project));
            }
        });
    }
}
