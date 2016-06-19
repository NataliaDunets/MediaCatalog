package mediacatalog.cli;

import java.lang.reflect.Method;import mediacatalog.repository.MediaResourceRepository;

public enum ActionType {
	ADD, // parameters(name, file)
	LIST, // paramerrs
	DELETE, // paramers(name)
	UPDATE;
}
