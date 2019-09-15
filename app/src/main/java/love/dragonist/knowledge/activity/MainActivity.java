package love.dragonist.knowledge.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import love.dragonist.knowledge.R;
import love.dragonist.knowledge.adapter.SlideViewAdapter;
import love.dragonist.knowledge.bean.KnowledgeCard;
import love.dragonist.knowledge.gesture.KnowledgeCardItemTouchHelperCallback;
import love.dragonist.knowledge.gesture.OnSwipeListener;
import love.dragonist.knowledge.manager.SlideViewManager;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recSlide;
    private ImageButton btnIndex2Main;
    private SlideViewAdapter slideViewAdapter;
    private SlideViewManager slideViewManager;

    private ArrayList<KnowledgeCard> knowledgeCards = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recSlide = findViewById(R.id.slide);
        slideViewAdapter = new SlideViewAdapter(knowledgeCards);
        initData();
        recSlide.setAdapter(slideViewAdapter);

        KnowledgeCardItemTouchHelperCallback cardCallBack = new KnowledgeCardItemTouchHelperCallback(recSlide.getAdapter(), knowledgeCards);
        cardCallBack.setMListener(new OnSwipeListener() {
            @Override
            public void onSwiping(RecyclerView.ViewHolder viewHolder, float ratio, int direction) {
                SlideViewAdapter.SlideHolder slideHolder = (SlideViewAdapter.SlideHolder) viewHolder;
                slideHolder.itemView.setAlpha(1 - Math.abs(ratio) * 0.2f);
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, Object o, int direction) {
                SlideViewAdapter.SlideHolder slideHolder = (SlideViewAdapter.SlideHolder) viewHolder;
                viewHolder.itemView.setAlpha(1f);
            }

            @Override
            public void onSwipedClear() {
                recSlide.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        initData();
                        recSlide.getAdapter().notifyDataSetChanged();
                    }
                }, 0);
            }
        });
        ItemTouchHelper touchHelper = new ItemTouchHelper(cardCallBack);

        slideViewManager = new SlideViewManager(recSlide, touchHelper);
        recSlide.setLayoutManager(slideViewManager);
        touchHelper.attachToRecyclerView(recSlide);

        btnIndex2Main = findViewById(R.id.btnIndex2Main);
        btnIndex2Main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ThematicActivity.class));
            }
        });
    }

    /**
     * 从服务器获取数据
     * 现在是本地制造的数据
     */
    private void initData() {
        knowledgeCards.add(new KnowledgeCard("必修一", "01 集合", "集合的概念", "1fgsfdgfdsgsdfgsdf1fgsfdgfdsgsdfgsdf1fgsfdgfdsgsdfgsdf1fgsfdgfdsgsdfgsdf1fgsfdgfdsgsdfgsdf1fgsfdgfdsgsdfgsdf1fgsfdgfdsgsdfgsdf1fgsfdgfdsgsdfgsdf1fgsfdgfdsgsdfgsdf1fgsfdgfdsgsdfgsdf1fgsfdgfdsgsdfgsdf1fgsfdgfdsgsdfgsdf1fgsfdgfdsgsdfgsdf1fgsfdgfdsgsdfgsdf1fgsfdgfdsgsdfgsdf1fgsfdgfdsgsdfgsdf1fgsfdgfdsgsdfgsdf1fgsfdgfdsgsdfgsdf1fgsfdgfdsgsdfgsdf1fgsfdgfdsgsdfgsdf"));
        knowledgeCards.add(new KnowledgeCard("必修二", "02 函数", "函数的概念", "1"));
        knowledgeCards.add(new KnowledgeCard("必修三", "03 二次函数", "解函数", "1"));
        knowledgeCards.add(new KnowledgeCard("必修四", "04 统计学", "统计的概念", "1"));
    }
}
