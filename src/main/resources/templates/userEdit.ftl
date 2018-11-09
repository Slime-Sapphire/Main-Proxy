<#import "parts/common.ftl" as c>

<@c.page>
    User editor
    <form action="/user" method="post">
        <div>Username <label><input type="text" name="username" value="${user.username}"></label></div>
        <#list roles as role>
            <div>${role} <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}></label></div>
        </#list>
        <label><input type="hidden" value="${user.id}" name="userId"></label>
        <@c.token/>
        <button type="submit">Save</button>
    </form>
</@c.page>