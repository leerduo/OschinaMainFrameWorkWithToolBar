package com.dystu.toolbar;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.ActionBar.LayoutParams;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public abstract class BaseActivity extends AppCompatActivity implements OnClickListener {

    protected LayoutInflater mInflater;
    private Toolbar mActionBar;
    private TextView mTvActionTitle;
    protected int getActionBarSize() {
        TypedValue typedValue = new TypedValue();
        int[] textSizeAttr = new int[]{R.attr.actionBarSize};
        int indexOfAttrTextSize = 0;
        TypedArray a = obtainStyledAttributes(typedValue.data, textSizeAttr);
        int actionBarSize = a.getDimensionPixelSize(indexOfAttrTextSize, -1);
        a.recycle();
        return actionBarSize;
    }


    protected void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!hasActionBar()) {
            supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        }
        onBeforeSetContentLayout();
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
        }
        mActionBar = (Toolbar) findViewById(R.id.actionBar);//getSupportActionBar();
        mInflater = getLayoutInflater();
        if (hasActionBar()) {
            initActionBar(mActionBar);
        }
        init(savedInstanceState);
    }


    protected void onBeforeSetContentLayout() {
    }

    protected boolean hasActionBar() {
        return true;
    }

    protected int getLayoutId() {
        return 0;
    }

    protected View inflateView(int resId) {
        return mInflater.inflate(resId, null);
    }

    protected int getActionBarTitle() {
        return R.string.app_name;
    }

    protected boolean hasBackButton() {
        return false;
    }

    protected int getActionBarCustomView() {
        return 0;
    }

    protected void init(Bundle savedInstanceState) {
        initStatusBar();
    }

    protected void initStatusBar() {
    }

    protected void initActionBar(Toolbar actionBar) {
        if (actionBar == null)
            return;
        setSupportActionBar(actionBar);
        if (hasBackButton()) {
            //actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            int layoutRes = getActionBarCustomView();
            if (layoutRes != 0) {
                View view = inflateView(layoutRes);
                Toolbar.LayoutParams params = new Toolbar.LayoutParams(LayoutParams.MATCH_PARENT,
                        LayoutParams.MATCH_PARENT);
                actionBar.addView(view, params);
            }

            int titleRes = getActionBarTitle();

            if (titleRes != 0) {
                actionBar.setTitle(titleRes);
            }

            actionBar.setNavigationIcon(R.drawable.actionbar_back_icon_normal);
            actionBar.setNavigationOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });

            actionBar.setPadding(0, 0, 0, 0);
        } else {
            int titleRes = getActionBarTitle();
            if (titleRes != 0) {
                actionBar.setTitle(titleRes);
                actionBar.setNavigationIcon(R.mipmap.ic_launcher);
            }
            actionBar.setPadding((int) dpToPixel(16), 0, 0, 0);
        }

        startSupportActionMode(new ActionModeCallback());
    }
    private  int dpToPixel(float dipValue){
        float density = this.getResources().getDisplayMetrics().density;
        int pixValue = (int) (dipValue*density+0.5f);
        return pixValue;
    }


    public void setActionBarTitle(int resId) {
        if (resId != 0) {
            setActionBarTitle(getString(resId));
        }
    }

    public void setActionBarTitle(String title) {
        if (hasActionBar()) {
            if (mTvActionTitle != null) {
                mTvActionTitle.setText(title);
            }
            if (mActionBar != null) {
                mActionBar.setTitle(title);
            }
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
    }



    protected int getScreenHeight() {
        return findViewById(android.R.id.content).getHeight();
    }

    class ActionModeCallback implements ActionMode.Callback {

        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {

            return false;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {

        }
    }
}