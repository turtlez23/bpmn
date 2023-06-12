package com.example.demo.bpmn.model.element.extension.instance;

import com.example.demo.bpmn.model.element.ElementBpmn;
import com.example.demo.bpmn.model.element.extension.FormExtensionProperties;
import lombok.Builder;
import lombok.Getter;
import org.camunda.bpm.model.bpmn.instance.camunda.CamundaFormField;
import org.camunda.bpm.model.bpmn.instance.camunda.CamundaProperty;
import org.json.JSONObject;

import java.util.Collection;

@Getter
@Builder
public class FormFieldBpmn extends ElementBpmn implements FormExtensionProperties {

    private String id;
    private String label;
    private String type;

    private String value;
    private String nextSelectedElement;
    private String annotation;

    @Override
    public Collection<CamundaProperty> getPropertiesFromExtensionElement(CamundaFormField camundaFormField) {
        return camundaFormField.getCamundaProperties().getCamundaProperties();
    }

    @Override
    public void setValuesFromExternalProperties(CamundaFormField camundaFormField) {
        for (CamundaProperty property : getPropertiesFromExtensionElement(camundaFormField)) {
            setValuesFromExternalProperty(property);
        }
    }

    @Override
    public void setValuesFromExternalProperty(CamundaProperty property) {
        switch (property.getCamundaId()) {
            case "annotation":
                annotation = property.getCamundaValue();
                break;
            case "value":
                value = property.getCamundaValue();
                break;
            case "nextSelectedElement":
                nextSelectedElement = property.getCamundaValue();
                break;
        }
    }

    @Override
    public JSONObject toJson() {
        return null;
    }
}
