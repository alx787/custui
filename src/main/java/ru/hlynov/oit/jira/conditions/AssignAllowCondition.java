package ru.hlynov.oit.jira.conditions;

import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.security.JiraAuthenticationContext;
//import com.atlassian.jira.security.PermissionManager;
import com.atlassian.jira.user.ApplicationUser;
//import com.atlassian.jira.user.util.UserUtil;
import com.atlassian.plugin.PluginParseException;
import com.atlassian.plugin.web.Condition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.hlynov.oit.api.PluginSettingService;
import ru.hlynov.oit.jira.ConfigTools;

import javax.inject.Inject;
import java.util.Map;

public class AssignAllowCondition implements Condition {
    private static final Logger log = LoggerFactory.getLogger(AssignAllowCondition.class);
    private JiraAuthenticationContext authContext = ComponentAccessor.getJiraAuthenticationContext();

    private final PluginSettingService pluginSettingService;

    @Inject
    public AssignAllowCondition(PluginSettingService pluginSettingService) {
        this.pluginSettingService = pluginSettingService;
    }

    @Override
    public void init(Map<String, String> map) throws PluginParseException {
    }

    @Override
    public boolean shouldDisplay(Map<String, Object> map) {
        if (authContext.isLoggedInUser()) {
            String cfg = pluginSettingService.getConfigJson();
            if(ConfigTools.GetPermission(cfg, "hideAssign")) {

                if(ConfigTools.GetPermission(cfg, "notForAdmin")) {
                    // проверка если установлена опция "у админов не скрывать"
                    ApplicationUser user = this.authContext.getLoggedInUser();

                    if (ComponentAccessor.getUserUtil().getJiraAdministrators().contains(user)) {
                        return false;
                    }
                }
                return true;
            }
        };
        return false;
    }

}
