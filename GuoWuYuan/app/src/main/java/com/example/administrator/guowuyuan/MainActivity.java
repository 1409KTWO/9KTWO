package com.example.administrator.guowuyuan;

import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.MainThread;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.administrator.guowuyuan.fragment.GuoWuYuan;
import com.example.administrator.guowuyuan.fragment.ShouYe;
import com.example.administrator.guowuyuan.fragment.ZhengWu;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    @Bind(R.id.fl)
    FrameLayout fl;
    @Bind(R.id.tab_image1)
    RadioButton tabImage1;
    @Bind(R.id.tab_image2)
    RadioButton tabImage2;
    @Bind(R.id.tab_image3)
    RadioButton tabImage3;

    private ShouYe shouYe;
    private GuoWuYuan guoWuYuan;
    private ZhengWu zhengWu;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        shouYe = new ShouYe();
        guoWuYuan = new GuoWuYuan();
        zhengWu = new ZhengWu();

        tabImage1.setOnClickListener(this);
        tabImage2.setOnClickListener(this);
        tabImage3.setOnClickListener(this);


        ft.add(R.id.fl, shouYe);
        ft.add(R.id.fl, guoWuYuan);
        ft.add(R.id.fl, zhengWu);

        ft.show(shouYe).hide(guoWuYuan).hide(zhengWu);
        ft.commit();
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction ft = fm.beginTransaction();
        switch (v.getId()) {
            case R.id.tab_image1:

                ft.hide(guoWuYuan).hide(zhengWu).show(shouYe);
                ft.commit();
                break;
            case R.id.tab_image2:
                ft.hide(zhengWu).hide(shouYe).show(guoWuYuan);
                ft.commit();
                break;
            case R.id.tab_image3:
                ft.hide(guoWuYuan).hide(shouYe).show(zhengWu);
                ft.commit();
                break;

        }
    }
}
