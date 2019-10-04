package info.victor.jregex.utils.render;

import java.util.ArrayList;
import java.util.List;

public class FlowChartBuilder implements ChartBuilder{
    private String direction;
    private List<String> contents = new ArrayList<>();
    public List<String> build(){
        return contents;
    }

    public FlowChartBuilder direction(String direction){
        this.direction = direction;
        contents.add("graph "+ direction);
        return this;
    }

    public FlowChartBuilder link(String id1,String message1,String id2,String message2,String linkMessage){
        contents.add(id1+"[\""+message1+"\"]"+"-->"+"|"+linkMessage+"|"+id2+"[\""+message2+"\"]");
        return this;
    }

    public FlowChartBuilder link(String id1,String message1,String id2,String message2){
        contents.add(id1+"[\""+message1+"\"]"+"-->"+id2+"[\""+message2+"\"]");
        return this;
    }

    public FlowChartBuilder link2(String id1,String id2,String message2){
        contents.add(id1+"-->"+id2+"[\""+message2+"\"]");
        return this;
    }

    public FlowChartBuilder link1(String id1,String id2,String message1){
        contents.add(id1+"[\""+message1+"\"]"+"-->"+id2);
        return this;
    }

}