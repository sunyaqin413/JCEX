package cn.jcex.bean;

/**
 * 类描述:价格试算选择额外服务bean
 *
 * @author Administrator
 * @version 1.0
 * @data 2018/4/12  11:06
 */

public class CalcuatePriceElseBean {
    private String name;
    private int imgId;
    private boolean selected;

    public CalcuatePriceElseBean(String name, int imgId) {
        this.name = name;
        this.imgId = imgId;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
