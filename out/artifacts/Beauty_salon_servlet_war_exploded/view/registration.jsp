<%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 29.10.2020
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : 'en'}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="message"/>

<!doctype html>
<html lang="${language}">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">

    <title><fmt:message key="title.registration"/></title>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light sticky-top"
     style="background-color: #FFE3F5 ">
    <a href="${pageContext.request.contextPath}/salon/menu" class="navbar-brand">
        <img src="https://image.freepik.com/free-vector/_53876-43323.jpg" width="30" height="30" alt="logo">
    </a>
    <a href="${pageContext.request.contextPath}/salon/login" class="navbar-brand letter"
       style="color: deeppink; font-size:11pt" >
        <fmt:message key="button.sign-in"/>
    </a>
    <form method="get" action="${pageContext.request.contextPath}/change-language/registration">
        <label for="language"></label>
        <select id="language" name="language"
                onchange="submit()" style="font-size: 11pt; background-color: #FFE3F5; color: deeppink">
            <option value="en" ${language == 'en' ? 'selected' : ''} style="color: deeppink">English</option>
            <option value="uk" ${language == 'uk' ? 'selected' : ''} style="color: deeppink">Українська</option>
        </select>
    </form>
</nav>

<br>
<%--<form method="post" action="${requestScope.request.contextPath}/register">--%>
<form method="post" action="${pageContext.request.contextPath}/register">
    <p align="center">
    <div class="form-col" align="center">
        <div class="col">
            <a class="navbar-brand letter" style="color: deeppink; font-size:11pt"><fmt:message key="field.user.name.ukr"/>:</a>
            <input type="text" required placeholder="name" name="userNameUkr"><br>
            <a class="navbar-brand letter" style="color: deeppink; font-size:11pt"><fmt:message key="field.user.name.en"/>:</a>
            <input type="text" required placeholder="name" name="userNameEn"><br>
            <a class="navbar-brand letter" style="color: deeppink; font-size:11pt"><fmt:message key="field.user.login"/>:</a>
            <input type="text" required placeholder="login" name="userLogin"><br>
            <a class="navbar-brand letter" style="color: deeppink; font-size:11pt"><fmt:message key="field.user.password"/>:</a>
            <input type="password" required placeholder="password" name="userPassword"><br>
            <a class="navbar-brand letter" style="color: deeppink; font-size:11pt"><fmt:message key="field.user.gender"/>:</a>
            <select name="userGender">
                <option value="male"><fmt:message key="field.user.gender.male"/></option>
                <option value="female"><fmt:message key="field.user.gender.female"/></option>
            </select><br>
            <a class="navbar-brand letter" style="color: deeppink; font-size:11pt"><fmt:message key="field.user.email"/>:</a>
            <input type="text" required placeholder="email" name="userEmail"><br>
            <c:if test="${not empty requestScope.warning}">
                <fmt:message key="${requestScope.warning}"/>
            </c:if>
            <small id="help" class="form-text text-muted"><fmt:message key="warn.required.fields"/></small>

            <button class="btn btn-success" style="background-color: #FFA9EB"><fmt:message key="button.sign-up"/></button>
        </div>
    </div>
</form>
<div class="container">

</div>

</body>
</html>
