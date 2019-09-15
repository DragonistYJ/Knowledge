package love.dragonist.knowledge.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import love.dragonist.knowledge.R;
import love.dragonist.knowledge.bean.KnowledgeCard;

public class SlideViewAdapter extends RecyclerView.Adapter<SlideViewAdapter.SlideHolder> {
    private ArrayList<KnowledgeCard> knowledgeCards;

    public SlideViewAdapter(ArrayList<KnowledgeCard> knowledgeCards) {
        this.knowledgeCards = knowledgeCards;
    }

    @NonNull
    @Override
    public SlideHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new SlideHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_knowledge_card, viewGroup, false));
    }

    //设置布局中元素的内容
    @Override
    public void onBindViewHolder(@NonNull SlideHolder slideHolder, int i) {
        slideHolder.textBook.setText(knowledgeCards.get(i).getBook());
        slideHolder.textChapter.setText(knowledgeCards.get(i).getChapter());
        slideHolder.textTitle.setText(knowledgeCards.get(i).getTitle());
        slideHolder.textContent.setText(knowledgeCards.get(i).getContent());
    }

    @Override
    public int getItemCount() {
        return knowledgeCards == null ? 0 : knowledgeCards.size();
    }

    //获取布局中的元素
    public class SlideHolder extends RecyclerView.ViewHolder {
        private TextView textBook;
        private TextView textChapter;
        private TextView textContent;
        private TextView textTitle;

        public SlideHolder(@NonNull View itemView) {
            super(itemView);
            textBook = itemView.findViewById(R.id.item_knowledge_card_book);
            textChapter = itemView.findViewById(R.id.item_knowledge_card_chapter);
            textTitle = itemView.findViewById(R.id.item_knowledge_card_title);
            textContent = itemView.findViewById(R.id.item_knowledge_card_content);
        }
    }
}
