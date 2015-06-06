package fk.sp.ListEasy.models;

import java.util.List;
import java.util.Map;

/**
 * @author sabarinath.s
 * Date: 06-Jun-2015	
 * Time: 1:01:06 am 
 */

public class CreateProductRequest {

	private String sellerId;
	private String vertical;
	private String verticalGroup;
	private String skuId;
	private String rowId;
	private String groupId;
	private Map<String, List<Property>> rowData;
	private List<ImageData> images;
	private String draft;
	
	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getVertical() {
		return vertical;
	}

	public void setVertical(String vertical) {
		this.vertical = vertical;
	}

	public String getVerticalGroup() {
		return verticalGroup;
	}

	public void setVerticalGroup(String verticalGroup) {
		this.verticalGroup = verticalGroup;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public Map<String, List<Property>> getRowData() {
		return rowData;
	}

	public void setRowData(Map<String, List<Property>> row) {
		this.rowData = row;
	}

	public List<ImageData> getImages() {
		return images;
	}

	public void setImages(List<ImageData> images) {
		this.images = images;
	}

	public String getDraft() {
		return draft;
	}

	public void setDraft(String draft) {
		this.draft = draft;
	}

	public static class Property{
		private String value;
		private String qualifier;
		
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public String getQualifier() {
			return qualifier;
		}
		public void setQualifier(String qualifier) {
			this.qualifier = qualifier;
		}
		
	}
	
}
