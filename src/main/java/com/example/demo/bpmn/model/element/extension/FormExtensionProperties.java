package com.example.demo.bpmn.model.element.extension;

import org.camunda.bpm.model.bpmn.instance.camunda.CamundaFormField;
import org.camunda.bpm.model.bpmn.instance.camunda.CamundaProperty;

import java.util.Collection;

public interface FormExtensionProperties {
    Collection<CamundaProperty> getPropertiesFromExtensionElement(CamundaFormField camundaFormField);

    void setValuesFromExternalProperties(CamundaFormField camundaFormField);

    void setValuesFromExternalProperty(CamundaProperty property);
}
