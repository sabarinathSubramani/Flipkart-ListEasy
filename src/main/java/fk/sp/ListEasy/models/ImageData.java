package fk.sp.ListEasy.models;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ImageData {
 
    private String path;
    private int orderNo;
    private String name;
 
    public ImageData() {
    }
 
    public ImageData(String path, int orderNo, String name) {
        this.path = path;
        this.orderNo = orderNo;
        this.name = name;
    }
 
    public String getPath() {
        return path;
    }
 
    public void setPath(String path) {
        this.path = path;
    }
 
    public int getOrderNo() {
        return orderNo;
    }
 
    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }
 
    public String getName() { return name; }
 
    public void setName(String name){ this.name = name; }
 
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("orderNo", orderNo)
                .append("name", name)
                .append("path", path)
                .toString();
    }
}
