package net.bootsfaces.demo.layout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class IconAwesomeBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<String> fontAwesomeIconList;

	@PostConstruct
	public void onload() {
		initialiseList();
	}

	private void initialiseList() {
		InputStream inputStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("fontAwesomeList.txt");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		fontAwesomeIconList = new ArrayList<>();
		String line = null;
		try {
			while ((line = bufferedReader.readLine()) != null) {
				if (line.contains("(alias)"))
					line = line.substring(0, line.indexOf("(alias)"));
				line = line.trim();
				fontAwesomeIconList.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<String> getFontAwesomeIconList() {
		return fontAwesomeIconList;
	}

	public void setFontAwesomeIconList(List<String> fontAwesomeIconList) {
		this.fontAwesomeIconList = fontAwesomeIconList;
	}

}
