package ru.hlynov.oit.jira.webwork;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.atlassian.jira.web.action.JiraWebActionSupport;

public class SetupCustomUiPlugin extends JiraWebActionSupport
{
    private static final Logger log = LoggerFactory.getLogger(SetupCustomUiPlugin.class);


    @Override
    public String doDefault() throws Exception {
        //return super.doDefault();
        log.warn("========= default");
        return SUCCESS;
    }

    public String doSave() throws Exception {
        //return super.doDefault();
        log.warn("========= save");
        return SUCCESS;
    }


    @Override
    public String execute() throws Exception {
        super.execute();
        return SUCCESS;

        //return super.execute(); //returns SUCCESS
    }
}
