package com.sky.dailymovie;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.sky.dailymovie.data.model.Category;
import com.sky.dailymovie.http.DefaultHttpMethod;
import com.sky.dailymovie.http.NoCompleteObserver;
import com.sky.dailymovie.ui.main.MainFragment;
import com.sky.dailymovie.ui.main.PagerAdapter;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.WrapPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity implements
        MainFragment.OnFragmentInteractionListener {

    private static final String TAG = "MainActivity";

    @BindView(R.id.magic_indicator)
    MagicIndicator mIndicator;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    private List<String> mTitles;
    private ArrayList<Fragment> mFragments;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initData();

        initFragment();

        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mTitles.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                SimplePagerTitleView titleView = new SimplePagerTitleView(MainActivity.this);
                titleView.setText(mTitles.get(index));
                titleView.setNormalColor(Color.parseColor("#333333"));
                titleView.setSelectedColor(Color.parseColor("#e94220"));
                titleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mViewPager.setCurrentItem(index);
                    }
                });
                return titleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                WrapPagerIndicator indicator = new WrapPagerIndicator(context);
                indicator.setFillColor(Color.parseColor("#ebe4e3"));
                return indicator;
            }
        });
        mIndicator.setNavigator(commonNavigator);
        mPagerAdapter = new PagerAdapter(getSupportFragmentManager(), mFragments, mTitles);
        mViewPager.setAdapter(mPagerAdapter);
        ViewPagerHelper.bind(mIndicator, mViewPager);
    }

    private Disposable mDisposable = null;

    private void initData() {
//        mTitles = new String[]{"热门", "娱乐", "体育", "歌曲", "搞笑", "综艺", "科技", "教育", "自然"};
        mTitles = new ArrayList<>();
//        mTitles.add("热门");
//        mTitles.add("热门");
//        mTitles.add("热门");
//        mTitles.add("热门");
        NoCompleteObserver<List<Category>> observer = new NoCompleteObserver<List<Category>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mDisposable = d;
            }

            @Override
            public void onNext(@NonNull List<Category> categories) {
                Timber.d("onNext = " + categories);
                for (int i = 0; i < categories.size(); i++) {
                    final Category category = categories.get(i);
                    final String name = category.name();
                    Timber.d("category name = " + name);
                    mTitles.add(name);
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Timber.e("onError:" + e);
            }
        };

        /**
         * 将数据存入数据库
         */
        Consumer<List<Category>> consumer = new Consumer<List<Category>>() {
            @Override
            public void accept(@NonNull List<Category> categories) throws Exception {
                Timber.d("accept: " + categories);
            }
        };
        DefaultHttpMethod.getInstance().getCategories(observer);
    }

    private void initFragment() {
        mFragments = new ArrayList<>();
        for (String mTitle : mTitles) {
            mFragments.add(MainFragment.newInstance(mTitle, mTitle));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Timber.d("uri = " + uri);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDisposable != null && !mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }
}
