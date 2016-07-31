<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="currentPage" description="currentPage" required="true" type="java.lang.String" %>
<!-- **********************************************************************************************************************************************************
 MAIN SIDEBAR MENU
 *********************************************************************************************************************************************************** -->
 <!--sidebar start-->
 <aside>
     <div id="sidebar"  class="nav-collapse ">
         <!-- sidebar menu start-->
         <ul class="sidebar-menu" id="nav-accordion">
       	<c:if test="${not empty sessionScope.LOGGEDIN_USER}">
       		<h5 class="centered">${sessionScope.LOGGEDIN_USER.name}&nbsp;${sessionScope.LOGGEDIN_USER.surname}</h5>
       	</c:if>
             <li class="mt">
                 <a href="/" <c:if test="${currentPage == \"index\"}">class="active"</c:if>>
                     <i class="fa"></i>
                     <span>Home</span>
                 </a>
             </li>
             <li class="sub-menu">
                 <a href="/signup" <c:if test="${currentPage == \"signup\"}">class="active"</c:if>>
                     <i class="fa"></i>
                     <span>Register</span>
                 </a>
             </li>
             <c:if test="${not empty sessionScope.LOGGEDIN_USER}">
	             <li class="sub-menu">
	                 <a href="/students" <c:if test="${currentPage == \"students\"}">class="active"</c:if>>
	                     <i class="fa"></i>
	                     <span>Students</span>
	                 </a>
	             </li>
	             <li class="sub-menu">
	                 <a href="/settings" <c:if test="${currentPage == \"settings\"}">class="active"</c:if>>
	                     <i class="fa"></i>
	                     <span>Settings</span>
	                 </a>
	             </li>
             </c:if>
         </ul>
         <!-- sidebar menu end-->
     </div>
 </aside>
 <!--sidebar end-->