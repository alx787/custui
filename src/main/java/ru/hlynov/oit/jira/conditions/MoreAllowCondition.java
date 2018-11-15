package ru.hlynov.oit.jira.conditions;

import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.security.JiraAuthenticationContext;
import com.atlassian.plugin.PluginParseException;
import com.atlassian.plugin.web.Condition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class MoreAllowCondition implements Condition {
    private static final Logger log = LoggerFactory.getLogger(UserNameAllowCondition.class);
    private JiraAuthenticationContext authContext = ComponentAccessor.getJiraAuthenticationContext();

    @Override
    public void init(Map<String, String> map) throws PluginParseException {

    }

    @Override
    public boolean shouldDisplay(Map<String, Object> map) {
        log.warn("= more =============================== " + authContext.getLoggedInUser().getName());
//        return true;
        return false;
    }

}
