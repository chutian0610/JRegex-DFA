package info.victor.jregex.utils.render;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MermaidRender {
    private MermaidConfig mermaidConfig=new MermaidConfig();
    private ChartBuilder chartBuilder;
    public MermaidConfig getMermaidConfig() {
        return mermaidConfig;
    }

    public void setMermaidConfig(MermaidConfig mermaidConfig) {
        this.mermaidConfig = mermaidConfig;
    }

    private String cdn = "https://unpkg.com/mermaid@8/dist/mermaid.min.js";
    public String getCdn() {
        return cdn;
    }

    public void setCdn(String cdn) {
        this.cdn = cdn;
    }

    public void render(String path) {
        if(path == null || path.equals("")){
            throw new IllegalArgumentException("file path must not empty!");
        }

        try(FileWriter fileWriter = new FileWriter(new File(path))){
            fileWriter.write(build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String build(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE html>\n")
                .append("<html>\n");
        buildHead(stringBuilder);
        buildBody(stringBuilder);
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }
    private void buildBody(StringBuilder stringBuilder){
        stringBuilder.append("<body>\n")
                .append("<div class=\"mermaid\">\n");
        // contents
        stringBuilder.append(String.join("\n",chartBuilder.build())).append("\n");
        stringBuilder.append("</div>\n")
                .append("<script>\n");
        // script
        stringBuilder.append("var config = ")
                .append(JSON.toJSONString(mermaidConfig, SerializerFeature.PrettyFormat))
                .append(";\n")
                .append("mermaid.initialize(config);\n");
        stringBuilder.append("</script>\n")
                .append("</body>\n")
                ;
    }

    private void buildHead(StringBuilder stringBuilder){
        stringBuilder
                .append("<head>\n")
                .append("<script src=\"").append(cdn).append("\"></script>")
                .append("</head>\n");
    }

    public ChartBuilder getChartBuilder() {
        return chartBuilder;
    }

    public void setChartBuilder(ChartBuilder chartBuilder) {
        this.chartBuilder = chartBuilder;
    }

    public static void main(String[] args) {
        MermaidRender mermaidRender = new MermaidRender();
        mermaidRender.setChartBuilder(
                new FlowChartBuilder().direction("LR")
                        .link("A","nodeA","B","nodeB")
                        .link2("B","C","nodeC"));
        mermaidRender.render("/Users/chutian/Downloads/test.html");
    }
}
