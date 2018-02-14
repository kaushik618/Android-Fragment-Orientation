package com.example.changeori;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ListFragment.ArticleListener{

    TextView tvDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDetails =(TextView)findViewById(R.id.tvDetails);

        if (findViewById(R.id.layout_default)!=null)
        {
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.detailfragment))
                    .show(manager.findFragmentById(R.id.listfragment))
                    .commit();
        }

        if (findViewById(R.id.layout_land)!=null)
        {
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailfragment))
                    .show(manager.findFragmentById(R.id.listfragment))
                    .commit();
        }
    }

    public void onArticleSelected(int index) {
        if (findViewById(R.id.layout_default)!=null)
        {
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.listfragment))
                    .show(manager.findFragmentById(R.id.detailfragment))
                    .addToBackStack(null)
                    .commit();
        }
        String [] News = getResources().getStringArray(R.array.News);
        tvDetails.setText(News[index]);



    }
}
