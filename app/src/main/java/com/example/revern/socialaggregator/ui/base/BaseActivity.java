package com.example.revern.socialaggregator.ui.base;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.revern.socialaggregator.R2;
import com.example.revern.socialaggregator.utils.Keyboard;

import javax.inject.Inject;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity
        implements BaseView {

    @BindView(R2.id.toolbar)
    Toolbar toolbar;

    @Inject
    protected P presenter;

    protected UiInfo uiInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        inject();

        super.onCreate(savedInstanceState);
        setContentView(getUiInfo().getLayoutRes());

        if (getIntent() != null && getIntent().getExtras() != null) {
            parseArguments(getIntent().getExtras());
        }

        if (toolbar != null) {
            setToolbar(toolbar);
        }

        if (savedInstanceState != null) {
            restoreState(savedInstanceState);
        }
    }

    @Override protected void onStart() {
        super.onStart();
        presenter.attach(this);
    }

    @Override protected void onStop() {
        presenter.detach();
        super.onStop();
    }

    protected void parseArguments(@NonNull Bundle extras) {
    }

    protected void restoreState(@NonNull Bundle savedState) {
    }

    @Override public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    protected void setToolbar(@NonNull Toolbar toolbar) {
        setSupportActionBar(toolbar);
        if (uiInfo.getTitleRes() != 0) {
            setTitle(uiInfo.getTitleRes());
        } else if (uiInfo.getTitle() != null) {
            setTitle(uiInfo.getTitle());
        }
        if (uiInfo.hasBackButton() && getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        if (uiInfo.getMenuRes() != 0) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(uiInfo.getMenuRes(), menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home && uiInfo.hasBackButton()) {
            Keyboard.hide(this);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override public void hideKeyboard() {
        Keyboard.hide(this);
    }

    @Override public void showError(Throwable error) {
        Toast.makeText(this, error.getMessage(), Toast.LENGTH_LONG).show();
    }

    protected UiInfo getUiInfo() {
        if (uiInfo == null) {
            uiInfo = createUiInfo();
        }
        return uiInfo;
    }

    protected abstract UiInfo createUiInfo();

    protected abstract void inject();

}
