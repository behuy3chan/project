package net.techres.demo.api.model.filter;

public class TableFilterCriteria extends BaseFilterCriteria {

    private String name;

    public TableFilterCriteria(String name) {
        this.setName(name);
    }

    public TableFilterCriteria() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
