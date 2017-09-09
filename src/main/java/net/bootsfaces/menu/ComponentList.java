package net.bootsfaces.menu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

public class ComponentList {

	static Map<String, String> docFiles = new HashMap<>();

	static String[] tags = null;

	static {
		String root = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext())
				.getRealPath("/");
		scanFolder(new File(root), root.length());
		Object[] keySet = docFiles.keySet().toArray();
		Arrays.sort(keySet);
		tags = new String[keySet.length];
		for (int i = 0; i < keySet.length; i++) {
			tags[i] = (String) keySet[i];
		}
	}

	public static void scanFolder(File folder, int charactersToIgnore) {
		File[] files = folder.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				scanFolder(file, charactersToIgnore);
			} else if (file.getName().endsWith(".xhtml")) {
				if (!file.getName().endsWith("Attributes.xhtml")) {
					readFile(file.getAbsolutePath(), charactersToIgnore);
				}
			}
		}
	}

	public static void readFile(String filename, int charactersToIgnore) {
		BufferedReader br = null;
		FileReader fr = null;

		try {
			fr = new FileReader(filename);
			br = new BufferedReader(fr);
			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				if (sCurrentLine.contains("Attributes.xhtml")) {
					int end = sCurrentLine.indexOf("Attributes.xhtml");
					int start = sCurrentLine.lastIndexOf('"', end);
					if (start >= 0) {
						String tag = sCurrentLine.substring(start + 1, end);
						if (tag.contains("/")) {
							start = tag.indexOf("/");
							tag = tag.substring(start + 1);
						}
						tag = tag.substring(0, 1).toLowerCase() + tag.substring(1);

						String url = filename.substring(charactersToIgnore, filename.length());
						url = url.replace("\\", "/").replace(".xhtml", ".jsf");
						docFiles.put("<" + tag + ">", url);
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			try {
				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
