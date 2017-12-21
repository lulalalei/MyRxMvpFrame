package com.demo.myrxmvpframe.fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.demo.myrxmvpframe.R;
import com.demo.myrxmvpframe.bases.BaseFragment;
import com.demo.myrxmvpframe.beans.HeaderHelper;
import com.demo.myrxmvpframe.beans.LoginBean;
import com.demo.myrxmvpframe.constants.CommonConstants;
import com.demo.myrxmvpframe.m.MineModel;
import com.demo.myrxmvpframe.p.MinePresenter;
import com.demo.myrxmvpframe.utils.MD5Utils;
import com.demo.myrxmvpframe.utils.SPUtils;
import com.demo.myrxmvpframe.v.MineContract;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/10/27.
 */

public class MineFragment extends BaseFragment<MinePresenter,MineModel> implements MineContract.View,View.OnClickListener{

    @BindView(R.id.et_pwd)
    EditText et_pwd;
    @BindView(R.id.tv_login)
    TextView tv_login;

    @Override
    protected void initdata(Bundle savedInstanceState) {

    }

    @Override
    protected void initListener() {
        tv_login.setOnClickListener(this);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.tv_login:
                String header = HeaderHelper.getHeaderInfo();
                try {
                    String encode = URLEncoder.encode(et_pwd.getText().toString().trim(), "UTF-8");
                    Log.e("====encode===","====old===="+encode);
                    String decode = URLDecoder.decode(encode, "UTF-8");
                    Log.e("====encode===","====now===="+decode);
                    Log.e("====encode===","=====filter==="+filterName(et_pwd.getText().toString().trim()));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                /*showToast(filterName(et_pwd.getText().toString().trim()));
                if (et_pwd.getText().toString().trim().length()>32)
                {
                    Log.e("===substring====","========="+et_pwd.getText().toString().trim().substring(0,32)+
                            ",length:"+et_pwd.getText().toString().trim().length());
                }*/
                /*if (isNum(et_pwd.getText().toString().trim()))
                {
                    showToast("有效");
                }
                else
                {
                    showToast("无效");
                }*/
                mPresent.login(activity,this,"15735926343",
                        MD5Utils.MD5(et_pwd.getText().toString().trim()+ CommonConstants.SALT_KEY), header);
                break;
            default:
                break;
        }
    }

    @Override
    public void updateUserInfo(LoginBean bean) {
        SPUtils.put(mContext, "userId", bean.getUserId());
        SPUtils.put(mContext, "sessionId", bean.getSessionId());
    }

    public static String filterName(String name) {
        if (TextUtils.isEmpty(name)) {
            return "";
        } else {
            char[] chars = name.toCharArray();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < chars.length; i++) {
                if (isName(chars[i] + "")) {
                    sb.append(chars[i]);
                }
            }
            if (TextUtils.isEmpty(sb.toString())) {
                return "";
            } else {
                return sb.toString();
            }
        }
    }

    public static boolean isName(String str) {
        Pattern pattern = Pattern.compile("^[0-9a-zA-Z\\u4e00-\\u9fa5]$");
        Matcher isLetter = pattern.matcher(str);
        if (!isLetter.matches()) {
            return false;
        }
        return true;
    }

    public static boolean isNum(String str)
    {
        String num = "([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])";
        if (TextUtils.isEmpty(str)) {
            return false;
        } else {
            //matches():字符串是否在给定的正则表达式匹配
            return str.matches(num);
        }
    }

}
