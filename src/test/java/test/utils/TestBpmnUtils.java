package test.utils;

import com.example.demo.bpmn.BpmnReader;
import com.example.demo.bpmn.model.element.flow.instance.UserTaskBpmn;
import org.camunda.bpm.model.bpmn.instance.EndEvent;
import org.camunda.bpm.model.bpmn.instance.StartEvent;
import org.camunda.bpm.model.bpmn.instance.UserTask;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestBpmnUtils {
    protected BpmnReader bpmnReader;

    protected BpmnReader getBpmnReader() {
        Path path = Paths.get("src", "test", "resources", "diagram_uproszczony_us_person.bpmn");
        return new BpmnReader(path);
    }

    protected UserTask getUserTask(){
        return getBpmnReader().getUserTasks().iterator().next();
    }

    protected StartEvent getStartEvent(){
        return getBpmnReader().getStartEvent();
    }

    protected EndEvent getEndEvent(){
        return getBpmnReader().getEndEvent();
    }

    protected UserTaskBpmn getUserTaskBpmn() throws Exception {
        UserTaskBpmn userTaskBpmn = new UserTaskBpmn(getUserTask());
        return userTaskBpmn;
    }


}
