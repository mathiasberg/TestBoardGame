package se.dragonappdev.testboardgame;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
	private static final String TAG = "ImageAdapter";
	private Context mContext;

	public ImageAdapter(Context c) {
		mContext = c;
	}

	public int getCount() {
		return mThumbIds.length;
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}

	// create a new ImageView for each item referenced by the Adapter
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		if (convertView == null) {  // if it's not recycled, initialize some attributes
			imageView = new ImageView(mContext);
			//imageView.setLayoutParams(new GridView.LayoutParams(100, 100));
			//imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(5, 5, 5, 5);
		} else {
			imageView = (ImageView) convertView;
		}
		Log.d(TAG, "inside imageAdapter " + position);
		if(position==2){
			int layers[] = new int[]{mThumbIds[position], R.drawable.droid_1, R.drawable.droid_1, R.drawable.droid_1};
			imageView.setImageDrawable(createLayerDrawable(layers));
		} else{
			int layers[] = new int[]{mThumbIds[position]};
			imageView.setImageDrawable(createLayerDrawable(layers));
		}

		//imageView.setBackground(mContext.getResources().getDrawable(mThumbIds[position]));
		return imageView;
	}

	// references to our images
	private Integer[] mThumbIds = {
			R.drawable.tile_gras, R.drawable.tile_road, R.drawable.tile_gras ,
			R.drawable.tile_gras, R.drawable.tile_road, R.drawable.tile_gras ,
			R.drawable.tile_gras, R.drawable.tile_road, R.drawable.tile_gras 
	};

	private LayerDrawable createLayerDrawable(int[] drawablesid){
		Drawable drawableArray[]= new Drawable[drawablesid.length];

		int layerOffsetI = 15;
		int layerOffsetT = 15;
		for(int i=0; i<drawablesid.length; i++){
			BitmapDrawable d = (BitmapDrawable) mContext.getResources().getDrawable(drawablesid[i]);
			d.setGravity(Gravity.LEFT);
			drawableArray[i] = d;
		}
		LayerDrawable layerDraw = new LayerDrawable(drawableArray);

		for(int i=0; i<drawableArray.length; i++){

			if(i>0){
				layerDraw.setLayerInset(i, layerOffsetI, layerOffsetT, 0, 0);//set offset of 2 layer
			}
			
			layerOffsetI = layerOffsetI + 25;
			layerOffsetT = layerOffsetT + 25;
		}

		return layerDraw;
	}

	private LayerDrawable createBmp(){
		BitmapDrawable d1 = (BitmapDrawable) mContext.getResources().getDrawable(R.drawable.droid_1);
		d1.setGravity(Gravity.LEFT);
		BitmapDrawable d2 = (BitmapDrawable) mContext.getResources().getDrawable(R.drawable.droid_1);
		d1.setGravity(Gravity.LEFT);
		BitmapDrawable d3 = (BitmapDrawable) mContext.getResources().getDrawable(R.drawable.droid_1);
		d3.setGravity(Gravity.LEFT);

		Drawable drawableArray[]= new Drawable[]{d3,d2,d1};

		LayerDrawable layerDraw = new LayerDrawable(drawableArray);
		layerDraw.setLayerInset(1, 15, 15, 0, 0);//set offset of 2 layer
		layerDraw.setLayerInset(2,40,40,0,0);//set offset for third layer
		return layerDraw;
	}

}
