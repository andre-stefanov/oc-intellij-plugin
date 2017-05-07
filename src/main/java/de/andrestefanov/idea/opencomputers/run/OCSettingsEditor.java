package de.andrestefanov.idea.opencomputers.run;

import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class OCSettingsEditor extends SettingsEditor<RunConfiguration> {

    private JPanel rootPanel;
    private JTextField textField1;
    private JComboBox comboBox1;

    @Override
    protected void resetEditorFrom(@NotNull RunConfiguration runConfiguration) {

    }

    @Override
    protected void applyEditorTo(@NotNull RunConfiguration runConfiguration) throws ConfigurationException {

    }

    @NotNull
    @Override
    protected JComponent createEditor() {
        return rootPanel;
    }
}
