package com.sandeep.apps.android.animalfacts.facts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.sandeep.apps.android.animalfacts.R;
import com.sandeep.apps.android.animalfacts.facts.domain.entity.FactEntity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FactsActivity extends AppCompatActivity implements FactsContract.View {

    @BindView(R.id.txt_fact)
    TextView txtFact;

    private Unbinder unbinder;
    private FactsContract.Presenter mainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        mainActivityPresenter = new FactsActivityPresenter();

        mainActivityPresenter.fetchFacts(this);
    }

    @Override
    public void onFactFetched(FactEntity fact) {
        ((TextView)findViewById(R.id.txt_fact)).setText(fact.getText());
    }

    @Override
    public void onError(String message) {
        Toast.makeText(this, "something went wrong -> " + message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String message) {

    }
}