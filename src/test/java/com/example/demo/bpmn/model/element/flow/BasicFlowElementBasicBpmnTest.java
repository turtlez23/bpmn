package com.example.demo.bpmn.model.element.flow;

import org.camunda.bpm.model.bpmn.instance.UserTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import test.utils.TestBpmnUtils;

class BasicFlowElementBasicBpmnTest extends TestBpmnUtils {
    UserTask userTaskElement;
    FlowElementBasicBpmn element;
    @BeforeEach
    void setUp(){
        userTaskElement = getUserTask();
        element  = Mockito.mock(
                FlowElementBasicBpmn.class,
                Mockito.CALLS_REAL_METHODS);
    }

    @Test()
    @Disabled("NotImplementedYet")
    void initFlowElements() {
    }
}