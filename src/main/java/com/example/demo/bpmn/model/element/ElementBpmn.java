package com.example.demo.bpmn.model.element;

import org.camunda.bpm.model.xml.instance.ModelElementInstance;

public abstract class ElementBpmn implements ElementBpmnJson{

    public Class identifyElement(ModelElementInstance element) {
        return element.getElementType().getInstanceType();
    }
}
