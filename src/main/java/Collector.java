
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Collector {

    public static void main(String[] args) throws IOException {
        scanFolder(new File("src/main/webapp"));
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
                        //System.exit(1);
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
        Map<String, String> chapters = new HashMap<>();
        List<String> tags = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        String previousLine = "";

        try (FileReader fr = new FileReader(filename); BufferedReader br = new BufferedReader(fr)) {
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
        if (tags.size() > 1) {
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
            navigator.append("\n\n<ui:define name=\"content-navigator\">\n");
            navigator.append("  <b:listLinks>\n");
            for (String tag : tags) {
                navigator.append("    <b:navLink href=\"#" + tag + "\" value=\"" + chapters.get(tag) + "\" />\n");
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
        String newHeaderTag = "<h2>";
        if (headerTag.equals("<h1>")) {
            newHeaderTag = "<h1>";
        }
        if (line.contains(headerTag)) {
            if (line.contains("<a ")) {
                int posh = line.indexOf(headerTag);
                int posa = line.indexOf("<a");
                if (posa < posh) {
                    System.out.println("Reorder!" + line);
                }
            } else if (previousLine.contains("<a ")) {
                System.out.println("Previous line contains an anchor! " + line);
            } else {
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
                if (innerText.length() > 0) {
                    innerText = innerText.replace("(Virtually no)", "");
                    int end2 = 0;
                    while (end2 < innerText.length() && (Character.isLetter(innerText.charAt(end2))
                            || Character.isWhitespace(innerText.charAt(end2)) || '&' == innerText.charAt(end2)
                            || '/' == innerText.charAt(end2) || ';' == innerText.charAt(end2)
                            || ':' == innerText.charAt(end2))) {
                        end2++;
                    }
                    String tag = innerText.substring(0, end2).replace("&lt;", "").replace("&gt;", "").replace(":", "_")
                            .replace("/", "").toLowerCase();
                    tag = tag.trim().replace(" ", "_");
                    if (tag.length() == 0) {
                        System.out.println("Empty tag?");
                    } else {
                        line = line.substring(0, line.indexOf(headerTag)) + newHeaderTag + "<a id=\"" + tag + "\">" + innerText
                                + "</a>" + line.substring(end);
                        line = line.replace("</" + headerTag.substring(1), "</" + newHeaderTag.substring(1));
                        chapters.put(tag, innerText);
                        tags.add(tag);
                        newHeaderTag = "<h2>";
                    }
                }
            }
        }
        return line;
    }
}
