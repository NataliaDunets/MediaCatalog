package mediacatalog.cli;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

import com.beust.jcommander.Parameter;

import mediacatalog.model.MediaResource;
import mediacatalog.model.MediaResourceType;
import mediacatalog.repository.MediaResourceRepository;

public class Action {
	@Parameter(description = "resource type", names = "-resource")
	private MediaResourceType resourceType;
	
	@Parameter(description = "action", names = "-action",required = true)
	private ActionType actionType;
	
	@Parameter(description = "name", names = "-name")
	private String name;
	
	public void execute()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		MediaResourceRepository repository = MediaResourceRepository.getRepository(resourceType);
				
		Method method = repository.getClass().getMethod(actionType.name().toLowerCase());
		Object object;
		
		if (name != null) {
			// here method is always "add (temporary solution) need remake(
			object = method.invoke(repository);
			// set resource name only if parameter -name passed trought comman line interface 
			((MediaResource) object).setName(name);
		} else {
			object = method.invoke(repository);
		}
		
		if (object instanceof List) { // If returned type is list we need to format output
			List<MediaResource> list = (List<MediaResource>)object;

			String output = list.stream() 
				.map(MediaResource::toString)
				.collect(Collectors.joining("\n")); 
			
			System.out.println(output + resourceType);
		} else {
			System.out.print(object); 
			System.out.println(resourceType);
		}
	}

	public MediaResourceType getResourceType() {
		return resourceType;
	}

	public ActionType getActionType() {
		return actionType;
	}	
}
