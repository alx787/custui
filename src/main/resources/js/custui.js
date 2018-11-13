AJS.toInit(function(){

    // show username
    var avatar = AJS.$("a#header-details-user-fullname");
    var username = avatar.attr("data-displayname");
    avatar.append("<span>" + username + "</span>");

    // hide edit
    // console.log("===================");
    // console.log(AJS.$("#opsbar-edit-issue_container"));
    // console.log(AJS.$("#opsbar-edit-issue_container").size());
    //AJS.$("#opsbar-edit-issue_container").hide();
    // console.log(AJS.$("#edit-issue"));
    // console.log(AJS.$("#edit-issue").size());
    // // AJS.$("#edit-issue").hide();
    //
    // AJS.$("#edit-issue").css("display", "none");
    // пункты в админке

    // 1 Включить плагин

    // 2 Показать фио
    // 3 Скрыть меню Редактировать
    // 4 Скрыть меню Еще - или каждую кнопку в отдельности

    // 5 пользователи на которых меню действовать не будет

    //https://developer.atlassian.com/cloud/jira/platform/issue-view-ui-locations/

})
