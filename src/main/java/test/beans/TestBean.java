package test.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.bootsfaces.component.tree.event.TreeNodeCheckedEvent;
import net.bootsfaces.component.tree.event.TreeNodeEventListener;
import net.bootsfaces.component.tree.event.TreeNodeSelectionEvent;
import net.bootsfaces.component.tree.model.DefaultNodeImpl;
import net.bootsfaces.component.tree.model.Node;


@SessionScoped
@ManagedBean(name = "test")
public class TestBean implements TreeNodeEventListener {
	private Node selectedNode;
	private List<Node> checkedNodes = new ArrayList<Node>();
	private String selectedColor;
	
	private Node statefullRootNode = null;

	public TestBean() {
		initStatefullRootNode();
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

	public String getCheckedColumns() {
		if(checkedNodes != null && checkedNodes.size() > 0){
			StringBuilder sb = new StringBuilder();
			sb.append("CHECKED NODES: ");
			for(Node n: checkedNodes) {
				sb.append(n.getText() + " : ");
			}
			return sb.toString();
		}
		return "NO CHECKED ITEMS";
	}
	public void setCheckedColumns(String column) { }
	
	public Node getTestModel1() {
		Node rootNode = new DefaultNodeImpl("root", "arrow-right").withBackColor("#FF9988");
		List<Node> nodeList = new ArrayList<Node>();
		nodeList.add(new DefaultNodeImpl("Parent1", "user"));
		nodeList.add(new DefaultNodeImpl("Parent2", "envelope"));
		
		List<Node> subNodes = new ArrayList<Node>();
		subNodes.add(new DefaultNodeImpl("Child1", "user"));
		subNodes.add(new DefaultNodeImpl("Child2", "main"));
		subNodes.add(new DefaultNodeImpl("Child3", "arrow-left"));
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
		
		rootNode.getChilds().addAll(nodeList);
		return rootNode;
	}
	
	public Node getTestModel2() {
		Node rootNode = new DefaultNodeImpl("root", "arrow-right").withBackColor("#119988");
		
		List<String> tags = new ArrayList<String>();
		tags.add("TAG 1");
		tags.add("TAG 2");
		List<Node> nodeList = new ArrayList<Node>();
		nodeList.add(new DefaultNodeImpl("Node1", "rocket").withUseFaIcons(true).withBackColor("#FFFF00").withColor("#0000FF").withTags(tags));
		nodeList.add(new DefaultNodeImpl("Node2", "soccer-ball-o").withUseFaIcons(true).withDisabled(true));
		
		rootNode.getChilds().addAll(nodeList);

		return rootNode;
	}

	@Override
	public boolean isValueSelected(Node arg0) {
		if(selectedNode != null) {
			return selectedNode.getText().equalsIgnoreCase(arg0.getText());
		}
		return false;
	}

	@Override
	public void processValueChange(TreeNodeSelectionEvent event) {
		System.out.println("SELEZIONATO NODO:"); 
		System.out.println("NEW TITLE: " + event.getNewSelectedNode().getText());
		if(event.getOldSelectedNode() != null)
			System.out.println("OLD TITLE: " + event.getOldSelectedNode().getText());
		
		selectedNode = event.getNewSelectedNode();
	}

	@Override
	public boolean isValueChecked(Node arg0) {
		return false;
	}

	@Override
	public void processValueChecked(TreeNodeCheckedEvent event) {
		System.out.println("CHECKED NODE:" + event.getNode().getText());
		checkedNodes.add(event.getNode());
	}

	@Override
	public void processValueUnchecked(TreeNodeCheckedEvent event) {
		System.out.println("UNCHECKED NODE:" + event.getNode().getText());
		for(Node n : checkedNodes) {
			if(n.getText().equals(event.getNode().getText())) {
				checkedNodes.remove(n);
				break;
			}
		}
		// checkedNodes.remove(event.getNode());
		
	}

	/**
	 * Button methods for form test
	 */
	public void button1() {
		System.out.println("SELECTED COLOR: " + selectedColor) ;
		System.out.println("CLICKED: BUTTON 1");
	}
	public void button2() {
		System.out.println("SELECTED COLOR: " + selectedColor) ;
		System.out.println("CLICKED: BUTTON 2");
	}
	public void button3() {
		System.out.println("SELECTED COLOR: " + selectedColor) ;
		System.out.println("CLICKED: BUTTON 3");
	}
	
}
