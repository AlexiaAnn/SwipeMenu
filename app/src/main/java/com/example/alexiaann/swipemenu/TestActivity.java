package com.example.alexiaann.swipemenu;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.alexiaann.swipemenu.Adapter.CustomRecycleViewAdapter;
import com.example.alexiaann.swipemenu.swipemenu.view.SwipeMenu;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;

    @Bind(R.id.main_swipemenu)
    SwipeMenu mMainSwipemenu;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    private int mStyleCode = 11111; //风格代码
    private int mScaleProgress = 0; //起始缩放程度
    private int mAlphaProgress = 0; //起始透明程度
    private int mAngleProgress = 0; //起始3D旋转角度

    private int mTransCode = 1; //移动动画代码
    private int mScaleCode = 1; //缩放动画代码
    private int mAlphaCode = 1; //透明度动画代码
    private int mRotateCode = 1; //旋转动画代码

    private List<String> lists;
    private CustomRecycleViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        ButterKnife.bind(this);
        Log.i("log", "sadfasdfasd");

        mContext = this;
        initSwipeMenu();
        initRecycle();
    }

    /*
    * 初始化recyclerView
    * 数据
    * 适配器
    * 显示方式
    * */
    private void initRecycle() {

        lists = new ArrayList<String>();
        for (int i =0;i < 100;i++){
            lists.add(String.valueOf(i));
        }

        adapter = new CustomRecycleViewAdapter(mContext,lists);
        recyclerView.setAdapter(adapter);

//        recyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
//        recyclerView.setLayoutManager(new GridLayoutManager(mContext,5));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(5,StaggeredGridLayoutManager.HORIZONTAL));

//        recyclerView.addItemDecoration(new DividerItemDecoration(mContext,DividerItemDecoration.VERTICAL_LIST));
    }


    /*
    * 初始化SwipeMenu
    * */
    public void initSwipeMenu() {
        setBlur(3);
        initTranslate(3);
        initScale(2, 50);
        initAlpha(2, 50);
        initRotate(3, 50);
        changeStyleCode();
    }

    /*
    * 设置左侧边栏背景模糊效果
    * 1...背景模糊
    * 2...动态模糊
    * 3...反向动态模糊
    * 4...设置模糊并全局沉浸
    * 5...背景纯色,无背景图片
    * default...设置模糊并全局沉浸
    * */

    public void setBlur(int styleId) {
        alert(styleId + "");
        switch (styleId) {
            case 1:
                mMainSwipemenu.setBlur(TestActivity.this, R.mipmap.dayu, R.color.colorPrimary, 22f);
                break;
            case 2:
                mMainSwipemenu.setChangedBlur(TestActivity.this, R.mipmap.dayu, R.color.colorPrimary);
                break;
            case 3:
                mMainSwipemenu.setReverseChangedBlur(TestActivity.this, R.mipmap.dayu, R.color.colorPrimary);
                break;
            case 4:
                mMainSwipemenu.setBackImage(TestActivity.this, R.mipmap.dayu, R.color.colorPrimary);
                break;
            case 5:
                mMainSwipemenu.setFullColor(TestActivity.this, R.color.colorPrimary);
                break;
            default:
                mMainSwipemenu.setBackImage(TestActivity.this, R.mipmap.dayu, R.color.colorPrimary);
                break;
        }
    }


    /*
    * 设置侧边栏移动动画
    * 1...固定位置
    * 2...跟随动画
    * 3...视差移动
    * */
    private void initTranslate(int translateId) {
        switch (translateId) {
            case 1:
                mTransCode = 1;
                break;
            case 2:
                mTransCode = 2;
                break;
            case 3:
                mTransCode = 3;
                break;
        }
    }

    /*
    * 设置侧边栏缩放动画
    * 1...无缩放动画
    * 2...有缩放动画
    * 变化范围0~0.8,scaleRange范围0~80
    * */
    private void initScale(int scaleMode, int scaleRange) {
        switch (scaleMode) {
            case 1:
                mScaleCode = 1;
                break;
            case 2:
                mScaleCode = 2;
        }
        changeStyleCode();
        mScaleProgress = scaleRange;
        mMainSwipemenu.setStartScale(scaleRange * 1.0f / 100);
    }

    /*
    * 设置侧边栏透明动画
    * 1...无缩放动画
    * 2...有缩放动画
    * 变化范围0~0.8,alphaRange0~80
    * */
    private void initAlpha(int alphaMode, int alphaRange) {

        switch (alphaMode) {
            case 1:
                mAlphaCode = 1;
                break;
            case 2:
                mAlphaCode = 2;
        }
        changeStyleCode();
        mAlphaProgress = alphaRange;
        mMainSwipemenu.setStartAlpha(alphaRange * 1.0f / 100);
    }

    /*
    * 设置侧边栏旋转动画
    * 1...不旋转
    * 2...中心旋转
    * 3...左3d旋转
    * 4...旋转效果1
    * 5...旋转效果2
    * 6...旋转效果3
    * 变化范围0~0.8,rotateRange~80
    * */
    private void initRotate(final int rotateMode, int rotateRange) {
        switch (rotateMode) {
            case 1:
                mRotateCode = 1;
                break;
            case 2:
                mRotateCode = 2;
                break;
            case 3:
                mRotateCode = 3;
                break;
            case 4:
                mRotateCode = 4;
                break;
            case 5:
                mRotateCode = 5;
                break;
            case 6:
                mRotateCode = 6;
                break;
            default:
                break;
        }

        changeStyleCode();
        mAngleProgress = rotateRange;
        mMainSwipemenu.setStart3DAngle((int) (rotateRange * 1.0f / 100 * 90));
    }

    /*
    * 更新SwipeMenu风格
    * */
    public void changeStyleCode() {
        mStyleCode = mTransCode * 1000 + mScaleCode * 100 + mAlphaCode * 10 + mRotateCode;
        mMainSwipemenu.setStyleCode(mStyleCode);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_btn_menu:
                if (mMainSwipemenu.isMenuShowing()) {
                    mMainSwipemenu.hideMenu();
                } else {
                    mMainSwipemenu.showMenu();
                }
                break;
        }
    }

    public void alert(String str) {
        Toast.makeText(TestActivity.this, str, Toast.LENGTH_SHORT).show();
    }

    public void log(String str) {
        Log.i("log", str);
    }
}






