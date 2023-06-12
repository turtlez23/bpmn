package com.example.demo.bpmn.model.element.extension;

import org.camunda.bpm.model.bpmn.instance.camunda.CamundaProperty;
import org.camunda.bpm.model.xml.instance.ModelElementInstance;

import java.util.Collection;

public interface ExtensionProperties {
    Collection<CamundaProperty> getPropertiesFromExtensionElement(ModelElementInstance element);

    void setValuesFromExtensionProperties(ModelElementInstance element);

    void setValuesFromExtensionProperty(CamundaProperty property);
}
