package test.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.bootsfaces.component.tree.event.TreeNodeCheckedEvent;
import net.bootsfaces.component.tree.event.TreeNodeEventListener;
import net.bootsfaces.component.tree.event.TreeNodeExpandedEvent;
import net.bootsfaces.component.tree.event.TreeNodeSelectionEvent;
import net.bootsfaces.component.tree.model.DefaultNodeImpl;
import net.bootsfaces.component.tree.model.Node;
import net.bootsfaces.utils.FacesMessages;

@SessionScoped
@ManagedBean(name = "test")
public class TestBean implements TreeNodeEventListener, Serializable {

    private static final long serialVersionUID = -4647459610022075061L;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    private String selectedColor;
    private Date dataToPick = new Date();

    private Node statefullRootNode = null;
    private String testField;
    private LinkedList<String> messages = new LinkedList<>();

    public TestBean() {
        initStatefullRootNode();
    }

    public Date getDataToPick() {
        return dataToPick;
    }

    public void setDataToPick(Date dataToPick) {
        this.dataToPick = dataToPick;
    }

    public List<String> getMessages() {
        return messages;
    }

    private void initStatefullRootNode() {
        statefullRootNode = new DefaultNodeImpl("root", "arrow-right").withBackColor("#FF1188");
        List<Node> nodeList = new ArrayList<Node>();
        nodeList.add(new DefaultNodeImpl("Node1", "user"));
        nodeList.add(new DefaultNodeImpl("Node2", "envelope"));

        List<Node> subNodes = new ArrayList<Node>();
        subNodes.add(new DefaultNodeImpl("Subnode1", "user"));
        subNodes.add(new DefaultNodeImpl("Subnode2", "main"));
        subNodes.add(new DefaultNodeImpl("Subnode3", "arrow-left"));
        DefaultNodeImpl nx = new DefaultNodeImpl("Child4-Link", "arrow-right");
        nx.setHRef("http://www.google.it");
        subNodes.add(nx);

        DefaultNodeImpl child5 = new DefaultNodeImpl("Child5", "arrow-right");
        child5.setColor("#FF0000");
        List<Node> subSubNodes = new ArrayList<Node>();
        subSubNodes.add(new DefaultNodeImpl("GrandChild 1", "play-circle"));
        subSubNodes.add(new DefaultNodeImpl("GrandChild 2", "play-circle"));
        child5.getChilds().addAll(subSubNodes);
        subNodes.add(child5);

        DefaultNodeImpl parent3 = new DefaultNodeImpl("Parent3", "signal");
        parent3.setExpanded(false);
        parent3.getChilds().addAll(subNodes);
        nodeList.add(parent3);

        statefullRootNode.getChilds().addAll(nodeList);
    }

    public Node getTreeModel() {
        return statefullRootNode;
    }

    public void setTreeModel(Node rootNode) {
        this.statefullRootNode = rootNode;
    }

    public String getSelectedColor() {
        return selectedColor;
    }

    public void setSelectedColor(String selectedColor) {
        this.selectedColor = selectedColor;
    }

    public Node getTestModel1() {
        Node rootNode = new DefaultNodeImpl("root", "arrow-right").withBackColor("#FF9988");
        List<Node> nodeList = new ArrayList<>();
        nodeList.add(new DefaultNodeImpl("Parent1", "user"));
        nodeList.add(new DefaultNodeImpl("Parent2", "envelope"));

        List<Node> subNodes = new ArrayList<>();
        subNodes.add(new DefaultNodeImpl("Child1", "user"));
        subNodes.add(new DefaultNodeImpl("Child2", "main"));
        subNodes.add(new DefaultNodeImpl("Child3", "arrow-left"));
        DefaultNodeImpl nx = new DefaultNodeImpl("Child4-Link", "arrow-right");
        nx.setHRef("http://www.google.it");
        subNodes.add(nx);

        DefaultNodeImpl child5 = new DefaultNodeImpl("Child5", "arrow-right");
        child5.setColor("#FF0000");
        List<Node> subSubNodes = new ArrayList<>();
        subSubNodes.add(new DefaultNodeImpl("GrandChild 1", "play-circle"));
        subSubNodes.add(new DefaultNodeImpl("GrandChild 2", "play-circle"));
        child5.getChilds().addAll(subSubNodes);
        subNodes.add(child5);

        DefaultNodeImpl parent3 = new DefaultNodeImpl("Parent3", "signal");
        parent3.setExpanded(false);
        parent3.getChilds().addAll(subNodes);
        nodeList.add(parent3);

        rootNode.getChilds().addAll(nodeList);
        return rootNode;
    }

    public Node getTestModel2() {
        Node rootNode = new DefaultNodeImpl("root", "arrow-right").withBackColor("#119988");

        List<String> tags = new ArrayList<String>();
        tags.add("TAG 1");
        tags.add("TAG 2");
        List<Node> nodeList = new ArrayList<Node>();
        nodeList.add(new DefaultNodeImpl("Node1", "rocket").withUseFaIcons(true).withBackColor("#FFFF00")
                .withColor("#0000FF").withTags(tags));
        nodeList.add(new DefaultNodeImpl("Node2", "soccer-ball-o").withUseFaIcons(true).withDisabled(true));

        rootNode.getChilds().addAll(nodeList);

        return rootNode;
    }

    @Override
    public void processValueSelected(TreeNodeSelectionEvent event) {
        if (event.isSelected()) {
            messages.addFirst("Node selected: '" + event.getNode().getText() + "'");
        } else {
            messages.addFirst("Node unselected: '" + event.getNode().getText() + "'");
        }
    }

    @Override
    public void processValueChecked(TreeNodeCheckedEvent event) {
        if (event.isChecked()) {
            messages.addFirst("Node checked: '" + event.getNode().getText() + "'");
        } else {
            messages.addFirst("Node unchecked: '" + event.getNode().getText() + "'");
        }
    }

    @Override
    public void processValueExpanded(TreeNodeExpandedEvent event) {
        if (event.isExpanded()) {
            messages.addFirst("Node expanded: '" + event.getNode().getText() + "'");
        } else {
            messages.addFirst("Node collapsed: '" + event.getNode().getText() + "'");
        }
    }

    /**
     * Button methods for form test
     */
    public void button1() {
        FacesMessages.info("BUTTON 1", "BUTTON 1 WAS PRESSED");
    }

    public void button2() {
        FacesMessages.info("BUTTON 2", "BUTTON 2 WAS PRESSED");
    }

    public void button3() {
        FacesMessages.info("BUTTON 3", "BUTTON 3 WAS PRESSED");
    }

    public void button4() {
        FacesMessages.info("BUTTON 4", "BUTTON 4 WAS PRESSED");
    }

    public void button5() {
        FacesMessages.info("BUTTON 5", "BUTTON 5 WAS PRESSED");
    }

    public void updateTestField() {
        this.testField = "Updated by Ajax Event! ;) You've selected " + dateFormat.format(dataToPick);
    }

    public String getTestField() {
        return testField;
    }

    public void setTestField(String testField) {
        this.testField = testField;
    }
}
