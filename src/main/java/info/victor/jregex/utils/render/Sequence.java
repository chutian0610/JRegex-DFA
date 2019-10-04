package info.victor.jregex.utils.render;

public class Sequence {
    private Integer diagramMarginX = 50;
    private Integer diagramMarginY= 10;
    private Integer actorMargin=50;
    private Integer width=150;
    private Integer height=65;
    private Integer boxMargin =10;
    private Integer boxTextMargin=5;
    private Integer noteMargin=10;
    private Integer messageMargin=35;
    private Boolean mirrorActors=true;
    private Integer bottomMarginAdj=1;
    private Boolean useMaxWidth=true;
    private Boolean rightAngles=false;
    private Boolean showSequenceNumbers=false;

    public Integer getDiagramMarginX() {
        return diagramMarginX;
    }

    public void setDiagramMarginX(Integer diagramMarginX) {
        this.diagramMarginX = diagramMarginX;
    }

    public Integer getDiagramMarginY() {
        return diagramMarginY;
    }

    public void setDiagramMarginY(Integer diagramMarginY) {
        this.diagramMarginY = diagramMarginY;
    }

    public Integer getActorMargin() {
        return actorMargin;
    }

    public void setActorMargin(Integer actorMargin) {
        this.actorMargin = actorMargin;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getBoxMargin() {
        return boxMargin;
    }

    public void setBoxMargin(Integer boxMargin) {
        this.boxMargin = boxMargin;
    }

    public Integer getBoxTextMargin() {
        return boxTextMargin;
    }

    public void setBoxTextMargin(Integer boxTextMargin) {
        this.boxTextMargin = boxTextMargin;
    }

    public Integer getNoteMargin() {
        return noteMargin;
    }

    public void setNoteMargin(Integer noteMargin) {
        this.noteMargin = noteMargin;
    }

    public Integer getMessageMargin() {
        return messageMargin;
    }

    public void setMessageMargin(Integer messageMargin) {
        this.messageMargin = messageMargin;
    }

    public Boolean getMirrorActors() {
        return mirrorActors;
    }

    public void setMirrorActors(Boolean mirrorActors) {
        this.mirrorActors = mirrorActors;
    }

    public Integer getBottomMarginAdj() {
        return bottomMarginAdj;
    }

    public void setBottomMarginAdj(Integer bottomMarginAdj) {
        this.bottomMarginAdj = bottomMarginAdj;
    }

    public Boolean getUseMaxWidth() {
        return useMaxWidth;
    }

    public void setUseMaxWidth(Boolean useMaxWidth) {
        this.useMaxWidth = useMaxWidth;
    }

    public Boolean getRightAngles() {
        return rightAngles;
    }

    public void setRightAngles(Boolean rightAngles) {
        this.rightAngles = rightAngles;
    }

    public Boolean getShowSequenceNumbers() {
        return showSequenceNumbers;
    }

    public void setShowSequenceNumbers(Boolean showSequenceNumbers) {
        this.showSequenceNumbers = showSequenceNumbers;
    }
}
