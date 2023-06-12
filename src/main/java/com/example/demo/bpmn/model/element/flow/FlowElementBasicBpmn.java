package com.example.demo.bpmn.model.element.flow;

import com.example.demo.bpmn.model.element.ElementBpmn;
import com.example.demo.bpmn.model.element.ElementBpmnJson;
import lombok.Getter;
import org.camunda.bpm.model.bpmn.instance.FlowElement;

import java.util.Collection;
import java.util.LinkedList;

@Getter
public abstract class FlowElementBasicBpmn extends ElementBpmn implements ElementBpmnJson, FlowElementType {

    protected final FlowElement element;
    protected String id;
    protected String name;

    protected Collection<FlowElementBpmn> incoming;
    protected Collection<FlowElementBpmn> outgoing;

    protected void initFlowElements(){
        incoming = new LinkedList<FlowElementBpmn>();
        outgoing = new LinkedList<FlowElementBpmn>();
    }

    public FlowElementBasicBpmn(FlowElement element) throws Exception {
        this.element = element;
        this.id = element.getId();
        this.name = element.getName();
        initFlowElements();
    }
}
