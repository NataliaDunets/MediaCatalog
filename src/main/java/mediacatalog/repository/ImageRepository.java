package mediacatalog.repository;

import java.util.ArrayList;
import java.util.List;
import mediacatalog.model.Image;
import mediacatalog.model.MediaResource;

public class ImageRepository extends MediaResourceRepository {
	
	private static List<Image> images = new ArrayList<>();

	@Override
	public MediaResource add() {
		Image image = new Image();
		images.add(image);
		return image;
	}
	
	public List<Image> list() {
		return images;
	}
	 
	
	/// piblic remove() {}

}
