package mediacatalog.repository;

import java.util.ArrayList;
import java.util.List;
import mediacatalog.model.Audio;
import mediacatalog.model.MediaResource;

public class AudioRepository extends MediaResourceRepository {
	
	private static List<Audio> audios = new ArrayList<>(); //a little silly, but it shows the meaning of

	@Override
	public MediaResource add() {
		Audio audio = new Audio();
		audios.add(audio);
		return audio;
	}
	
	public List<Audio> list() {
		return audios;
	}
	 
	
	/// piblic remove() {}


}
