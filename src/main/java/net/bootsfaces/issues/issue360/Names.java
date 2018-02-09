package net.bootsfaces.issues.issue360;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Names {
	private static List<String> names = null;

	public static List<String> getNames() throws IOException {
		if (null == names) {
			List<String> n = new ArrayList<>();
			InputStream namesStream = Names.class.getResourceAsStream("names.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(namesStream));
			while (true) {
				String line = reader.readLine();
				if (null==line)
					break;
				if (line.startsWith("//"))
					continue;
				line = line.trim();
				if (line.length()==0)
					continue;
				n.add(line);
			}
			synchronized (Names.class) {
				names = n;
			}
		}
		return names;
	}

}
