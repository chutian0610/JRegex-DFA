package info.victor.jregex.utils.render;

public class MermaidConfig {
    private String theme = "forest";
    private String logLevel = "fatal";
    private String securityLevel = "strict";
    private Boolean startOnLoad = true;
    private Boolean arrowMarkerAbsolute = false;
    private Flowchart flowchart = new Flowchart();
    private Sequence sequence = new Sequence();
    private Gantt gantt = new Gantt();

    public Gantt getGantt() {
        return gantt;
    }

    public void setGantt(Gantt gantt) {
        this.gantt = gantt;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public String getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(String securityLevel) {
        this.securityLevel = securityLevel;
    }

    public Boolean getStartOnLoad() {
        return startOnLoad;
    }

    public void setStartOnLoad(Boolean startOnLoad) {
        this.startOnLoad = startOnLoad;
    }

    public Boolean getArrowMarkerAbsolute() {
        return arrowMarkerAbsolute;
    }

    public void setArrowMarkerAbsolute(Boolean arrowMarkerAbsolute) {
        this.arrowMarkerAbsolute = arrowMarkerAbsolute;
    }

    public Flowchart getFlowchart() {
        return flowchart;
    }

    public void setFlowchart(Flowchart flowchart) {
        this.flowchart = flowchart;
    }

    public Sequence getSequence() {
        return sequence;
    }

    public void setSequence(Sequence sequence) {
        this.sequence = sequence;
    }
}
