package com.example.demo.bpmn.model.element.flow.instance;

import org.camunda.bpm.model.bpmn.instance.UserTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import test.utils.TestBpmnUtils;

import static org.junit.jupiter.api.Assertions.*;

class UserTaskBpmnTest extends TestBpmnUtils {

    UserTask userTask;
    UserTaskBpmn userTaskBpmn;

    @BeforeEach
    void setUp() throws Exception {
        userTask = getUserTask();
        userTaskBpmn = new UserTaskBpmn(userTask);
    }

    @Test
    void initStartEventBpmn() {
        assertEquals("Pytanie_I", userTaskBpmn.getId());
        assertNull(userTaskBpmn.getName());
    }

    @Test
    void initExtensionElements() {
        assertEquals("/Prosimy zaznaczyć jedno z poniższych pól/", userTaskBpmn.getAnnotation());
        assertNotNull(userTaskBpmn.getForm());
        assertEquals("I", userTaskBpmn.getForm().getFormKey());
        assertEquals(userTaskBpmn.getForm().getFields().size(), 2);
    }

    @Test
    void getFlowElementBpmnType() {
        assertEquals(UserTaskBpmn.class, userTaskBpmn.getFlowElementBpmnType());
    }


    @Test
    @Disabled("NotImplementedYet")
    void toJson() {
    }
}