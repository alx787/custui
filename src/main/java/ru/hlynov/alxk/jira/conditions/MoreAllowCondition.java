package ru.hlynov.alxk.jira.conditions;

import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.security.JiraAuthenticationContext;
import com.atlassian.jira.user.ApplicationUser;
import com.atlassian.plugin.PluginParseException;
import com.atlassian.plugin.web.Condition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.hlynov.alxk.api.PluginSettingServiceCustUi;
import ru.hlynov.alxk.jira.ConfigTools;

import javax.inject.Inject;
import java.util.Map;

public class MoreAllowCondition implements Condition {
    private static final Logger log = LoggerFactory.getLogger(UserNameAllowCondition.class);
    private JiraAuthenticationContext authContext = ComponentAccessor.getJiraAuthenticationContext();

    private final PluginSettingServiceCustUi pluginSettingService;

    @Inject
    public MoreAllowCondition(PluginSettingServiceCustUi pluginSettingService) {
        this.pluginSettingService = pluginSettingService;
    }

    @Override
    public void init(Map<String, String> map) throws PluginParseException {

    }

    @Override
    public boolean shouldDisplay(Map<String, Object> map) {
        if (authContext.isLoggedInUser()) {
            String cfg = pluginSettingService.getConfigJson();
            if(ConfigTools.GetPermission(cfg, "hideMore")) {

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
