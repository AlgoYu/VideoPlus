
package com.xproject.videoplus;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

import com.xproject.util.FileUtil;
import com.xproject.util.ImageUtil;

/**
 * @������ 
 * @��Ŀ���� RTSPStreamer
 * @����  com.xproject.videoplus
 * @������ CameraPreview
 * @author MinJie.Yu
 * @����ʱ�� 2015-10-21����4:07:57
 * @�޸��� MinJie.Yu
 * @�޸�ʱ�� 2015-10-21����4:07:57
 * @�޸ı�ע 
 * @version v1.0
 * @see [nothing]
 */
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = "CameraPreview";

    private SurfaceHolder mHolder;
    private Camera mCamera;
    private Streamer mStreamer;
    private boolean isdoTakePicture = false;

    public CameraPreview(Context context, Camera camera, Streamer streamer) {
        super(context);
        mCamera = camera;
        mStreamer = streamer;

        // Install a SurfaceHolder.Callback so we get notified when the
        // underlying surface is created and destroyed.
        mHolder = getHolder();
        mHolder.addCallback(this);
        // deprecated setting, but required on Android versions prior to 3.0
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    public void surfaceCreated(SurfaceHolder holder) {
        // The Surface has been created, now tell the camera where to draw the
        // preview.
        try {
            mCamera.setPreviewDisplay(holder);
            mCamera.setPreviewCallback(mStreamer);
            mCamera.startPreview();
        } catch (IOException e) {
            Log.d(TAG, "Error setting camera preview: " + e.getMessage());
        }
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        // empty. Take care of releasing the Camera preview in your activity.
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
        // If your preview can change or rotate, take care of those events here.
        // Make sure to stop the preview before resizing or reformatting it.

        if (mHolder.getSurface() == null) {
            // preview surface does not exist
            return;
        }

        // stop preview before making changes
        try {
            mCamera.stopPreview();
        } catch (Exception e) {
            // ignore: tried to stop a non-existent preview
        }

        // set preview size and make any resize, rotate or
        // reformatting changes here

        // start preview with new settings
        try {
            mCamera.setPreviewDisplay(mHolder);
            mCamera.setPreviewCallback(mStreamer);
            mCamera.startPreview();

        } catch (Exception e) {
            Log.d(TAG, "Error starting camera preview: " + e.getMessage());
        }
    }
    
	/**
	 * ����
	 */
	public void doTakePicture(){
		if(mCamera != null) {
			isdoTakePicture = true;
			mCamera.takePicture(mShutterCallback, null, mJpegPictureCallback);
		}
	}

	/*Ϊ��ʵ�����յĿ������������ձ�����Ƭ��Ҫ���������ص�����*/
	ShutterCallback mShutterCallback = new ShutterCallback() {
		//���Ű��µĻص������������ǿ����������Ʋ��š����ꡱ��֮��Ĳ�����Ĭ�ϵľ������ꡣ
		public void onShutter() {
			Log.i(TAG, "myShutterCallback:onShutter...");
		}
	};
	
	//��jpegͼ�����ݵĻص�,����Ҫ��һ���ص�
	PictureCallback mJpegPictureCallback = new PictureCallback() {
		public void onPictureTaken(byte[] data, Camera camera) {
			if(true == isdoTakePicture) {
				Log.i(TAG, "myJpegCallback:onPictureTaken...");
				Bitmap b = null;
				if(null != data){
					b = BitmapFactory.decodeByteArray(data, 0, data.length);//data���ֽ����ݣ����������λͼ
					mCamera.stopPreview();
					isdoTakePicture = false;
				}
				
				//����ͼƬ��sdcard
				if(null != b)
				{
					//����FOCUS_MODE_CONTINUOUS_VIDEO)֮��myParam.set("rotation", 90)ʧЧ��
					//ͼƬ��Ȼ������ת�ˣ�������Ҫ��ת��
					Bitmap rotaBitmap = ImageUtil.getRotateBitmap(b, 90.0f);
					FileUtil.saveBitmap(rotaBitmap);
				}
				//�ٴν���Ԥ��
				mCamera.startPreview();
				isdoTakePicture = false;
			}
		}
	};
	
}
