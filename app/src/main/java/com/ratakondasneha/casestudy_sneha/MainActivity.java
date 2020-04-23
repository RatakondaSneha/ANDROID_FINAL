package com.ratakondasneha.casestudy_sneha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.ratakondasneha.casestudy_sneha.R;
import com.ratakondasneha.casestudy_sneha.api.LifeQuotesServiceGenerator;
import com.ratakondasneha.casestudy_sneha.fragments.QuotesAdapter;
import com.ratakondasneha.casestudy_sneha.model.LifeQuotesList;
import com.ratakondasneha.casestudy_sneha.views.LifeQuotesAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private LifeQuotesAdapter adapter;
    private LifeQuotesList lifeQuotesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Added viewpager and Main adapter
        ViewPager myView = findViewById(R.id.vewPager);
        QuotesAdapter myAdapter = new QuotesAdapter(
                getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        );

        //Linking main adapter and view pager
        myView.setAdapter(myAdapter);
    }
}
