
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Reindent {

    static int currentIndent = 0;
    static int parameterIndent = 0;
    static boolean insideTag = false;
    static boolean modified = false;
    static boolean insideStyle = false;
    static boolean silent = false;

    public static void main(String[] args) throws IOException {
//		 readFile("src/main/webapp/layout/navbars.xhtml");
        silent = true;
        scanFolder(new File("src/main/webapp/"));
    }

    public static void scanFolder(File folder) throws IOException {
        File[] files = folder.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                scanFolder(file);
            } else if (file.getName().endsWith(".xhtml")) {
                if (!file.getName().endsWith("Attributes.xhtml")) {
                    String newFile = readFile(file.getAbsolutePath());
                    if (newFile != null) {
                        writeFile(file.getAbsolutePath(), newFile);
                        System.out.println(file.getAbsolutePath());
                        // System.exit(1);
                    }
                }
            }
        }
    }

    public static void writeFile(String filename, String content) throws IOException {
        new File(filename).delete();
        try (FileWriter fw = new FileWriter(filename); BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(content);
        }
    }

    public static String readFile(String filename) {
        if (filename.endsWith("DateTimePicker.xhtml")) {
            return null;
        }
        if (filename.endsWith("InputText.xhtml")) {
            return null;
        }
        if (filename.endsWith("InputSecret.xhtml")) {
            return null;
        }
        StringBuilder result = new StringBuilder();

        try (FileReader fr = new FileReader(filename); BufferedReader br = new BufferedReader(fr)) {
            currentIndent = 0;
            modified = false;
            String line;

            while ((line = br.readLine()) != null) {
                line = examineLine(line);
                result.append(line);
                result.append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (currentIndent == 0 && modified) {
            return result.toString();
        }
        if (modified) {
            System.out.println("Failed at " + filename + " Indent = " + currentIndent);
            // System.exit(1);
        }
        return null;
    }

    private static String examineLine(String line) {
        boolean startsWithClosingTag = false;
        String originalLine = line;
        line = line.trim();
        if (line.startsWith("<a id=") && line.endsWith("/>")) {
            if (line.contains("<h1") || line.contains("<h2") || line.contains("<h3") || line.contains("<h4")) {

            } else {
                System.out.println("Dropping: " + line);
                return "";
            }
        }
        String trimLine = line;
        if (line.length() == 0) {
            return line;
        }
        if (line.startsWith("}")) {
            currentIndent--;
            startsWithClosingTag = true;
        }
        String[] close = line.split(
                "</b:|</h:|</p:|</ui:|</f:|</html|</style|</table|</th|</tr|</td|</ul|</li|</div|</ol|</strong|</meta|</dd|</dl|</dt|</composite|</hf:|</p:|</svg|</circle|</rect|</line|</dependency|</a:|</i");
        currentIndent -= close.length - 1;
        if (close.length > 1) {
            insideTag = false;
        }
        if (line.contains("</style")) {
            insideStyle = false;
        }
        if (line.contains("</g>")) {
            currentIndent--;
        }
        if (line.startsWith("<style>") && line.contains("</style")) {
            currentIndent++;
        }
        if (line.startsWith("<tr>") && line.contains("</tr")) {
            currentIndent++;
        }
        if (line.startsWith("<th>") && line.contains("</th")) {
            currentIndent++;
        }
        if (line.startsWith("<td>") && line.contains("</td")) {
            currentIndent++;
        }
        if (line.startsWith("<ul>") && line.contains("</ul")) {
            currentIndent++;
        }
        if (line.startsWith("<li>") && line.contains("</li")) {
            currentIndent++;
        }
        if (line.contains("<dd>") && line.contains("</dd")) {
            currentIndent++;
        }
        if (line.contains("<dl>") && line.contains("</dl")) {
            currentIndent++;
        }
        if (line.contains("<dt>") && line.contains("</dt")) {
            currentIndent++;
        }
        if (line.contains("<strong>") && line.contains("</strong")) {
            currentIndent++;
        }
        if (line.contains("<div>") && line.contains("</div>")) {
            currentIndent++;
        }
        if (line.contains("<b:") && line.contains("</b:")) {
            currentIndent++;
        }
        // if (line.startsWith("<b:") && (line.contains("</b:") || line.contains("/>")))
        // {
        // currentIndent++;
        // }
        if (insideTag && (!line.startsWith("<"))) {
            for (int i = 0; i < parameterIndent + 1; i++) {
                line = " " + line;
            }
        } else {
            for (int i = 0; i < currentIndent; i++) {
                line = "  " + line;
            }
        }
        if (!silent) {
            System.out.println(currentIndent + line);
        }
        String[] open = line.split(
                "<b:|<h:|<p:|<ui:|<f:|<style|<table|<th|<tr|<td|<ul|<li|<html|<meta|<div|<ol|<strong|<dd|<dl|<dt|<composite|<hf:|<p:|<svg|<circle|<rect|<line|<g |<dependency|<a:|<i |<input");
        currentIndent += open.length - 1;
        if (open.length > 1) {
            insideTag = true;
        }
        if (line.contains("<style")) {
            insideStyle = true;
        }
        String[] openBraces = (line + "blub").split("\\{");
        String[] closedBraces = (line + "blub").split("}");
        currentIndent += openBraces.length - closedBraces.length;
        if (startsWithClosingTag) {
            currentIndent++;
        }
        if (open[open.length - 1].contains(">")) {
            insideTag = false;
        }
        if (open.length > 1) {
            int pos = line.indexOf("<");
            parameterIndent = line.indexOf(" ", pos);
            if (parameterIndent < 0) {
                parameterIndent = line.indexOf(':');
            }
            if (parameterIndent < 0) {
                parameterIndent = line.length();
            }
        }
        String[] close2 = (line + "blub").split("/>");
        if (close2.length > 1) {
            insideTag = false;
        }
        for (String c : close2) {
            // ignore special cases like <br />
            if (c.trim().endsWith("<br")) {
                currentIndent++;
            }
            if (c.trim().endsWith("<hr")) {
                currentIndent++;
            }
            if (c.trim().endsWith("<p")) {
                currentIndent++;
            }
            if (c.contains("<img")) {
                currentIndent++;
            }
            if (c.contains("<cc:")) {
                currentIndent++;
            }
        }
        currentIndent -= close2.length - 1;
        if (!originalLine.equals(line)) {
            modified = true;
        }
        if (line.contains("<div>") && line.contains("</div>")) {
            currentIndent--;
        }
        if (trimLine.startsWith("<style>") && line.contains("</style")) {
            currentIndent--;
        }
        if (trimLine.startsWith("<tr>") && line.contains("</tr")) {
            currentIndent--;
        }
        if (trimLine.startsWith("<th>") && line.contains("</th")) {
            currentIndent--;
        }
        if (trimLine.startsWith("<td>") && line.contains("</td")) {
            currentIndent--;
        }
        if (trimLine.startsWith("<ul>") && line.contains("</ul")) {
            currentIndent--;
        }
        if (trimLine.startsWith("<li>") && line.contains("</li")) {
            currentIndent--;
        }
        if (line.contains("<dd>") && line.contains("</dd")) {
            currentIndent--;
        }
        if (line.contains("<dl>") && line.contains("</dl")) {
            currentIndent--;
        }
        if (line.contains("<dt>") && line.contains("</dt")) {
            currentIndent--;
        }
        if (line.contains("<strong>") && line.contains("</strong")) {
            currentIndent--;
        }
        if (line.contains("<b:") && line.contains("</b:")) {
            currentIndent--;
        }

        // if (trimLine.startsWith("<b:") && (line.contains("</b:") ||
        // line.contains("/>"))) {
        // currentIndent--;
        // }
        return line;
    }
}
