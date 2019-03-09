package hrm.domain;

import java.io.Serializable;

public class Job implements Serializable{
    private Integer id;

    private String name;

    private String pemark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPemark() {
        return pemark;
    }

    public void setPemark(String pemark) {
        this.pemark = pemark == null ? null : pemark.trim();
    }
}