package com.example.demo.bpmn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.camunda.bpm.model.bpmn.Bpmn;
import org.camunda.bpm.model.bpmn.BpmnModelInstance;

import org.camunda.bpm.model.bpmn.instance.*;
import org.camunda.bpm.model.bpmn.instance.Process;

import java.io.File;
import java.nio.file.Path;
import java.util.Collection;

@NoArgsConstructor
@Getter
public class BpmnReader {
    private BpmnModelInstance modelInstance;

    public BpmnReader(Path path) {
        super();
        modelInstance = loadBpmn(path.toString());
    }

    public BpmnModelInstance loadBpmn(String path) {
        BpmnModelInstance modelInstance = Bpmn.readModelFromFile(new File(path));
        return modelInstance;
    }

    public Definitions getDefinitions() {
        return modelInstance.getDefinitions();
    }

    public Process getProcess() {
        return modelInstance.getModelElementsByType(Process.class).iterator().next();
    }

    public StartEvent getStartEvent() {
        return modelInstance.getModelElementsByType(StartEvent.class).iterator().next();
    }

    public EndEvent getEndEvent() {
        return modelInstance.getModelElementsByType(EndEvent.class).iterator().next();
    }

    public Collection<FlowElement> getFlowElements() {
        return getProcess().getFlowElements();
    }

    public Collection<UserTask> getUserTasks() {
        return modelInstance.getModelElementsByType(UserTask.class);
    }

    public Collection<ExclusiveGateway> getExclusiveGateways() {
        return modelInstance.getModelElementsByType(ExclusiveGateway.class);
    }
    public Collection<ParallelGateway> getParallelGateway() {
        return modelInstance.getModelElementsByType(ParallelGateway.class);
    }
}