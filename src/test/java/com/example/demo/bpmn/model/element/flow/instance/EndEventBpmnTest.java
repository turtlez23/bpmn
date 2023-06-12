package com.example.demo.bpmn.model.element.flow.instance;

import org.camunda.bpm.model.bpmn.instance.EndEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import test.utils.TestBpmnUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EndEventBpmnTest extends TestBpmnUtils {

    EndEvent endEvent;
    EndEventBpmn endEventBpmn;
    @BeforeEach
    void setUp() throws Exception {
        endEvent = getEndEvent();
        endEventBpmn = new EndEventBpmn(endEvent);
    }

    @Test
    void initEndEventBpmn(){
        assertEquals("Event_0x5vc3o", endEventBpmn.getId());
        assertEquals("Koniec", endEventBpmn.getName());
    }

    @Test
    void getFlowElementBpmnType() {
        assertEquals(EndEventBpmn.class, endEventBpmn.getFlowElementBpmnType());
    }

    @Test
    @Disabled("NotImplementedYet")
    void toJson() {
    }
}