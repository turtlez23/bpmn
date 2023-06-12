package com.example.demo.bpmn.model.element.flow;

import org.camunda.bpm.model.bpmn.instance.UserTask;
import org.camunda.bpm.model.bpmn.instance.camunda.CamundaProperties;
import org.camunda.bpm.model.xml.instance.ModelElementInstance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import test.utils.TestBpmnUtils;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class FlowElementBpmnTest extends TestBpmnUtils {

    UserTask userTask;
    FlowElementBpmn element;

    @BeforeEach
    void setUp() {
        userTask = getUserTask();
        element = Mockito.mock(FlowElementBpmn.class, Mockito.withSettings()
                .useConstructor(userTask)
                .defaultAnswer(Mockito.CALLS_REAL_METHODS));

    }

    @Test
    void setValuesFromExtensionProperties() {
        for (ModelElementInstance el : element.getExtensionElements()) {
            if (element.identifyElement(el) == CamundaProperties.class) {
                element.setValuesFromExtensionProperties(el);
            }
        }
        assertNotNull(element.getAnnotation());
        assertEquals("/Prosimy zaznaczyć jedno z poniższych pól/", element.getAnnotation());
    }
}