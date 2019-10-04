package info.victor.jregex.utils.render;

public class Gantt {
    private Integer titleTopMargin=25;
    private Integer barHeight=20;
    private Integer barGap=4;
    private Integer topPadding=50;
    private Integer leftPadding=75;
    private Integer gridLineStartPadding=35;
    private Integer fontSize=11;
    private String fontFamily="'Open-Sans', 'sans-serif'";
    private Integer numberSectionStyles=4;
    private String axisFormat="%Y-%m-%d";

    public Integer getTitleTopMargin() {
        return titleTopMargin;
    }

    public void setTitleTopMargin(Integer titleTopMargin) {
        this.titleTopMargin = titleTopMargin;
    }

    public Integer getBarHeight() {
        return barHeight;
    }

    public void setBarHeight(Integer barHeight) {
        this.barHeight = barHeight;
    }

    public Integer getBarGap() {
        return barGap;
    }

    public void setBarGap(Integer barGap) {
        this.barGap = barGap;
    }

    public Integer getTopPadding() {
        return topPadding;
    }

    public void setTopPadding(Integer topPadding) {
        this.topPadding = topPadding;
    }

    public Integer getLeftPadding() {
        return leftPadding;
    }

    public void setLeftPadding(Integer leftPadding) {
        this.leftPadding = leftPadding;
    }

    public Integer getGridLineStartPadding() {
        return gridLineStartPadding;
    }

    public void setGridLineStartPadding(Integer gridLineStartPadding) {
        this.gridLineStartPadding = gridLineStartPadding;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    public Integer getNumberSectionStyles() {
        return numberSectionStyles;
    }

    public void setNumberSectionStyles(Integer numberSectionStyles) {
        this.numberSectionStyles = numberSectionStyles;
    }

    public String getAxisFormat() {
        return axisFormat;
    }

    public void setAxisFormat(String axisFormat) {
        this.axisFormat = axisFormat;
    }
}
