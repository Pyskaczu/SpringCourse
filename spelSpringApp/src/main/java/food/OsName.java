package food;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("osName")
public class OsName {

	@Value("#{systemProperties['os.name'] matches 'Windows 7' ? 'Indeed Windows 7' : 'Not Windows 7'}")
	private String osName;

	public String getOsName() {
		return osName;
	}

	public void setOsName(String osName) {
		this.osName = osName;
	}

}
