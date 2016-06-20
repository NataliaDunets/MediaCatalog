package mediacatalog.repository;

import java.util.ArrayList;
import java.util.List;
import mediacatalog.model.MediaResource;
import mediacatalog.model.Video;

public class VideoRepository extends MediaResourceRepository {
	
	
	private static List<Video> videos = new ArrayList<>(); //a little silly, but it shows the meaning of

	@Override
	public MediaResource add() {
		Video video = new Video();
		videos.add(video);
		return video;
	}
	
	public List<Video> list() {
		return videos;
	}
	 
	
	/// piblic remove() {}

	
	

}
