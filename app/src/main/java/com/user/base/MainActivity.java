package com.user.base;
import android.support.v4.app.FragmentManager;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.user.base.widget.NoScrollViewPager;
import butterknife.BindView;

public class MainActivity extends BaseActivity{

    @BindView(R.id.navigation_bar)
    BottomNavigationBar mBottomNavigationBar;
    @BindView(R.id.view_pager)
    NoScrollViewPager mViewPager;
    private BottomNavigationItem weatherItem;
    private BottomNavigationItem newsItem;
    private BottomNavigationItem mineItem;
    private BottomNavigationItem movieItem;
    private FragmentManager fm;
    private MainAdapter mainAdapter;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        fm = getSupportFragmentManager();
        mainAdapter = new MainAdapter(fm,mBottomNavigationBar,mViewPager);

        mBottomNavigationBar.clearAll();
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mBottomNavigationBar
                .setActiveColor(R.color.colorPrimaryDark)
                .setInActiveColor(R.color.color_999999);

        newsItem = new BottomNavigationItem(R.drawable.ic_library_books_black_24dp,getString(R.string.bar_news));
        weatherItem = new BottomNavigationItem(R.drawable.ic_wb_cloudy_black_24dp,getString(R.string.bar_weather));
        movieItem = new BottomNavigationItem(R.drawable.ic_movie_black_24dp,getString(R.string.bar_movie));
        mineItem = new BottomNavigationItem(R.drawable.ic_account_balance_black_24dp,getString(R.string.bar_mine));

        mainAdapter.addItem(newsItem,new NewsFragment());
        mainAdapter.addItem(weatherItem,new WeatherFragment());
        mainAdapter.addItem(movieItem,new MovieFragment());
        mainAdapter.addItem(mineItem,new MineFragment());
        mainAdapter.setFirstSelectedPosition(0);
        mainAdapter.initialise();
        mViewPager.setCurrentItem(0);




    }




}
