package com.example.demo.bpmn.model.element.extension.instance;

import com.example.demo.bpmn.model.element.ElementBpmn;
import com.example.demo.bpmn.model.element.ElementBpmnJson;
import lombok.Builder;
import lombok.Getter;
import org.json.JSONObject;

import java.util.Collection;

@Getter
@Builder
public class FormBpmn  extends ElementBpmn implements ElementBpmnJson {

    private String formKey;
    private Collection<FormFieldBpmn> fields;

    @Override
    public JSONObject toJson() {
        return null;
    }
}
