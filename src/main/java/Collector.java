import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Collector {
	
	public static void main(String[] args) {
		scanFolder(new File("src/main/webapp"));
	}
	
	public static void scanFolder(File folder) {
		File[] files = folder.listFiles();
		for (File file: files) {
			if (file.isDirectory()) {
				scanFolder(file);
			} else if (file.getName().endsWith(".xhtml")) {
				if (!file.getName().endsWith("Attributes.xhtml")) {
					String newFile = readFile(file.getAbsolutePath());
					if (newFile != null) {
						//System.out.println(file.getName());
					}
				}
 			}
		}
	}

	public static String readFile(String filename) {
		Map<String, String> chapters = new HashMap<>();
		List<String> tags = new ArrayList<>();
		StringBuilder result = new StringBuilder();
		String previousLine = "";

		try(FileReader fr = new FileReader(filename); BufferedReader br= new BufferedReader(fr)) {
			String line;

			while ((line = br.readLine()) != null) {
				if (line.contains("<ui:define name=\"content-navigator\">")) {
					return null;
				}
				while (line.contains("<h1") && (!line.contains("</h1>"))) {
					line = line.trim() + br.readLine().trim();
				}
				line = examineLine(filename, chapters, tags, previousLine, line, "<h1>");
				line = examineLine(filename, chapters, tags, previousLine, line, "<h2>");
				line = examineLine(filename, chapters, tags, previousLine, line, "<h3>");
				result.append(line);
				result.append('\n');
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (tags.size()>1) {
			int pos = result.indexOf("<ui:define name=\"content\">");
			if (pos < 0) {
				return null;
			}
			if (pos > 0) {
				pos = result.lastIndexOf("\n", pos);
			}
			String start = result.substring(0, pos);
			String end = result.substring(pos);
			StringBuilder navigator = new StringBuilder();
			navigator.append("<ui:define name=\"content-navigator\">\n");
			navigator.append("  <b:listLinks>\n");
			for (String tag: tags) {
				navigator.append("    <b:navLink href=\"#" + tag + "\" value=\""+ chapters.get(tag) + "\" />\n");
			}
			
			navigator.append("  </b:listLinks>\n");
			navigator.append("</ui:define>\n\n");
			System.out.println(filename + ": " + tags.size());
			return start + navigator.toString() + end;
			
		}
		return null;
	}

	private static String examineLine(String filename, Map<String, String> chapters, List<String> tags,
			String previousLine, String line, String headerTag) {
		String newHeaderTag = "<h1>";
		if (line.contains(headerTag)) {
			if (line.contains("<a ")) {
				int posh = line.indexOf(headerTag);
				int posa = line.indexOf("<a");
				if (posa < posh) {
					System.out.println("Reorder!" + line);
				}
			} else if (previousLine.contains("<a ")) {
				System.out.println("Previous line contains an anchor! " + line);
			}
			else {
				// add the anchor tag
				int start = line.indexOf(headerTag) + 4;
				int end = line.indexOf("<", start);
				if (end < 0) {
					System.out.println("Error: " + filename);
				}
				if (end < start) {
					System.out.println("Weird!");
				}
				String innerText = line.substring(start, end).trim();
				if (innerText.length()>0) {
					String tag = innerText.replace(" ", "_").toLowerCase();
					line = line.substring(0, start) + newHeaderTag + "<a id=" + tag + ">" + innerText + "</a>" + line.substring(end);
					line.replace("</" + headerTag.substring(1), "</" + newHeaderTag.substring(1));
					chapters.put(tag, innerText);
					tags.add(tag);
					newHeaderTag = "<h2>";
				}
			}
		}
		return line;
	}
}
