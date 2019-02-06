package ru.hlynov.alxk.jira.conditions;

import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.security.JiraAuthenticationContext;
//import com.atlassian.jira.security.PermissionManager;
import com.atlassian.jira.user.ApplicationUser;
//import com.atlassian.jira.user.util.UserUtil;
import com.atlassian.plugin.PluginParseException;
import com.atlassian.plugin.web.Condition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.hlynov.alxk.api.PluginSettingServiceCustUi;
import ru.hlynov.alxk.jira.ConfigTools;


//import com.atlassian.jira.issue.IssueManager;
//import com.atlassian.jira.issue.Issue;
//import com.atlassian.jira.plugin.webfragment.model.JiraHelper;

//import com.atlassian.jira.plugin.webfragment.JiraWebInterfaceManager;


import javax.inject.Inject;
import java.util.Map;

public class AssignAllowCondition implements Condition {
    private static final Logger log = LoggerFactory.getLogger(AssignAllowCondition.class);
    private JiraAuthenticationContext authContext = ComponentAccessor.getJiraAuthenticationContext();

    private final PluginSettingServiceCustUi pluginSettingService;

    @Inject
    public AssignAllowCondition(PluginSettingServiceCustUi pluginSettingService) {
        this.pluginSettingService = pluginSettingService;
    }

    @Override
    public void init(Map<String, String> map) throws PluginParseException {
    }

    @Override
    public boolean shouldDisplay(Map<String, Object> map) {

//        JiraHelper jiraHelper = new JiraHelper();
//        Issue currentIssue = (Issue) jiraHelper.getContextParams().get("issue");
//        if (currentIssue == null) {
//            log.warn("===== ========= issue = null");
//        } else {
//            log.warn("===== ========= " + currentIssue.getKey());
//        }


//        log.warn("===== =========");
//        log.warn("===== ========= size: " + String.valueOf(map.size()));
//        // прочитаем параметры
//        for (Map.Entry<String, Object> entry : map.entrySet()) {
//            log.warn("===== entry key: " + entry.getKey() + " value: " + entry.getValue().toString());
//        }


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
