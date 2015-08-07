package com.haibei.cameraRenderer;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.PixelFormat;
import android.opengl.GLSurfaceView;

/**
 * @author jizhen
 * 相当于与controller(mvc的c)交互的model-----其实不属于model
 */
public class RenderInterface {
	
	Context mContext;
	
	//mGlSurfaceView对象来自activity
	private GLSurfaceView mGlSurfaceView;
	//jzRenderer自己创建
	private JZRenderer mJzRenderer;
	
	public RenderInterface(Context context){
		if(!supportsOpenGLES2(context)){
			throw new IllegalStateException("OpenGL ES 2.0 is not supported on this phone.");
		}
		mContext = context;
		
		mJzRenderer = new JZRenderer();
	}
	
	private boolean supportsOpenGLES2(final Context context){
		final ActivityManager activityManager = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
		final ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
		return configurationInfo.reqGlEsVersion >= 0x20000;
	}
	
//	final ActivityManager activityManager = 
//		    (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
//		final ConfigurationInfo configurationInfo = 
//		    activityManager.getDeviceConfigurationInfo();
//		final boolean supportsEs2 = configurationInfo.reqGlEsVersion >= 0x20000;
//	public GPUImage(final Context context) {
	
//        if (!supportsOpenGLES2(context)) {
//            throw new IllegalStateException("OpenGL ES 2.0 is not supported on this phone.");
//        }
//
//        mContext = context;
//        mFilter = new GPUImageFilter();
//        mRenderer = new GPUImageRenderer(mFilter);
//    }
	public GLSurfaceView getGlSurfaceView() {
		return mGlSurfaceView;
	}
	public void setGlSurfaceView(GLSurfaceView mGlSurfaceView) {
		this.mGlSurfaceView = mGlSurfaceView;
		this.mGlSurfaceView.setEGLContextClientVersion(2);
		this.mGlSurfaceView.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
		this.mGlSurfaceView.getHolder().setFormat(PixelFormat.RGBA_8888);
		//这一步为必须的，否则mGlSurfaceView会崩溃
		this.mGlSurfaceView.setRenderer(mJzRenderer);
		this.mGlSurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
		this.mGlSurfaceView.requestRender();
	}
	public JZRenderer getJzRenderer() {
		return mJzRenderer;
	}
	public void setJzRenderer(JZRenderer jzRenderer) {
		this.mJzRenderer = jzRenderer;
	}
	
	
}
