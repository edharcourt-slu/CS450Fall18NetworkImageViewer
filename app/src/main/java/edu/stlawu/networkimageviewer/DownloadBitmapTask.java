package edu.stlawu.networkimageviewer;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

public class DownloadBitmapTask extends
        AsyncTask<String, Void, Bitmap>  {

    private ImageView iv;

    public DownloadBitmapTask(ImageView iv) {
        this.iv = iv;
    }

    @Override
    // doInBackground runs in a separate thread
    // than the UI thread. Worker thread.
    protected Bitmap doInBackground(String... url) {
        Bitmap bm = Utility.downloadBitmap(
                url[0], iv.getWidth(), iv.getHeight()
        );
        return bm;
    }

    @Override
    // onPostExecute always runs in the UI thread.
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        iv.setImageBitmap(bitmap);
    }
}
