<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="iep" tagdir="/WEB-INF/tags/" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>IEP CREATOR - Settings</title>
    <link href="/css/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/style-responsive.css" rel="stylesheet">
    <link href="/css/bootstrap.css" rel="stylesheet">
  </head>

  <body>

  <section id="container" >
     <iep:header />
      
     <iep:sidebar currentPage="settings"/>
      <section id="main-content">
          <section class="wrapper site-min-height">
          	<h3><i class="fa fa-angle-right"></i> Settings</h3>
          	<div class="row mt">
          		<div class="col-lg-12">
          			<form id="settingsForm" class="form-inline" method="post">
                          <div class="form-group">
                              <label>Student</label><br />
                              <select id="studentId" name="studentId" class="form-control">
          							<option value="0">Select Student</option>
          							<c:forEach items="${students}" var="student">
          								<option value="${student.studentId}">${student.name}&nbsp;${student.surname}</option>
          							</c:forEach>
          						</select>
                          </div>
                          <div class="form-group">
                              <label>Course</label><br />
                              <select id="courseId" name="courseId" class="form-control">
          							<option value="0">Select Course</option>
          							<c:forEach items="${courses}" var="course">
          								<option value="${course.courseId}">${course.name}</option>
          							</c:forEach>
          						</select>
                          </div>
                          <button type="button" id="btnShowRules" class="btn btn-theme" style="vertical-align: bottom;">Show</button>
                      </form>
          		</div>
          		<div class="col-lg-12" id="rules">
          		</div>
          	</div>
			
		</section>
      </section>

      <iep:footer/>
  </section>

    <script src="/js/jq/jquery-2.2.3.min.js" type="text/javascript"></script>
    <script src="/js/jq/jquery-ui-1.10.4.custom.min.js"></script>
    <script class="include" type="text/javascript" src="/js/jq/jquery.dcjqaccordion.2.7.js"></script>
    <script src="/js/jq/jquery.scrollTo.min.js"></script>
    <script src="/js/jq/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="/js/common-scripts.js"></script>
    <script src="/js/settings.js?ver=2.0"></script>

  </body>
</html>