package cuke4duke.ant;

import org.apache.tools.ant.BuildException;

public class GemTask extends JRubyTask {
    private String args = "";

    public GemTask() {
        createJvmarg().setValue("-Xmx384m");
    }

    public void execute() throws BuildException {
        createArg().setValue("-S");
        createArg().setValue("gem");
        getCommandLine().createArgument().setLine(args);
        createArg().setValue("--install-dir");
        createArg().setFile(getJrubyHome());
        createArg().setValue("--no-ri");
        createArg().setValue("--no-rdoc");

        try {
            super.execute();
        } catch (Exception e) {
            throw new BuildException("Failed to run gem with arguments: " + args, e);
        }
    }

    public void setArgs(String args) {
        this.args = args;
    }
}
