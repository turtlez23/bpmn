package com.example.demo.bpmn.model.element.flow.instance;

import com.example.demo.bpmn.model.element.flow.FlowElementBasicBpmn;
import lombok.Getter;
import org.camunda.bpm.model.bpmn.instance.FlowElement;
import org.json.JSONObject;

@Getter
public class StartEventBpmn extends FlowElementBasicBpmn {

    public StartEventBpmn(FlowElement element) throws Exception {
        super(element);
    }

    @Override
    public Class getFlowElementBpmnType() {
        return StartEventBpmn.class;
    }

    @Override
    public JSONObject toJson() {
        return null;
    }
}
