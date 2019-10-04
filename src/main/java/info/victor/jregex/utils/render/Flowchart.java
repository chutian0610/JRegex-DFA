package info.victor.jregex.utils.render;

public class Flowchart {
    private Boolean htmlLabels = true;
    private String curve = "linear";

    public Boolean getHtmlLabels() {
        return htmlLabels;
    }

    public void setHtmlLabels(Boolean htmlLabels) {
        this.htmlLabels = htmlLabels;
    }

    public String getCurve() {
        return curve;
    }

    public void setCurve(String curve) {
        this.curve = curve;
    }
}
