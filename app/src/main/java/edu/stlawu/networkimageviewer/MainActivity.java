package edu.stlawu.networkimageviewer;

import android.graphics.Bitmap;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
    implements GestureDetector.OnGestureListener {

    ImageView iv;
    ImageURLInterface images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.iv = findViewById(R.id.iv_image);
        this.images =
            ImageURLInterface.create(
                    ImageURLInterface.HARCOURT);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*
              Runnable r = new Runnable() {
                  @Override
                  public void run() {
                      final Bitmap bitmap =
                              Utility.downloadBitmap(
                                      images.next(),
                                      iv.getWidth(),
                                      iv.getHeight());
                      MainActivity.this.runOnUiThread(
                              new Runnable() {
                                  @Override
                                  public void run() {
                                      MainActivity.this.iv
                                        .setImageBitmap(bitmap);
                                  }
                              }
                      );


                      )
                  }
              };
                Thread t = new Thread(r);
                t.start(); */

                DownloadBitmapTask task =
                    new DownloadBitmapTask((ImageView) view);
                task.execute(images.next());
            }
        });

    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(
        MotionEvent motionEventStart,  // first touch
        MotionEvent motionEventEnd,    // lift touch
        float vx,                      // x-velocity
        float vy) {                    // y-velocity


        return true;   // consuming the event
    }
}
