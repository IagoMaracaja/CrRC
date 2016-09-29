package br.icmob.clashroyalerandomcards.model;

/**
 * Created by iago on 26/09/16.
 */

public class Filter {

    private int resourceId;
    private boolean isEnable;
    private String description;

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
