package com.xproject.videoplus;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

public class Streamer implements PreviewCallback {
    private static final String TAG = "Streamer";
    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;
    public static final int FRAME_RATE = 15;
    
    private boolean mIsStarted;
    private byte[] mData;
	private static Handler mHandler;
	private boolean isSnapShot = false;
	final static int EventCode = 1;
	static Context mContext = null;

	public void Init(Context context) {
		init(new WeakReference<Streamer>(this));
		
		mContext = context;
		
	    mHandler = new Handler(){
				public void handleMessage(Message msg) {
					switch (msg.what)
					{
					case EventCode:
						try {						
							String mystr= (String) msg.obj;            	   
							if (mystr.contains("snapshot")) {
								isSnapShot = true;
								Log.i(TAG, "snapshot");
							}
							else if (mystr.contains("CreateRtspServerFail")) {
								Log.i(TAG, "Create Rtsp Server Fail!");
						 		
								if(null != mContext) {
						 			Toast.makeText(mContext, "RTSP����������ʧ�ܣ�",Toast.LENGTH_SHORT).show();
						 		}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					default:
						break;
					}
				}
			};
	}
    
	private static void EventCallback(String strx){
		Message m = mHandler.obtainMessage(EventCode, 0, 0, strx);
		mHandler.sendMessage(m);
	}

	/**
	 * @����:	�����ļ��ķ�ʽ
	 * @������ Start
	 * @param addr
	 * @param filename
	 * @return void
	 * @author MinJie.Yu
	 * @����ʱ�� 2015-10-22����6:06:05
	 * @�޸��� MinJie.Yu
	 * @�޸�ʱ�� 2015-10-22����6:06:05
	 * @�޸ı�ע
	 * @since
	 * @throws
	 */
    public void Start(final String addr, final String filename) {
        start(filename, WIDTH, HEIGHT, FRAME_RATE);
        mIsStarted = true;
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                loop(addr);
            }
        }).start();
    }
    
    /**
     * @����:
     * @������ Record
     * @param filename
     * @return void
     * @author MinJie.Yu
     * @����ʱ�� 2015-10-23����5:26:10
     * @�޸��� MinJie.Yu
     * @�޸�ʱ�� 2015-10-23����5:26:10
     * @�޸ı�ע
     * @since
     * @throws
     */
    public void Record(final String filename) {
 		if(null != mContext) {
 			Toast.makeText(mContext, "��Ƶ¼��Ϊ: " + filename,  Toast.LENGTH_SHORT).show();
 		}
        start(filename, WIDTH, HEIGHT, FRAME_RATE);
        mIsStarted = true;
    }

    /**
     * @����:
     * @������ Stop
     * @return void
     * @author MinJie.Yu
     * @����ʱ�� 2015-10-23����5:26:30
     * @�޸��� MinJie.Yu
     * @�޸�ʱ�� 2015-10-23����5:26:30
     * @�޸ı�ע
     * @since
     * @throws
     */
    public void Stop() {
        mIsStarted = false;
        stop();
    }

    /**
     * @����:
     * @������ SnapShot
     * @return void
     * @author MinJie.Yu
     * @����ʱ�� 2015-10-23����5:26:36
     * @�޸��� MinJie.Yu
     * @�޸�ʱ�� 2015-10-23����5:26:36
     * @�޸ı�ע
     * @since
     * @throws
     */
    public void SnapShot() {
        snapshot();
    }
    
    /**
     * @����:
     * @������ Live
     * @param addr
     * @return void
     * @author MinJie.Yu
     * @����ʱ�� 2015-10-23����5:26:48
     * @�޸��� MinJie.Yu
     * @�޸�ʱ�� 2015-10-23����5:26:48
     * @�޸ı�ע
     * @since
     * @throws
     */
    public void Live(final String addr) {
        start("live", WIDTH, HEIGHT, FRAME_RATE);
        mIsStarted = true;
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                live(addr);
            }
        }).start();
    }
    
    public boolean isStarted() {
        return mIsStarted;
    }

    public int frameCount = 0;
    public long lastTimestamp = System.currentTimeMillis();
    
    @Override
    public void onPreviewFrame(byte[] data, Camera camera) {
        if (mIsStarted) {
        	encode(data);
        }
        
        if(true == isSnapShot) {
        	String fileName = "IMG_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()).toString() + ".jpg";
	 		File sdRoot = Environment.getExternalStorageDirectory();
	 		String dir = "/VideoPlus/";
	 		File mkDir = new File(sdRoot, dir);
	 		if (!mkDir.exists())
	 			mkDir.mkdirs();
	 		
	 		if(null != mContext) {
	 			Toast.makeText(mContext, "��ͼ����Ϊ: " + fileName,  Toast.LENGTH_SHORT).show();
	 		}
	 		
	 		File pictureFile = new File(sdRoot, dir + fileName);
	 		if (!pictureFile.exists()) {
	 			try {
	 				pictureFile.createNewFile();
	 				Camera.Parameters parameters = camera.getParameters();
	 				Size size = parameters.getPreviewSize();
	 				YuvImage image = new YuvImage(data,
	 						parameters.getPreviewFormat(), size.width, size.height,
	 						null);
	 				FileOutputStream filecon = new FileOutputStream(pictureFile);
	 				image.compressToJpeg(new Rect(0, 0, image.getWidth(), image.getHeight()), 90, filecon);
	 	        	isSnapShot = false;
	 			} catch (IOException e) {
	 				e.printStackTrace();
	 			}
	 		}
        }
        
        /*frameCount++;
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastTimestamp > 1000) {
            lastTimestamp = currentTime;
            Log.d(TAG, "onPreviewFrame() frames=" + frameCount + ", bytes=" + data.length);
            frameCount = 0;
        }*/
    }
    
    /**
     *	JNI���ؽӿ�
     */
    private native void init(Object weak_this);
    private native void start(String filename, int width, int height, int frameRate);
    private native void stop();
    private native void snapshot();
    private native int encode(byte[] data);
    private native int loop(String addr);
    private native int live(String addr);
}
