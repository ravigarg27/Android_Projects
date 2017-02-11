package com.ravi.epac;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class ImageGallery extends Activity implements OnItemClickListener{
	private Gallery _gallery;
	private ImageAdapter _imageAdapter;
	private Integer[] mImageIds = {R.drawable.epac,R.drawable.first,R.drawable.two,R.drawable.image,R.drawable.four,R.drawable.five,
	};
	ImageView imageview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imagegallery);
		imageview = (ImageView) findViewById(R.id.ImageView01);
		_gallery = (Gallery) this.findViewById(R.id.gallery1);
		_imageAdapter = new ImageAdapter(this);
		_gallery.setAdapter(_imageAdapter);
		_gallery.setOnItemClickListener(this);

		imageview.setImageResource(mImageIds[0]);
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		
		
        imageview.setImageResource(mImageIds[arg2]);
	}
	
	public class ImageAdapter extends BaseAdapter {
	    int mGalleryItemBackground;
	    private Context mContext;
	    
	    public ImageAdapter(Context c) {
	        mContext = c;
	        TypedArray a = c.obtainStyledAttributes(R.styleable.HelloGallery);
	        mGalleryItemBackground = a.getResourceId(
	                R.styleable.HelloGallery_android_galleryItemBackground, 0);
	        a.recycle();
	    }

	    public int getCount() {
	        return mImageIds.length;
	    }

	    public Object getItem(int position) {
	        return position;
	    }

	    public long getItemId(int position) {
	        return position;
	    }

	    public View getView(int position, View convertView, ViewGroup parent) {
	        ImageView i = new ImageView(mContext);

	        i.setImageResource(mImageIds[position]);
	        i.setLayoutParams(new Gallery.LayoutParams(150, 100));
	        i.setScaleType(ImageView.ScaleType.FIT_XY);
	        i.setBackgroundResource(mGalleryItemBackground);

	        return i;
	    }
	}
}



