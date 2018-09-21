package edu.stlawu.networkimageviewer;

abstract public class ImageURLInterface {
    public final static int HARCOURT = 1;
    public final static int GOOGLE = 2;
    public abstract String next();
    public abstract String prev();
    public static ImageURLInterface create(int src) {
        if (src == 1)
            return new HarcourtImages();
        else if (src == 2)
            return new GoogleImages();
        else
            return null;
    }
}
