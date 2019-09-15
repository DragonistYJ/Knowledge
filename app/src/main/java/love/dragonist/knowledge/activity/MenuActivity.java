package love.dragonist.knowledge.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.navigation.fragment.NavHostFragment;

import love.dragonist.knowledge.R;
import love.dragonist.knowledge.fragment.BookMenuFragment;
import love.dragonist.knowledge.fragment.ChapterMenuFragment;
import love.dragonist.knowledge.fragment.ContentFragment;

public class MenuActivity extends AppCompatActivity implements BookMenuFragment.OnFragmentInteractionListener, ChapterMenuFragment.OnFragmentInteractionListener, ContentFragment.OnFragmentInteractionListener {
    private String project;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();
        project = intent.getStringExtra("project");

    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavHostFragment.findNavController(getSupportFragmentManager().findFragmentById(R.id.fragment)).navigateUp();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        String result = String.valueOf(uri);
        if (result.equals("finish")) finish();
    }
}
