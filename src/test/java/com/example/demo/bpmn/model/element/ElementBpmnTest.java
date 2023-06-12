package com.example.demo.bpmn.model.element;

import org.camunda.bpm.model.bpmn.instance.UserTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import test.utils.TestBpmnUtils;

import static org.junit.jupiter.api.Assertions.*;

class ElementBpmnTest extends TestBpmnUtils {
    UserTask userTask;
    ElementBpmn element;

    @BeforeEach
    void setUp(){
        userTask = getUserTask();
        element  = Mockito.mock(
                ElementBpmn.class,
                Mockito.CALLS_REAL_METHODS);
    }

    @Test
    void identifyElement(){
        assertEquals(element.identifyElement(userTask), UserTask.class);
    }
}