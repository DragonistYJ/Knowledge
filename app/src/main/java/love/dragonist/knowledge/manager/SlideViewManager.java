package love.dragonist.knowledge.manager;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class SlideViewManager extends RecyclerView.LayoutManager {
    private RecyclerView mRecyclerView;
    private ItemTouchHelper mItemTouchHelper;

    public SlideViewManager(RecyclerView mRecyclerView, ItemTouchHelper mItemTouchHelper) {
        this.mRecyclerView = mRecyclerView;
        this.mItemTouchHelper = mItemTouchHelper;
    }

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);

        removeAllViews();
        detachAndScrapAttachedViews(recycler);

        int itemCount = getItemCount();

        if (itemCount > 3) {
            for (int position = 3; position >= 0; position--) {
                View view = recycler.getViewForPosition(position);
                addView(view);

                measureChildWithMargins(view, 0, 0);
                int widthSpace = getWidth() - getDecoratedMeasuredWidth(view);
                int heightSpace = getHeight() - getDecoratedMeasuredHeight(view);
                layoutDecoratedWithMargins(view, widthSpace / 2, heightSpace / 2, widthSpace / 2 + getDecoratedMeasuredWidth(view), heightSpace / 2 + getDecoratedMeasuredHeight(view));

                if (position == 3) {
                    view.setScaleX(1 - (position - 1) * 0.1f);
                    view.setScaleY(1 - (position - 1) * 0.1f);
                    view.setTranslationY(-(position - 1) * view.getMeasuredHeight() / 16);
                } else if (position > 0) {
                    view.setScaleX(1 - position * 0.1f);
                    view.setScaleY(1 - position * 0.1f);
                    view.setTranslationY(-position * view.getMeasuredHeight() / 16);
                } else {
                    view.setOnTouchListener(mOnTouchListener);
                }
            }
        } else {
            for (int position = itemCount - 1; position >= 0; position--) {
                final View view = recycler.getViewForPosition(position);
                addView(view);
                measureChildWithMargins(view, 0, 0);
                int widthSpace = getWidth() - getDecoratedMeasuredWidth(view);
                int heightSpace = getHeight() - getDecoratedMeasuredHeight(view);

                layoutDecoratedWithMargins(view, widthSpace / 2, heightSpace / 2,
                        widthSpace / 2 + getDecoratedMeasuredWidth(view),
                        heightSpace / 2 + getDecoratedMeasuredHeight(view));

                if (position > 0) {
                    view.setScaleX(1 - position * 0.1f);
                    view.setScaleY(1 - position * 0.1f);
                    view.setTranslationY(-position * view.getMeasuredHeight() / 16);
                } else {
                    view.setOnTouchListener(mOnTouchListener);
                }
            }
        }
    }

    private View.OnTouchListener mOnTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            RecyclerView.ViewHolder childViewHolder = mRecyclerView.getChildViewHolder(v);
            if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                mItemTouchHelper.startSwipe(childViewHolder);
            }
            return false;
        }
    };
}
