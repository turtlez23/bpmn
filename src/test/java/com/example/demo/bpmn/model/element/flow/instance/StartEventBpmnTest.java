package com.example.demo.bpmn.model.element.flow.instance;

import org.camunda.bpm.model.bpmn.instance.StartEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import test.utils.TestBpmnUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StartEventBpmnTest extends TestBpmnUtils {

    StartEvent startEvent;
    StartEventBpmn startEventBpmn;

    @BeforeEach
    void setUp() throws Exception {
        startEvent = getStartEvent();
        startEventBpmn = new StartEventBpmn(startEvent);
    }
    @Test
    void initStartEventBpmn(){
        assertEquals("StartEvent_1", startEventBpmn.getId());
        assertEquals("Oświadczenie dotyczące transgranicznych Transakcji Swap 1", startEventBpmn.getName());
    }
//    @Test
//    void initExtensionElementsWithExtensionsElements() throws Exception {
//        ArrayList array  = new ArrayList<Object>(){{add(new Object());}};
//        StartEventBpmn badStartEventBpmn = Mockito.mock(StartEventBpmn.class, Mockito.withSettings()
//                .useConstructor(startEvent)
//                .defaultAnswer(Mockito.CALLS_REAL_METHODS));
//        Mockito.when(badStartEventBpmn.getExtensionElements())
//                .thenReturn(array);
//        Exception thrown = assertThrows(Exception.class, () -> {
//            badStartEventBpmn.initExtensionElements();
//        });
//        assertEquals("ElementNotAllowedStructureException", thrown.getMessage());
//    }

    @Test
    void getFlowElementBpmnType() {
        assertEquals(StartEventBpmn.class, startEventBpmn.getFlowElementBpmnType());
    }

    @Test
    @Disabled("NotImplementedYet")
    void toJson() {

    }
}