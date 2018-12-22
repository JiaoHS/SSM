<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>登录</title>
    <%
        String APP_PATH=request.getContextPath();
//	pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <link href="${APP_PATH}/static/asserts/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${APP_PATH}/static/asserts/css/signin.css" rel="stylesheet">
</head>
<body>
<form class="form-signin" action="/user/login"  method="post">
    <img class="mb-4"  src="${APP_PATH}/static/asserts/img/bootstrap-solid.svg" alt="" width="72" height="72">
    <h1 class="h3 mb-3 font-weight-normal" >Please sign in</h1>
    <p style="color: red"  ></p>
    <p style="color: red"  text="${strings.isEmpty(msg)?"":msg}"></p>
    <label class="sr-only" >Username</label>
    <input name="username" type="text" class="form-control" placeholder="Username" required="" autofocus="" value="jiao">
    <label class="sr-only">Password</label>
    <input name="password" type="password" class="form-control" placeholder="Password" required="" value="123456">
    <div class="checkbox mb-3">
        <label>
            <input type="checkbox" value="remember-me" >记住我
        </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit" >Sign in</button>
    <p class="mt-5 mb-3 text-muted">© 2017-2018</p>
    <%--<a class="btn btn-sm">??</a>--%>
    <%--<a class="btn btn-sm" >English</a>--%>
</form>
</body>
</html>