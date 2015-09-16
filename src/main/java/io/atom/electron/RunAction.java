package io.atom.electron;

import java.awt.event.ActionEvent;
import org.netbeans.api.extexecution.ExecutionService;
import org.netbeans.api.extexecution.ProcessBuilder;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.loaders.DataObject;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Build",
        id = "io.atom.electron.RunAction"
)
@ActionRegistration(
        displayName = "#CTL_RunAction"
)
@ActionReferences({
    @ActionReference(path = "Loaders/text/javascript/Actions", position = 655),
    @ActionReference(path = "Editors/text/javascript/Popup", position = 5055)
})
@Messages("CTL_RunAction=Run with Electron")
public class RunAction extends AbstractElectronAction {
    private static final String ELECTRON = "Electron";

    public RunAction(DataObject context) {
        super(context);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        ProcessBuilder processBuilder = createProcessBuilder();
        ExecutionService service = ExecutionService.newService(processBuilder, getDescriptor(), ELECTRON);
        createObserver().observe(service.run());
    }
}
