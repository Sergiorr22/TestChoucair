package com.co.testchoucair.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class ListTask implements Task {

    private final Target dropdown;
    private final Target option;

    public ListTask(Target dropdown, Target option) {
        this.dropdown = dropdown;
        this.option = option;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(dropdown),
                Click.on(option)
        );
    }

    public static ListTask selectOption(Target dropdown, Target option) {
        return Tasks.instrumented(ListTask.class, dropdown, option);
    }
}
