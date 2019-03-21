package food;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("dataSource")
public class DataSource {

	public final String APPLE_DESCRIPTION = "Hi, I am an apple description!";
	
	public static String getAppleTypeStatic() {
		List<String> types = new ArrayList<>();
		types.add("State Fair");
		types.add("McIntosh");
		types.add("Honetcrisp");
		types.add("Regent");
		
		Collections.shuffle(types);
		
		return types.get(0);
	}
	
	public String getAppleType() {
		return getAppleTypeStatic();
	}
	
}
