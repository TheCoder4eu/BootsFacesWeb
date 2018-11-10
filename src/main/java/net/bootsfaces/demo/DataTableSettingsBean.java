/**
 *  (C) 2013-2014 Stephan Rauh http://www.beyondjava.net
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.bootsfaces.demo;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import de.beyondjava.jsf.sample.carshop.Car;

/** A simple bean for demo purposes. */
@SessionScoped
@ManagedBean
public class DataTableSettingsBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private boolean headerStyle = false;
	private boolean headerStyleClass = false;
	private boolean contentStyle = false;
	private boolean style = false;
	private boolean styleClass = false;

	private boolean contentDisabled = false;

	private boolean contentStyleClass = false;

	private boolean footerStyle = false;

	private boolean footerStyleClass = false;

	private boolean saveState = false;

	private boolean multiColumnSearch = false;
	private String multiColumnSearchPosition = "top";
	private boolean markSearchResults = true;

	private boolean searching = false;

	private boolean striped = true;

	private boolean border = true;
	private boolean rowHighlight = true;

	private boolean languageIsEs = false;

	private boolean orderable = false;

	private boolean customOptions = false;

	private boolean select = false;

	private String selectionMode = "multiple";

	private String selectedItems = null;

	private boolean showInfo = true;

	private boolean deselectOnBackdropClick = false;

	private boolean fixedHeader = false;

	private boolean searchable = true;

	private String defaultColumnFilter = "";

	private boolean paginated = true;
	
	private boolean pagingType = true;

	private boolean selectedRowsActive1 = false;

	private boolean selectedRowsActive2 = false;

	private Object selectedRows = "2,4,6";

	private boolean selectedColumnsActive = false;

	private String selectedColumns = "1,3";
	
	private boolean useCDN = true;

	private boolean useSlimFiles = false;
	
	private boolean scrollToDemo = false;
	
	@ManagedProperty("#{carPool.carPool}")
	private List<Car> carPool;

	public boolean isSaveState() {
		return saveState;
	}

	public void setSaveState(boolean saveState) {
		this.saveState = saveState;
	}

	public boolean isMultiColumnSearch() {
		return multiColumnSearch;
	}

	public void setMultiColumnSearch(boolean multiColumnSearch) {
		this.multiColumnSearch = multiColumnSearch;
	}

	public boolean isSearching() {
		return searching;
	}

	public void setSearching(boolean search) {
		this.searching = search;
	}

	public boolean isStriped() {
		return striped;
	}

	public void setStriped(boolean striped) {
		this.striped = striped;
	}

	public boolean isBorder() {
		return border;
	}

	public void setBorder(boolean border) {
		this.border = border;
	}

	public boolean isRowHighlight() {
		return rowHighlight;
	}

	public void setRowHighlight(boolean rowHighlight) {
		this.rowHighlight = rowHighlight;
	}

	public String getContentCSS() {
		if (contentStyle) {
			return "color:red";
		}
		return null;
	}

	public String getCSS() {
		if (style) {
			return "color:blue";
		}
		return null;
	}

	public String getContentStyleClassName() {
		if (contentStyleClass) {
			return "hidden";
		}
		return null;
	}

	public String getStyleClassName() {
		if (styleClass) {
			return "hidden";
		}
		return null;
	}

	public String getFooterCSS() {
		if (footerStyle) {
			return "color:red";
		}
		return null;
	}

	public String getFooterStyleClassName() {
		if (footerStyleClass) {
			return "hidden";
		}
		return null;
	}

	public String getHeaderCSS() {
		if (headerStyle) {
			return "color:red";
		}
		return null;
	}

	public String getHeaderStyleClassName() {
		if (headerStyleClass) {
			return "hidden";
		}
		return null;
	}

	public boolean isContentStyle() {
		return contentStyle;
	}

	public boolean isContentStyleClass() {
		return contentStyleClass;
	}

	public boolean isFooterStyle() {
		return footerStyle;
	}

	public boolean isFooterStyleClass() {
		return footerStyleClass;
	}

	public boolean isHeaderStyle() {
		return headerStyle;
	}

	public boolean isHeaderStyleClass() {
		return headerStyleClass;
	}

	public void setContentStyle(boolean contentStyle) {
		this.contentStyle = contentStyle;
	}

	public void setContentStyleClass(boolean contentStyleClass) {
		this.contentStyleClass = contentStyleClass;
	}

	public void setFooterStyle(boolean footerStyle) {
		this.footerStyle = footerStyle;
	}

	public void setFooterStyleClass(boolean footerStyleClass) {
		this.footerStyleClass = footerStyleClass;
	}

	public void setHeaderStyle(boolean headerStyle) {
		this.headerStyle = headerStyle;
	}

	public void setHeaderStyleClass(boolean headerStyleClass) {
		this.headerStyleClass = headerStyleClass;
	}

	public void updateSettings() {

	}

	public boolean isLanguageIsEs() {
		return languageIsEs;
	}

	public void setLanguageIsEs(boolean languageIsEs) {
		this.languageIsEs = languageIsEs;
	}

	public boolean isOrderable() {
		return orderable;
	}

	public void setOrderable(boolean orderable) {
		this.orderable = orderable;
	}

	public String getLanguage() {
		if (languageIsEs)
			return "es";
		return null;
	}

	public boolean isCustomOptions() {
		return customOptions;
	}

	public void setCustomOptions(boolean customOptions) {
		this.customOptions = customOptions;
	}

	public String getCustomOptionsValue() {
		String result = "";
		if (this.customOptions) {
			result += "colReorder:true";
		}
		if (this.pagingType) {
			if (result.length()>0) {
				result += ",";
			}
			result += "pagingType:'full'";
		}
		if (result.length() > 0) {
			return result;
		}
		return null;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public boolean isSearchable() {
		return searchable;
	}

	public void setSearchable(boolean searchable) {
		this.searchable = searchable;
	}

	public boolean isFixedHeader() {
		return fixedHeader;
	}

	public void setFixedHeader(boolean fixedHeader) {
		this.fixedHeader = fixedHeader;
	}

	public String getSelectionMode() {
		return selectionMode;
	}

	public void setSelectionMode(String selectionMode) {
		this.selectionMode = selectionMode;
	}

	public boolean getSingleSelectionMode() {
		return "single".equals(selectionMode);
	}

	public void setSingleSelectionMode(boolean selectionMode) {
		this.selectionMode = selectionMode ? "single" : "multiple";
	}

	public boolean isStyleClass() {
		return styleClass;
	}

	public void setStyleClass(boolean styleClass) {
		this.styleClass = styleClass;
	}

	public boolean isStyle() {
		return style;
	}

	public void setStyle(boolean style) {
		this.style = style;
	}

	public String getDefaultColumnFilter() {
		if ("".equals(defaultColumnFilter)) {
			return null;
		}
		return defaultColumnFilter;
	}

	public void setDefaultColumnFilter(String defaultColumnFilter) {
		this.defaultColumnFilter = defaultColumnFilter;
	}

	public boolean isPaginated() {
		return paginated;
	}

	public void setPaginated(boolean paginated) {
		this.paginated = paginated;
	}

	public String getMultiColumnSearchPosition() {
		return multiColumnSearchPosition;
	}

	public void setMultiColumnSearchPosition(String multiColumnSearchPosition) {
		this.multiColumnSearchPosition = multiColumnSearchPosition;
	}

	public void setMultiColumnSearchPositionTop(boolean top) {
		if (top) {
			this.multiColumnSearchPosition = "top";
		} else {
			this.multiColumnSearchPosition = "bottom";
		}
	}

	public boolean isMultiColumnSearchPositionTop() {
		return this.multiColumnSearchPosition == "top";
	}

	public boolean isContentDisabled() {
		return contentDisabled;
	}

	public void setContentDisabled(boolean contentDisabled) {
		this.contentDisabled = contentDisabled;
	}

	public boolean isDeselectOnBackdropClick() {
		return deselectOnBackdropClick;
	}

	public void setDeselectOnBackdropClick(boolean deselectOnBackdropClick) {
		this.deselectOnBackdropClick = deselectOnBackdropClick;
	}

	public boolean isShowInfo() {
		return showInfo;
	}

	public void setShowInfo(boolean showInfo) {
		this.showInfo = showInfo;
	}

	public String getSelectedItems() {
		return selectedItems;
	}

	public boolean isSelectedRowsActive1() {
		return selectedRowsActive1;
	}

	public void setSelectedRowsActive1(boolean selectedRowsActive) {
		this.selectedRowsActive1 = selectedRowsActive;
	}

	public void setSelectedItems(String selectedItems) {
		this.selectedItems = selectedItems;
	}

	public boolean isSelectedRowsActive2() {
		return selectedRowsActive2;
	}

	public void setSelectedRowsActive2(boolean selectedRowsActive) {
		this.selectedRowsActive2 = selectedRowsActive;
	}

	public String getSelectedColumns() {
		if (!selectedColumnsActive) {
			return null;
		}
		return selectedColumns;
	}

	public void setSelectedColumns(String selectedColumns) {
		if (selectedColumnsActive) {
			this.selectedColumns = selectedColumns;
		}
	}

	public Object getSelectedRows() {
		if (selectedRowsActive2) {
			return this.carPool.get(2);
		}
		if (!selectedRowsActive1) {
			return null;
		}
		
		return selectedRows;
	}

	public void setSelectedRows(Object selectedRows) {
		if (selectedRowsActive1) {
			this.selectedRows = selectedRows;
		}
	}

	public boolean isSelectedColumnsActive() {
		return selectedColumnsActive;
	}

	public void setSelectedColumnsActive(boolean selectedColumnsActive) {
		this.selectedColumnsActive = selectedColumnsActive;
	}

	public List<Car> getCarPool() {
		return carPool;
	}

	public void setCarPool(List<Car> carPool) {
		this.carPool = carPool;
	}

	public boolean isMarkSearchResults() {
		return markSearchResults;
	}

	public void setMarkSearchResults(boolean markSearchResult) {
		this.markSearchResults = markSearchResult;
	}

	public boolean isUseCDN() {
		return useCDN;
	}

	public void setUseCDN(boolean useCDN) {
		this.useCDN = useCDN;
	}
	
	public String reload() {
		scrollToDemo = true;
		return "/layout/resourcemanagement.jsf#dataTablePreview";
	}

	public boolean isUseSlimFiles() {
		return useSlimFiles;
	}

	public void setUseSlimFiles(boolean useSlimFiles) {
		this.useSlimFiles = useSlimFiles;
	}

	public boolean isScrollToDemo() {
		return scrollToDemo;
	}

	public void setScrollToDemo(boolean scrollToDemo) {
		this.scrollToDemo = scrollToDemo;
	}

	public boolean isPagingType() {
		return pagingType;
	}

	public void setPagingType(boolean pagingType) {
		this.pagingType = pagingType;
	}
}
