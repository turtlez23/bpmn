package com.example.demo.bpmn;

import com.example.demo.bpmn.model.element.flow.instance.UserTaskBpmn;
import org.camunda.bpm.model.bpmn.BpmnModelInstance;
import org.camunda.bpm.model.bpmn.instance.Definitions;
import org.camunda.bpm.model.bpmn.instance.Process;
import org.camunda.bpm.model.bpmn.instance.StartEvent;
import org.camunda.bpm.model.bpmn.instance.UserTask;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class BpmnReaderTest {

    private BpmnReader getBpmnReader() {
        Path path = Paths.get("src", "test", "resources", "diagram_uproszczony_us_person.bpmn");
        return new BpmnReader(path);
    }

    @Test
    public void readBpmnTest() {
        BpmnModelInstance modelInstance = getBpmnReader().getModelInstance();
        assertNotNull(modelInstance);
    }

    @Test
    public void getDefinitionsTest() {
        Definitions definitions = getBpmnReader().getDefinitions();
        assertNotNull(definitions);
        assertNotNull(definitions.getElementType());
        assertEquals("definitions", definitions.getElementType().getTypeName());
        assertEquals("http://www.omg.org/spec/BPMN/20100524/MODEL", definitions.getElementType().getTypeNamespace());
        assertNotNull(definitions.getDomElement());
        assertEquals("definitions", definitions.getDomElement().getLocalName());
        assertEquals("http://www.omg.org/spec/BPMN/20100524/MODEL", definitions.getDomElement().getNamespaceURI());
    }

    @Test
    public void getProcessTest() {
        Process process = getBpmnReader().getProcess();
        assertNotNull(process);
        assertEquals("Process_0iuslkh", process.getId());
        assertEquals(true, process.isExecutable());
        assertEquals(35, process.getFlowElements().size());
    }

    @Test
    public void getUserTaskFirstQuestionTest() {
        UserTask userTask = getBpmnReader().getUserTasks().iterator().next();
        assertNotNull(userTask);
        assertEquals("Pytanie_I", userTask.getId());
        assertEquals("I", userTask.getCamundaFormKey());
    }

    @Test
    public void getStartEventTest() {
        StartEvent startEvent = getBpmnReader().getStartEvent();
        assertEquals("StartEvent_1", startEvent.getId());
        assertEquals("Oświadczenie dotyczące transgranicznych Transakcji Swap 1", startEvent.getName());

    }

    @Test
    public void getUserTaskWithFullPropertiesAndForm() throws Exception {
        UserTask userTask = getBpmnReader().getUserTasks().iterator().next();
        UserTaskBpmn userTaskBpmn = new UserTaskBpmn(userTask);
        assertNotNull(userTask);
        assertEquals("Pytanie_I", userTask.getId());
        assertNotNull(userTaskBpmn);
    }

}
