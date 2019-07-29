package p.com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;

import p.com.bumptech.glide.gifdecoder.GifDecoder;
import p.com.bumptech.glide.load.ResourceDecoder;
import p.com.bumptech.glide.load.engine.Resource;
import p.com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import p.com.bumptech.glide.load.resource.bitmap.BitmapResource;

class GifFrameResourceDecoder implements ResourceDecoder<GifDecoder, Bitmap> {
    private final BitmapPool bitmapPool;

    public GifFrameResourceDecoder(BitmapPool bitmapPool) {
        this.bitmapPool = bitmapPool;
    }

    @Override
    public Resource<Bitmap> decode(GifDecoder source, int width, int height) {
        Bitmap bitmap = source.getNextFrame();
        return BitmapResource.obtain(bitmap, bitmapPool);
    }

    @Override
    public String getId() {
        return "GifFrameResourceDecoder.com.bumptech.glide.load.resource.gif";
    }
}
