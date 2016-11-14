package com.example.administrator.tencenttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;

public class MainActivity extends AppCompatActivity {


    private TXCloudVideoView mPlayerView;
    private TXLivePlayer mLivePlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "http://ksdownhdl.jufan.tv/live/500273437.flv";


        mPlayerView = (TXCloudVideoView) findViewById(R.id.video_view);
        //创建player对象
        mLivePlayer = new TXLivePlayer(this);
        mLivePlayer.setPlayerView(mPlayerView);
        //硬件加速
        mLivePlayer.enableHardwareDecode(true);
        mLivePlayer.startPlay(url, TXLivePlayer.PLAY_TYPE_LIVE_FLV); //推荐FLV


        TXLivePlayConfig mPlayConfig = new TXLivePlayConfig();

        //自动模式
        mPlayConfig.setAutoAdjustCacheTime(true);
        mPlayConfig.setMinAutoAdjustCacheTime(1);
        mPlayConfig.setMaxAutoAdjustCacheTime(5);
        //充满屏幕
        mLivePlayer.setRenderMode(TXLiveConstants.RENDER_MODE_FULL_FILL_SCREEN);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mLivePlayer.stopPlay(true);
        mPlayerView.onDestroy();
    }
}
