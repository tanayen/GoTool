<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Log in</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="${cp}/resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="${cp}/resources/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="${cp}/resources/plugins/iCheck/square/blue.css">
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>
<body class="hold-transition login-page">
<div class="login-box">

    <c:url var="loginUrl" value="/login"/>

    <div class="login-logo">
        <b>Admin</b>
    </div>

    <div class="login-box-body">
        <c:if test="${param.error != null}">
            <div class="alert alert-danger">
                <p>Tên đăng nhập hoặc mật khẩu không đúng..</p>
            </div>
        </c:if>
        <c:if test="${param.logout != null}">
            <div class="alert alert-success">
                <p>Bạn đã đăng xuất thành công</p>
            </div>
        </c:if>

        <form action="${loginUrl}" method="post" autocomplete="off">

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <div class="form-group has-feedback">
                <input type="text" id="domainname" name="domainname" class="form-control" placeholder="Domain Name" autocomplete="off" required autofocus>
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>

            <div class="form-group has-feedback">
                <input type="password" class="form-control" placeholder="Password" autocomplete="off" required>
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>

            <div class="row">
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
                </div>
            </div>

        </form>

    </div>
</div>

<script src="${cp}/resources/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="${cp}/resources/bootstrap/js/bootstrap.min.js"></script>
<script src="${cp}/resources/plugins/iCheck/icheck.min.js"></script>

</body>
</html>
