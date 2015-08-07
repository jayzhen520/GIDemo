package com.haibei.cameraRenderer;

import android.graphics.PixelFormat;
import android.opengl.GLSurfaceView;

/**
 * @author jizhen
 * �൱����controller(mvc��c)������model-----��ʵ������model
 */
public class RenderInterface {
	//glSurfaceView��������activity
	private GLSurfaceView glSurfaceView;
	//jzRenderer�Լ�����
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
		//��һ��Ϊ����ģ�����glSurfaceView�����
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
