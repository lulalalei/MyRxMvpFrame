package com.demo.myrxmvpframe.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo.myrxmvpframe.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**自定义底部导航条
 * Created by Administrator on 2017/7/26.
 */

public class BottomBar extends LinearLayout implements View.OnClickListener{

    private Context mContext;

    private ChangeListener listener;

    private int currentTab = -1;

    @BindView(R.id.tab1)
    LinearLayout tab1;

    @BindView(R.id.tab2)
    LinearLayout tab2;

    @BindView(R.id.tab3)
    LinearLayout tab3;

    @BindView(R.id.ivTab1)
    ImageView ivTab1;
    @BindView(R.id.tvTab1)
    TextView tvTab1;


    @BindView(R.id.ivTab2)
    ImageView ivTab2;
    @BindView(R.id.tvTab2)
    TextView tvTab2;

    @BindView(R.id.ivTab3)
    ImageView ivTab3;
    @BindView(R.id.tvTab3)
    TextView tvTab3;

    public BottomBar(Context context) {
        this(context,null);
    }

    public BottomBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BottomBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext=context;
        initView();
    }

    private void initView() {
        LinearLayout bar = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.bottom_bar, null);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        addView(bar, lp);
        ButterKnife.bind(this);
        tab1.setOnClickListener(this);
        tab2.setOnClickListener(this);
        tab3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab1:
                changeTab(0);
                break;
            case R.id.tab2:
                changeTab(1);
                break;
            case R.id.tab3:
                changeTab(2);
                break;

        }
    }

    private void setbottombcdefail() {
        ivTab1.setImageResource(R.mipmap.shouye_weixuanzhong);
        ivTab2.setImageResource(R.mipmap.shangcheng_weidianji);
        ivTab3.setImageResource(R.mipmap.my_weixuanzhong);
        tvTab1.setTextAppearance(mContext, R.style.TextAppear_Theme_A4_Size11);
        tvTab2.setTextAppearance(mContext, R.style.TextAppear_Theme_A4_Size11);
        tvTab3.setTextAppearance(mContext, R.style.TextAppear_Theme_A4_Size11);

    }


    public void changeTab(int tab) {
        if (currentTab != tab) {
            setbottombcdefail();
            switch (tab) {
                case 0:
                    ivTab1.setImageResource(R.mipmap.shouyexuanzhongzhuangtai);
                    tvTab1.setTextAppearance(mContext, R.style.TextAppear_Theme_A1_Size11);
                    break;
                case 1:
                    ivTab2.setImageResource(R.mipmap.shangcheng);
                    tvTab2.setTextAppearance(mContext, R.style.TextAppear_Theme_A1_Size11);
                    break;
                case 2:
                    ivTab3.setImageResource(R.mipmap.my);
                    tvTab3.setTextAppearance(mContext, R.style.TextAppear_Theme_A1_Size11);
                    break;
                default:
                    break;
            }
            if (listener != null) {
                listener.changeTab2(tab);
            }
            currentTab = tab;
        }
    }


    public interface ChangeListener {

        void changeTab2(int tab);

    }

    public ChangeListener getListener() {
        return listener;
    }

    public void setListener(ChangeListener listener) {
        this.listener = listener;
    }
}
