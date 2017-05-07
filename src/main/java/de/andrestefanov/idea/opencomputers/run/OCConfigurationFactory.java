package de.andrestefanov.idea.opencomputers.run;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

public class OCConfigurationFactory extends ConfigurationFactory {

    private static final String FACTORY_NAME = "OpenComputers configuration factory";

    protected OCConfigurationFactory(ConfigurationType type) {
        super(type);
    }

    @NotNull
    @Override
    public RunConfiguration createTemplateConfiguration(@NotNull Project project) {
        return new OCRunConfiguration(project, this, "OpenComputers");
    }

    @Override
    public String getName() {
        return FACTORY_NAME;
    }

}
