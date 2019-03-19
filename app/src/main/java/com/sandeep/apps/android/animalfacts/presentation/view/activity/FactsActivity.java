package com.sandeep.apps.android.animalfacts.presentation.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.sandeep.apps.android.animalfacts.R;
import com.sandeep.apps.android.animalfacts.domain.Fact;
import com.sandeep.apps.android.animalfacts.presentation.presenter.FactsActivityPresenter;
import com.sandeep.apps.android.animalfacts.presentation.presenter.FactsActivityPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FactsActivity extends AppCompatActivity implements FactsActivityPresenter.View {

    @BindView(R.id.txt_fact)
    TextView txtFact;

    private Unbinder unbinder;
    private FactsActivityPresenter mainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        mainActivityPresenter = new FactsActivityPresenterImpl();

        mainActivityPresenter.fetchFacts(this);
    }

    @Override
    public void onFactFetched(Fact fact) {
        Toast.makeText(this, fact.getText(), Toast.LENGTH_LONG).show();
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