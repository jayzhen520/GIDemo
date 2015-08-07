package com.haibei.jzgidemo;

import com.haibei.cameraRenderer.RenderInterface;

import android.graphics.PixelFormat;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CameraFragment extends Fragment {

	private RenderInterface ri;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		ri = new RenderInterface(getActivity());
	}



	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
//		return super.onCreateView(inflater, container, savedInstanceState);
		
		View v = inflater.inflate(R.layout.fragment_glsurfaceview, parent, false);
		
		ri.setGlSurfaceView((GLSurfaceView)v.findViewById(R.id.glsurfaceview));

		return v;
	}

	
	
}
