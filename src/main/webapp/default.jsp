<%--
  Created by IntelliJ IDEA.
  User: anlu
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="commons/inc.jsp"%>
<html>
  <head>
    <title>URL</title>
    <link rel="stylesheet" href="${ctx}/assets/css/material.min.css">
    <style>
      @import "assets/css/style.css";
    </style>
    <script src="${ctx}/assets/js/material.min.js"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  </head>
  <body>
  <div class="mdl-grid">
    <div class="mdl-cell mdl-cell--4-col"></div>
    <div class="mdl-cell mdl-cell--4-col">
      <h1 class="mdl-typography--display-4-color-contrast mdl-typography--text-center">URL</h1>
    </div>
    <div class="mdl-cell mdl-cell--4-col"></div>
    <div class="mdl-cell mdl-cell--4-col"></div>
    <div class="mdl-cell mdl-cell--4-col">
      <form action="${ctx}/createMapper" method="post">
        <div id="original-wrapper" class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
          <input name="original" class="mdl-textfield__input" type="text">
          <label class="mdl-textfield__label" for="original">Enter a long URL</label>
        </div>
        <div>
          <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
            Make
          </button>
        </div>
        <div id="creation-wrapper" class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
          <input name="creation" class="mdl-textfield__input" type="text" id="creation">
          <label class="mdl-textfield__label" for="creation">Custom alias (optional)</label>
        </div>
      </form>
      <small style="color: #f00;">${sessionScope.message}</small>
      <c:if test="${sessionScope.mapper ne null}">
        <p class="mdl-color-text--accent">Creation URL:</p>
        <p class="mdl-typography--display-1">
          <a href="${url.concat(sessionScope.mapper.creation)}" target="_blank">
              ${url.concat(sessionScope.mapper.creation)}
          </a>
        </p>
        <p>
          <a href="${ctx}/assets/qrcode/${sessionScope.mapper.creation}.png" target="_blank">
            <img src="${ctx}/assets/qrcode/${sessionScope.mapper.creation}.png" width="100">
          </a>
        </p>
        <p>Original URL:</p>
        <p id="original">${sessionScope.mapper.original}</p>
      </c:if>
    </div>
    <div class="mdl-cell mdl-cell--4-col"></div>
  </div>
  </body>
</html>
