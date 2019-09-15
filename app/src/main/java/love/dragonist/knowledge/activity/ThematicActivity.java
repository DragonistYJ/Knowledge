package love.dragonist.knowledge.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.MenuItem;

import love.dragonist.knowledge.R;
import love.dragonist.knowledge.fragment.BookFragment;
import love.dragonist.knowledge.fragment.DashBoardFragment;
import love.dragonist.knowledge.fragment.HomeFragment;
import love.dragonist.knowledge.fragment.MyFragment;

/**
 * 专题选择页的activity
 */
public class ThematicActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener, BookFragment.OnFragmentInteractionListener, DashBoardFragment.OnFragmentInteractionListener, MyFragment.OnFragmentInteractionListener {
    private HomeFragment homeFragment;
    private BookFragment bookFragment;
    private DashBoardFragment dashBoardFragment;
    private MyFragment myFragment;
    private BottomNavigationView navigationView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        //fragment切换
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            hideAllFragment(fragmentTransaction);

            int flag = 0; //判断是否重新渲染
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if (homeFragment == null) {
                        homeFragment = HomeFragment.newInstance("首页", String.valueOf(R.layout.fragment_home));
                        fragmentTransaction.add(R.id.frameLayout, homeFragment);
                    } else {
                        fragmentTransaction.show(homeFragment);
                    }
                    flag = 1;
                    break;
                case R.id.navigation_book:
                    if (bookFragment == null) {
                        bookFragment = BookFragment.newInstance("书本", String.valueOf(R.layout.fragment_book));
                        fragmentTransaction.add(R.id.frameLayout, bookFragment);
                    } else {
                        fragmentTransaction.show(bookFragment);
                    }
                    flag = 1;
                    break;
                case R.id.navigation_dashboard:
                    if (dashBoardFragment == null) {
                        dashBoardFragment = DashBoardFragment.newInstance("dashBoard", String.valueOf(R.layout.fragment_dash_board));
                        fragmentTransaction.add(R.id.frameLayout, dashBoardFragment);
                    } else {
                        fragmentTransaction.show(dashBoardFragment);
                    }
                    flag = 1;
                    break;
                case R.id.navigation_my:
                    if (myFragment == null) {
                        myFragment = MyFragment.newInstance("我的", String.valueOf(R.layout.fragment_my));
                        fragmentTransaction.add(R.id.frameLayout, myFragment);
                    } else {
                        fragmentTransaction.show(myFragment);
                    }
                    flag = 1;
                    break;
            }
            fragmentTransaction.commit();
            return flag == 1;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thematic);

        //底部按钮之间的切换监听
        navigationView = findViewById(R.id.nav_view);
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //显示默认的fragment_home页面
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        homeFragment = HomeFragment.newInstance("主页", String.valueOf(R.layout.fragment_home));
        fragmentTransaction.add(R.id.frameLayout, homeFragment).commit();

        init();
    }

    /**
     * 隐藏所有fragment
     *
     * @param fragmentTransaction
     */
    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
        if (homeFragment != null) fragmentTransaction.hide(homeFragment);
        if (bookFragment != null) fragmentTransaction.hide(bookFragment);
        if (dashBoardFragment != null) fragmentTransaction.hide(dashBoardFragment);
        if (myFragment != null) fragmentTransaction.hide(myFragment);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        String project = uri.toString();
        Log.e("project", project);
        startActivity(new Intent(ThematicActivity.this, ProjectMenuActivity.class).putExtra("project", project));
    }

    public void init() {

    }
}
