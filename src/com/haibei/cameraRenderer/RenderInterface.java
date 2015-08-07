package com.haibei.cameraRenderer;

import android.graphics.PixelFormat;
import android.opengl.GLSurfaceView;

/**
 * @author jizhen
 * 相当于与controller(mvc的c)交互的model-----其实不属于model
 */
public class RenderInterface {
	//glSurfaceView对象来自activity
	private GLSurfaceView glSurfaceView;
	//jzRenderer自己创建
	private JZRenderer jzRenderer;
	
	public RenderInterface(){
		jzRenderer = new JZRenderer();
	}
	
	
	public GLSurfaceView getGlSurfaceView() {
		return glSurfaceView;
	}
	public void setGlSurfaceView(GLSurfaceView glSurfaceView) {
		this.glSurfaceView = glSurfaceView;
		this.glSurfaceView.setEGLContextClientVersion(2);
		this.glSurfaceView.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
		this.glSurfaceView.getHolder().setFormat(PixelFormat.RGBA_8888);
		//这一步为必须的，否则glSurfaceView会崩溃
		this.glSurfaceView.setRenderer(jzRenderer);
		this.glSurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
		this.glSurfaceView.requestRender();
	}
	public JZRenderer getJzRenderer() {
		return jzRenderer;
	}
	public void setJzRenderer(JZRenderer jzRenderer) {
		this.jzRenderer = jzRenderer;
	}
	
	
}
