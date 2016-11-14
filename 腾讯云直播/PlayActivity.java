package com.example.ydy.activity;

import android.app.Activity;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;

import com.example.ydy.R;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;

public class PlayActivity extends Activity {
	private TXCloudVideoView mPlayerView;
	private TXLivePlayer mLivePlayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);
		String url = getIntent().getStringExtra("url");
		TXLivePlayConfig mPlayConfig = new TXLivePlayConfig();


        //流畅模式
		mPlayConfig.setAutoAdjustCacheTime(true);
		mPlayConfig.setMinAutoAdjustCacheTime(1);
		mPlayConfig.setMaxAutoAdjustCacheTime(5);
        mPlayerView = (TXCloudVideoView)findViewById(R.id.video_view);
        int[] sdkVer = TXLivePusher.getSDKVersion();
        mLivePlayer = new TXLivePlayer(this);
        mLivePlayer.setPlayerView(mPlayerView);
        mLivePlayer.enableHardwareDecode(true);
        mLivePlayer.startPlay(url, TXLivePlayer.PLAY_TYPE_LIVE_FLV);

        mLivePlayer.setRenderMode(TXLiveConstants.RENDER_MODE_FULL_FILL_SCREEN);
        mLivePlayer.setRenderRotation(0);
        mLivePlayer.setConfig(mPlayConfig);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		mLivePlayer.stopPlay(true);
		mLivePlayer=null;
		mPlayerView.destroyDrawingCache();
		mPlayerView.onDestroy();
		mPlayerView=null;
	}
}
