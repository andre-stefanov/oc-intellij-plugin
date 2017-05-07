package de.andrestefanov.idea.opencomputers.run;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.util.IconLoader;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class OCConfigurationType implements ConfigurationType {

    @Override
    public String getDisplayName() {
        return "OpenComputers";
    }

    @Override
    public String getConfigurationTypeDescription() {
        return "Deploy .lua script directly to an OpenComputers computer";
    }

    @Override
    public Icon getIcon() {
        return IconLoader.getIcon("/logo_16x16.png");
//        return AllIcons.RunConfigurations.Remote;
    }

    @NotNull
    @Override
    public String getId() {
        return "#de.andrestefanov.idea.opencomputers.run.OCConfigurationType";
    }

    @Override
    public ConfigurationFactory[] getConfigurationFactories() {
        return new ConfigurationFactory[]{new OCConfigurationFactory(this)};
    }
}
