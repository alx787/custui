package ru.hlynov.oit.jira.webwork;

import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.atlassian.jira.web.action.JiraWebActionSupport;
import ru.hlynov.oit.api.PluginSettingService;
import ru.hlynov.oit.jira.ConfigTools;

import javax.inject.Inject;

public class SetupCustomUiPlugin extends JiraWebActionSupport
{
    private static final Logger log = LoggerFactory.getLogger(SetupCustomUiPlugin.class);

    private final PluginSettingService pluginSettingService;

    private String showUserName;
    private String showUserNameCheck;

    private String hideEdit;
    private String hideEditCheck;

    private String hideComment;
    private String hideCommentCheck;

    private String hideMore;
    private String hideMoreCheck;

    private String hideAssign;
    private String hideAssignCheck;

    private String notForAdmin;
    private String notForAdminCheck;

    @Inject
    public SetupCustomUiPlugin(PluginSettingService pluginSettingService) {
        this.pluginSettingService = pluginSettingService;
    }

    @Override
    public String doDefault() throws Exception {

        String cfg = pluginSettingService.getConfigJson();

        if (cfg == null) {
            return SUCCESS;
        }

        if (cfg.isEmpty()) {
            return SUCCESS;
        }


        showUserName = null;
        if (ConfigTools.GetPermission(cfg, "showUserName")) {
            showUserName = "on";
        }

        hideEdit = null;
        if (ConfigTools.GetPermission(cfg, "hideEdit")) {
            hideEdit = "on";
        }

        hideComment = null;
        if (ConfigTools.GetPermission(cfg, "hideComment")) {
            hideComment = "on";
        }

        hideMore = null;
        if (ConfigTools.GetPermission(cfg, "hideMore")) {
            hideMore = "on";
        }

        hideAssign = null;
        if (ConfigTools.GetPermission(cfg, "hideAssign")) {
            hideAssign = "on";
        }

        notForAdmin = null;
        if (ConfigTools.GetPermission(cfg, "notForAdmin")) {
            notForAdmin = "on";
        }


        return SUCCESS;
    }

    public String doSave() throws Exception {

//        передаваемые параметры
//        showUserName: on
//        hideEdit: on
//        hideComment: on
//        hideMore: on
//        notForAdmin: on

//        checked="checked"

        JsonObject params = new JsonObject();

        if (showUserName == null) {
            params.addProperty("showUserName", "off");
        } else {
            params.addProperty("showUserName", "on");
        }

        if (hideEdit == null) {
            params.addProperty("hideEdit", "off");
        } else {
            params.addProperty("hideEdit", "on");
        }

        if (hideComment == null) {
            params.addProperty("hideComment", "off");
        } else {
            params.addProperty("hideComment", "on");
        }

        if (hideMore == null) {
            params.addProperty("hideMore", "off");
        } else {
            params.addProperty("hideMore", "on");
        }

        if (hideAssign == null) {
            params.addProperty("hideAssign", "off");
        } else {
            params.addProperty("hideAssign", "on");
        }

        if (notForAdmin == null) {
            params.addProperty("notForAdmin", "off");
        } else {
            params.addProperty("notForAdmin", "on");
        }


        pluginSettingService.setConfigJson(params.toString());

//        //return super.doDefault();
//        log.warn("========= ============");
//        log.warn("========= save");
//        log.warn("========= " + params.toString());
        return SUCCESS;
    }


    @Override
    public String execute() throws Exception {
        super.execute();
        return SUCCESS;
        //return super.execute(); //returns SUCCESS
    }

    public String getShowUserName() {
        return showUserName;
    }

    public void setShowUserName(String showUserName) {
        this.showUserName = showUserName;
    }

    public String getHideEdit() {
        return hideEdit;
    }

    public void setHideEdit(String hideEdit) {
        this.hideEdit = hideEdit;
    }

    public String getHideComment() {
        return hideComment;
    }

    public void setHideComment(String hideComment) {
        this.hideComment = hideComment;
    }

    public String getHideMore() {
        return hideMore;
    }

    public void setHideMore(String hideMore) {
        this.hideMore = hideMore;
    }

    public String getHideAssign() {
        return hideAssign;
    }

    public void setHideAssign(String hideAssign) {
        this.hideAssign = hideAssign;
    }

    public String getNotForAdmin() {
        return notForAdmin;
    }

    public void setNotForAdmin(String notForAdmin) {
        this.notForAdmin = notForAdmin;
    }

    ///////////////////////////////////////////////////////////////////////

    // setters for
    public String getShowUserNameCheck() {
        if (showUserName == null) {
            return "";
        } else {
            return "checked=checked";
        }
    }

    public String getHideEditCheck() {
        if (hideEdit == null) {
            return "";
        } else {
            return "checked=checked";
        }
    }

    public String getHideCommentCheck() {
        if (hideComment == null) {
            return "";
        } else {
            return "checked=checked";
        }
    }

    public String getHideMoreCheck() {
        if (hideMore == null) {
            return "";
        } else {
            return "checked=checked";
        }
    }

    public String getHideAssignCheck() {
        if (hideAssign == null) {
            return "";
        } else {
            return "checked=checked";
        }
    }

    public String getNotForAdminCheck() {
        if (notForAdmin == null) {
            return "";
        } else {
            return "checked=checked";
        }
    }
}
