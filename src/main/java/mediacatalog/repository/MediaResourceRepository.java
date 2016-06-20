package mediacatalog.repository;

import java.util.ArrayList;
import java.util.List;

import mediacatalog.model.MediaResource;
import mediacatalog.model.MediaResourceType;

public abstract class MediaResourceRepository {
	
	public static MediaResourceRepository getRepository(MediaResourceType type) {
		switch (type) {
			case IMAGE:
				return new ImageRepository();
			case VIDEO:
				return new VideoRepository();
			case AUDIO:
				return new AudioRepository();
			default:
				return null;
		}
	}
	
	public List<? extends MediaResource> list() {
		return new ArrayList<>();
	}
	
	public abstract MediaResource add();
	
	// remove();
	// update();
}
