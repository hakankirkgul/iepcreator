<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--header start-->
      <header class="header black-bg">
              <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
              </div>
            <!--logo start-->
            <a href="/" class="logo"><b>IEP CREATOR</b></a>
            <!--logo end-->
            <div class="top-menu">
            	<ul class="nav pull-right top-menu">
            		<c:choose>
                	<c:when test="${not empty sessionScope.LOGGEDIN_USER}">
                		<li><a class="logout" href="/logout">Logout</a></li>
                	</c:when>
                	<c:otherwise>
                		<li><a class="logout" href="/login">Login</a></li>
                	</c:otherwise>
                </c:choose>
            	</ul>
            </div>
        </header>
      <!--header end-->