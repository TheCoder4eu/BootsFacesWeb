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

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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

	private boolean searching = false;

	private boolean striped = true;

	private boolean border = true;
	private boolean rowHighlight = true;

	private boolean languageIsEs = false;

	private boolean orderable = false;

	private boolean customOptions = false;

	private boolean select = false;

	private String selectionMode = "multiple";

	private boolean fixedHeader = false;

	private boolean searchable = true;

	private String defaultColumnFilter = "";

	private boolean paginated = true;

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
		if (this.customOptions) {
			return "colReorder:true";
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
		return this.multiColumnSearchPosition=="top";
	}

	public boolean isContentDisabled() {
		return contentDisabled;
	}

	public void setContentDisabled(boolean contentDisabled) {
		this.contentDisabled = contentDisabled;
	}
}
