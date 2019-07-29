package p.com.bumptech.glide.load.resource.file;

import p.com.bumptech.glide.load.engine.Resource;
import p.com.bumptech.glide.load.resource.SimpleResource;

import java.io.File;

/**
 * A simple {@link Resource} that wraps a {@link File}.
 */
public class FileResource extends SimpleResource<File> {
    public FileResource(File file) {
        super(file);
    }
}
