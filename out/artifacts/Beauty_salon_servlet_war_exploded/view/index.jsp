<%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 29.10.2020
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

  <title><fmt:message key="title.index"/></title>
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
  <form>
    <label for="language"></label>
    <select id="language" name="language"
            onchange="submit()" style="font-size: 11pt; background-color: #FFE3F5; color: deeppink">
      <option value="en" ${language == 'en' ? 'selected' : ''} style="color: deeppink">English</option>
      <option value="ua" ${language == 'ua' ? 'selected' : ''} style="color: #ff1493">Українська</option>
    </select>
  </form>
</nav>

<br>
<div class="container">
  <form method="get" action="${pageContext.request.contextPath}/salon/login">
    <p align="center"><button class="btn btn-success" style="background-color: #FFA9EB" type="submit">
      <fmt:message key="button.sign-in"/>
    </button>
    </p>
  </form>

  <br>
  <form method="get" action="${pageContext.request.contextPath}/registration">
    <p align="center"><button class="btn btn-success" style="background-color: #FFA9EB" type="submit">
      <fmt:message key="button.sign-up"/>
    </button></p>
  </form>

</div>

</body>
</html>
