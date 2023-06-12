package com.example.demo.bpmn.model.element.flow;

import com.example.demo.bpmn.model.element.extension.instance.FormBpmn;
import com.example.demo.bpmn.model.element.extension.ExtensionProperties;
import lombok.Getter;
import org.camunda.bpm.model.bpmn.instance.ExtensionElements;
import org.camunda.bpm.model.bpmn.instance.FlowElement;
import org.camunda.bpm.model.bpmn.instance.camunda.CamundaProperties;
import org.camunda.bpm.model.bpmn.instance.camunda.CamundaProperty;
import org.camunda.bpm.model.xml.instance.ModelElementInstance;

import java.util.Collection;

@Getter
public abstract class FlowElementBpmn extends FlowElementBasicBpmn implements FlowElementType, ExtensionProperties {
    protected String annotation;
    protected FormBpmn form;

    public FlowElementBpmn(FlowElement element) throws Exception {
        super(element);
        initExtensionElements();
    }

    protected abstract void initExtensionElements() throws Exception;

    @Override
    public Collection<CamundaProperty> getPropertiesFromExtensionElement(ModelElementInstance element) {
        return ((CamundaProperties) element).getCamundaProperties();
    }

    @Override
    public void setValuesFromExtensionProperty(CamundaProperty property) {
        switch (property.getCamundaName()) {
            case "annotation":
                annotation = property.getCamundaValue();
                break;
        }
    }

    @Override
    public void setValuesFromExtensionProperties(ModelElementInstance element) {
        for (CamundaProperty property : getPropertiesFromExtensionElement(element)) {
            setValuesFromExtensionProperty(property);
        }
    }

    public Collection<ModelElementInstance> getExtensionElements() {
        ExtensionElements extensionElements = element.getExtensionElements();
        return extensionElements != null ? extensionElements.getElements() : null;
    }

}
