package net.bootsfaces.demo;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean
public class ColumnsBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private boolean containerDisabled = false;
	private boolean rowDisabled = false;
	private boolean columnDisabled = false;

	public boolean isContainerDisabled() {
		return containerDisabled;
	}

	public void setContainerDisabled(boolean containerDisabled) {
		this.containerDisabled = containerDisabled;
	}

	public boolean isRowDisabled() {
		return rowDisabled;
	}

	public void setRowDisabled(boolean rowDisabled) {
		this.rowDisabled = rowDisabled;
	}

	public boolean isColumnDisabled() {
		return columnDisabled;
	}

	public void setColumnDisabled(boolean columnDisabled) {
		this.columnDisabled = columnDisabled;
	}
	
	public void onChange() {}
}
