package lai.com.projectl.gif;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.graphics.Movie;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import lai.com.projectl.R;
import lai.com.projectl.base.BaseActivity;

public class MainActivity2 extends BaseActivity implements OnClickListener {

	private static final String TAG = "MainActivity";

	ImageView image2;
	MovieImageView mView;
	Button mBtnA, mBtnB, mBtnC, mBtnD;

	static final String ExternalPath = Environment.getExternalStorageDirectory().getPath();

	// setVisibility test
	private static int sIndexA = 0;
	private static int[] sVisibles = new int[] { View.INVISIBLE, View.GONE, View.VISIBLE };
	private static String[] sDescrA = new String[] { "INVISIBLE", "GONE", "VISIBLE" };

	// setScaleType test
	private static int sIndexB = 0;
	private static ScaleType[] sScaleTypes = new ScaleType[] { ScaleType.CENTER, ScaleType.CENTER_CROP,
			ScaleType.CENTER_INSIDE, ScaleType.FIT_CENTER, ScaleType.FIT_END, ScaleType.FIT_START, ScaleType.FIT_XY };
	private static String[] sDescrB = new String[] { "CENTER", "CENTER_CROP", "CENTER_INSIDE", "FIT_CENTER", "FIT_END",
			"FIT_START", "FIT_XY" };

	// setImageResource test
	private static int sIndexC = 0;
//	private static int[] sResources = new int[] { R.drawable.pngtest1, R.drawable.giftest1, R.drawable.giftest2,
//			R.drawable.giftest3 };

	// setImageUri test
	private static int sIndexD = 0;
	private static Uri[] sImageUris = new Uri[] { Uri.parse("file://" + ExternalPath + "/singleon.gif"),
			Uri.parse("file://" + ExternalPath + "/singleon.gif"),
			Uri.parse("file://" + ExternalPath + "/singleon.gif") };

	// setMovie test
	private static int sIndexE = 0;
	private static Movie[] sMovies = new Movie[4];
	private static String[] sDescrE = new String[] { "Movie1", "Movie2", "Movie3", "Movie4" };

	private static int sIndexF = 0;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_main);
		setContentView(R.layout.activity_main2);

		image2 = (ImageView) this.findViewById(R.id.image2);
		mView = (MovieImageView) this.findViewById(R.id.gifView);

		mBtnA = (Button) this.findViewById(R.id.btnA);
		mBtnB = (Button) this.findViewById(R.id.btnB);
		mBtnC = (Button) this.findViewById(R.id.btnC);
		mBtnD = (Button) this.findViewById(R.id.btnD);

		mBtnA.setOnClickListener(this);
		mBtnB.setOnClickListener(this);
		mBtnC.setOnClickListener(this);
		mBtnD.setOnClickListener(this);

		image2 = (ImageView) this.findViewById(R.id.image2);

		InputStream uriInputStream = null;
		try {
			uriInputStream = new BufferedInputStream(this.getContentResolver().openInputStream(sImageUris[0]));
			uriInputStream.mark(uriInputStream.available());
			sMovies[0] = Movie.decodeStream(uriInputStream);

			uriInputStream = new BufferedInputStream(this.getContentResolver().openInputStream(sImageUris[1]));
			uriInputStream.mark(uriInputStream.available());
			sMovies[1] = Movie.decodeStream(uriInputStream);

			uriInputStream = new BufferedInputStream(this.getContentResolver().openInputStream(sImageUris[2]));
			uriInputStream.mark(uriInputStream.available());
			sMovies[2] = Movie.decodeStream(uriInputStream);

//			uriInputStream = new BufferedInputStream(this.getContentResolver().openInputStream(sImageUris[2]));
//			uriInputStream.mark(uriInputStream.available());
			File file = new File(Environment.getExternalStorageDirectory() + "/singleon.gif");
			uriInputStream = new BufferedInputStream(this.getContentResolver().openInputStream(Uri.parse("file://"+file.getPath())));
//			uriInputStream = new FileInputStream(file);
			uriInputStream.mark(uriInputStream.available());
			sMovies[3] = Movie.decodeStream(uriInputStream);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onClick(View arg0) {
		Log.i("MainActivity", "onClick");
		switch (arg0.getId()) {
		case R.id.btnA:
			if (sIndexA == 0) {
				image2.setVisibility(View.INVISIBLE);
			}else if (sIndexA==1){
				image2.setVisibility(View.GONE);
			}else if(sIndexA==2){
				image2.setVisibility(View.VISIBLE);
			}
//			image2.setVisibility(sVisibles[sIndexA]);
//			mView.setVisibility(sVisibles[sIndexA]);
			mBtnA.setText("Visible: " + sDescrA[sIndexA]);
			sIndexA++;
			if (sIndexA >= sVisibles.length) {
				sIndexA = 0;
			}
			break;
		case R.id.btnB:
			image2.setScaleType(sScaleTypes[sIndexB]);
			mView.setScaleType(sScaleTypes[sIndexB]);
			mBtnB.setText("ScaleType: " + sDescrB[sIndexB]);
			sIndexB++;
			if (sIndexB >= sScaleTypes.length) {
				sIndexB = 0;
			}
			break;
		case R.id.btnC:
			image2.setImageResource(R.drawable.avatar_two);
			mView.setMovie(sMovies[sIndexE]);
			mBtnC.setText("setMovie: " + sDescrE[sIndexE]);
			sIndexE++;
			if (sIndexE >= sMovies.length) {
				sIndexE = 0;
			}
			break;
		case R.id.btnD:
			switch (sIndexF) {
			case 0:
				image2.setPadding(100, 0, 0, 0);
				mView.setPadding(100, 0, 0, 0);
				mBtnD.setText("setPadding: 100,0,0,0");
				break;
			case 1:
				image2.setPadding(0, 100, 0, 0);
				mView.setPadding(0, 100, 0, 0);
				mBtnD.setText("setPadding: 0,100,0,0");
				break;
			case 2:
				image2.setPadding(0, 0, 100, 0);
				mView.setPadding(0, 0, 100, 0);
				mBtnD.setText("setPadding: 0,0,100,0");
				break;
			case 3:
				image2.setPadding(0, 0, 0, 100);
				mView.setPadding(0, 0, 0, 100);
				mBtnD.setText("setPadding: 0,0,0,100");
				break;
			case 4:
				image2.setPadding(100, 100, 100, 100);
				mView.setPadding(100, 100, 100, 100);
				mBtnD.setText("setPadding: 100,100,100,100");
				break;
			case 5:
				image2.setPadding(0, 0, 0, 0);
				mView.setPadding(0, 0, 0, 0);
				mBtnD.setText("setPadding: no");
				break;
			}
			sIndexF++;
			if (sIndexF == 6) {
				sIndexF = 0;
			}
			break;
		}
	}

}
