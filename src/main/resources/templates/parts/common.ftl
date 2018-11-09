<#macro page>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Proxy</title>
</head>
<body>
<#nested>
</body>
</html>
</#macro>

<#macro token>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
</#macro>