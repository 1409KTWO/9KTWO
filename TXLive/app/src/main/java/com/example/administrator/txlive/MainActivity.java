package com.example.administrator.txlive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;

public class MainActivity extends AppCompatActivity {

    private TXCloudVideoView mPlayerView;
    private TXLivePlayer mLivePlayer;
    private String url = "http://ksdownhdl.jufan.tv/live/500105395.flv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayerView = (TXCloudVideoView) findViewById(R.id.video_view);
        //得到Player对象
        mLivePlayer = new TXLivePlayer(this);
        mLivePlayer.setPlayerView(mPlayerView);


        //硬件加速
        mLivePlayer.enableHardwareDecode(true);
        mLivePlayer.startPlay(url, TXLivePlayer.PLAY_TYPE_LIVE_FLV); //推荐FLV
        //充满全屏
        mLivePlayer.setRenderMode(TXLiveConstants.RENDER_MODE_FULL_FILL_SCREEN);
        TXLivePlayConfig mPlayConfig = new TXLivePlayConfig();

//自动模式
        mPlayConfig.setAutoAdjustCacheTime(true);
        mPlayConfig.setMinAutoAdjustCacheTime(1);
        mPlayConfig.setMaxAutoAdjustCacheTime(5);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mLivePlayer.stopPlay(true);
        mPlayerView.onDestroy();
    }

}
