package mediacatalog.model;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class MediaResource {
	private String name;
	private Date creationDate = new Date();	
	//private boolean isFavarite;
	private MediaResourceType type;
	
	public static MediaResource create(MediaResourceType type) {
		switch (type) {
			case IMAGE:
				return new Image();
			case VIDEO:
				return new Video();
			case AUDIO:
				return new Audio();
			default:
				return null;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public MediaResourceType getType() {
		return type;
	}
	
	public MediaResourceType setType(MediaResourceType type) {
		return this.type = type;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE );
	}
}
