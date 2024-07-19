package com.co.testchoucair.tasks;

import com.co.testchoucair.ui.RecruitmentPage;
import com.co.testchoucair.utilities.WebActions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.targets.Target;

import java.nio.file.Paths;

public class UploadTask implements Task {

    private final Target fileInput;
    private final String filePath;
    private final WebActions webActions;

    public UploadTask(Target fileInput, String filePath, WebActions webActions) {
        this.fileInput = fileInput;
        this.filePath = filePath;
        this.webActions = webActions;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String absolutePath = Paths.get(filePath).toAbsolutePath().toString();
        actor.attemptsTo(
                webActions.highlightElement(RecruitmentPage.FILE_UPLOAD_INPUT),
                Upload.theFile(Paths.get(absolutePath)).to(fileInput)
        );
    }

    public static UploadTask withFile(Target fileInput, String filePath, WebActions webActions) {
        return Tasks.instrumented(UploadTask.class, fileInput, filePath, webActions);
    }

}
