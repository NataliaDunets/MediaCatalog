package mediacatalog.model;

import java.io.File;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class MediaResource {
	private String name;
	private Date creationDate = new Date();
	private File file;
	
	private boolean isFavarite;
	
	public static MediaResource create(MediaResourceType type) {
		switch (type) {
			case IMAGE:
				return new Image();
			case VIDEO:
				return new Video();
			case AUDIO:
				return new Audio();
			default:
				// throw Exception() ???
				return null;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
