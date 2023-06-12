package com.example.demo.bpmn;

import com.example.demo.bpmn.model.element.flow.FlowElementBpmn;
import com.example.demo.bpmn.model.element.ElementBpmnJson;
import com.example.demo.bpmn.model.element.flow.instance.StartEventBpmn;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.model.bpmn.instance.FlowElement;
import org.camunda.bpm.model.bpmn.instance.StartEvent;
import org.json.JSONObject;

@RequiredArgsConstructor
public class FlowElementDataSerializer {

    private final FlowElement element;

    private Class identifyElement() {
        return element.getElementType().getInstanceType();
    }

//    public JSONObject getElementJson() throws Exception {
//        return ((ElementBpmnJson) getElementObject()).toJson();
//    }

//    public FlowElementBpmn getElementObject() throws Exception {
//        if (identifyElement() == StartEvent.class) {
//            return new StartEventBpmn(element);
//        }
//        return null;
//    }
}
