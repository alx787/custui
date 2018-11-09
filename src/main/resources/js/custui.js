AJS.toInit(function(){

    // show username
    var username = AJS.$("a#header-details-user-fullname").attr("data-displayname");
    AJS.$("a#header-details-user-fullname").append("<span>" + username + "</span>");

    // hide edit
    AJS.$("#opsbar-edit-issue_container").hide();

    // пункты в админке

    // 1 Включить плагин

    // 2 Показать фио
    // 3 Скрыть меню Редактировать
    // 4 Скрыть меню Еще - или каждую кнопку в отдельности

    // 5 пользователи на которых меню действовать не будет

})
