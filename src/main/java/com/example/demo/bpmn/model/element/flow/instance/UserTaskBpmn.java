package com.example.demo.bpmn.model.element.flow.instance;

import com.example.demo.bpmn.model.element.extension.instance.FormBpmn;
import com.example.demo.bpmn.model.element.extension.instance.FormFieldBpmn;
import com.example.demo.bpmn.model.element.flow.FlowElementBpmn;
import lombok.Getter;
import org.camunda.bpm.model.bpmn.instance.FlowElement;
import org.camunda.bpm.model.bpmn.instance.UserTask;
import org.camunda.bpm.model.bpmn.instance.camunda.CamundaFormData;
import org.camunda.bpm.model.bpmn.instance.camunda.CamundaFormField;
import org.camunda.bpm.model.bpmn.instance.camunda.CamundaProperties;
import org.camunda.bpm.model.xml.instance.ModelElementInstance;
import org.json.JSONObject;

import java.util.Collection;
import java.util.LinkedList;

@Getter
public class UserTaskBpmn extends FlowElementBpmn {

    @Override
    protected void initExtensionElements() {
        for (ModelElementInstance el : getExtensionElements()) {
            if (identifyElement(el) == CamundaFormData.class && ((UserTask) element).getCamundaFormKey() != null) {
                Collection<CamundaFormField> camundaFormFields = ((CamundaFormData) el).getCamundaFormFields();
                Collection<FormFieldBpmn> formFields = new LinkedList<>();
                for (CamundaFormField camundaFormField : camundaFormFields) {
                    FormFieldBpmn formField = FormFieldBpmn.builder()
                            .id(camundaFormField.getCamundaId())
                            .label(camundaFormField.getCamundaLabel())
                            .type(camundaFormField.getCamundaType())
                            .build();
                    formField.setValuesFromExternalProperties(camundaFormField);
                    formFields.add(formField);
                }
                form = FormBpmn.builder()
                        .formKey(((UserTask) element).getCamundaFormKey())
                        .fields(formFields)
                        .build();
            }
            if (identifyElement(el) == CamundaProperties.class) {
                setValuesFromExtensionProperties(el);
            }
        }
    }

    public UserTaskBpmn(FlowElement element) throws Exception {
        super(element);
    }

    @Override
    public Class getFlowElementBpmnType() {
        return UserTaskBpmn.class;
    }

    @Override
    public JSONObject toJson() {
        return null;
    }
}
