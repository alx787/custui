package ru.hlynov.oit.jira.conditions;

//import com.atlassian.plugin.web.Condition;

//import com.atlassian.jira.plugin.webfragment.conditions.JiraGlobalPermissionCondition;

import com.atlassian.jira.plugin.webfragment.conditions.AbstractWebCondition;
import com.atlassian.jira.plugin.webfragment.model.JiraHelper;
import com.atlassian.jira.user.ApplicationUser;
import com.atlassian.plugin.PluginParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


public class UserAllowCondition extends AbstractWebCondition {

    private static final Logger log = LoggerFactory.getLogger(UserAllowCondition.class);

    @Override
    public void init(Map<String, String> params) throws PluginParseException {
        super.init(params);
    }

    @Override
    public boolean shouldDisplay(ApplicationUser applicationUser, JiraHelper jiraHelper) {
//        return false;

        log.warn("================================ " + applicationUser.toString());

        return true;
    }
}
