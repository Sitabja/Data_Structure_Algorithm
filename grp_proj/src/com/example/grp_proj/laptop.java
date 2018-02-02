
package com.example.grp_proj;

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
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class laptop extends Activity {
	// ---the images to display---
	Integer[ ] imageIDs = { R.drawable.z580,R.drawable.dell_studio_1,R.drawable.cs_gallery2,R.drawable.pic1};

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display);
		
		Gallery gallery = (Gallery) findViewById(R.id.gallery1);
		
		gallery.setAdapter(new ImageAdapter(this));
		gallery.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				Toast.makeText(getBaseContext(), "laptop" + (position + 1) + " selected", Toast.LENGTH_SHORT).show();
				// ---display the images selected---
				ImageView imageView = (ImageView) findViewById(R.id.image1);
				imageView.setImageResource(imageIDs[position]);
			}
		});
	}

	//Create the ImageAdapter class (which extends the BaseAdapter class) so that it can 
	//bind to the Gallery view with a series of ImageView views.
	public class ImageAdapter extends BaseAdapter {
		Context context;
		int itemBackground;

		public ImageAdapter(Context c) {
			context = c;
			// ---setting the style--- Retrieve styled attribute information in this Context's theme. 
			//TypedArray - Container for an array of values that were retrieved 
			TypedArray a = obtainStyledAttributes(R.styleable.Gallery1);
			//arg1 (index) - Index of attribute to retrieve 
			//arg2 (defValue) - Value to return if the attribute is not defined or not a resource 
			itemBackground = a.getResourceId(R.styleable.Gallery1_android_galleryItemBackground, 0);
			//Causes the allocated memory to be returned to the available pool immediately 
			//and will not stay until garbage collection. 
			//Required for caching purporse.
			a.recycle();
		}

		// ---returns the number of images---
		public int getCount() { return imageIDs.length; }

		// ---returns the item---
		public Object getItem(int position) { return position; }

		// ---returns the ID of an item---
		public long getItemId(int position) { return position; }

		// ---returns an ImageView view with the selected image inside it along with some scale, 
		//layout paramaters and the image background set.---
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView;
			if (convertView == null) {
				imageView = new ImageView(context);
				imageView.setImageResource(imageIDs[position]);
				imageView.setScaleType(ImageView.ScaleType.FIT_XY);
				imageView.setLayoutParams(new Gallery.LayoutParams(150, 120)); //150-width, 120-height
			} else {
				imageView = (ImageView) convertView;
			}
			imageView.setBackgroundResource(itemBackground);
			return imageView;
		}
	}
}