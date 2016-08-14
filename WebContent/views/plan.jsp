<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="iep" tagdir="/WEB-INF/tags/" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>IEP CREATOR - Create Plan</title>
    <link href="/css/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/style-responsive.css" rel="stylesheet">
    <link href="/css/bootstrap.css" rel="stylesheet">
  </head>

  <body>

  <section id="container" >
     <iep:header />
      
     <iep:sidebar currentPage="plan"/>
      <section id="main-content">
          <section class="wrapper">
          	<h3><i class="fa fa-angle-right"></i> Create Plan</h3><div class="row mt">
          		<div class="col-lg-12">
          			<form class="form-inline" method="post" id="formCreatePlan">
                          <div class="form-group">
                              <label>Student</label><br />
                              <select id="studentId" name="studentId" class="form-control">
          							<option value="0">Select Student</option>
          							<c:forEach items="${students}" var="student">
          								<option value="${student.studentId}" <c:if test="${param.studentId == student.studentId}">selected</c:if>>${student.name}&nbsp;${student.surname}</option>
          							</c:forEach>
          						</select>
                          </div>
                          <div class="form-group">
                              <label>Course</label><br />
                              <select id="courseId" name="courseId" class="form-control">
          							<option value="0">Select Course</option>
          							<c:forEach items="${courses}" var="course">
          								<option value="${course.courseId}" <c:if test="${param.courseId == course.courseId}">selected</c:if>>${course.name}</option>
          							</c:forEach>
          						</select>
                          </div>
                          <button id="btnCreatePlan" type="submit" class="btn btn-theme" style="vertical-align: bottom;">Create Plan</button>
                      </form>
                      
                      <c:if test="${not empty finishedGoals}">
                      <c:set var="subjectId" value="${0}"/>
                      <table class="table table-advance">
                      	<thead>
                      		<tr><th colspan="2">Finished Goals</th></tr>
                      		<tr>
                      			<th>#</th>
                      			<th>Subject/Goal</th>
                      		</tr>
                      	</thead>
						<tbody>
							<c:forEach items="${finishedGoals}" var="goal">
								<c:if test="${goal.subjectId == 0 || goal.subjectId != subjectId}">
									<tr>
										<th>${goal.subjectNo}</th>
										<th>${goal.subject}</th>
										<c:set var="subjectId" value="${goal.subjectId}"/>
									</tr>
								</c:if>
								<tr>
									<td>${goal.goalNo}</td>
									<td>${goal.goal}</td>
								</tr>
							</c:forEach>
						</tbody>
					  </table>
					  </c:if>
					  
					  <c:if test="${not empty unfinishedGoals}">
                      <c:set var="subjectId" value="${0}"/>
                      <table class="table table-advance">
                      	<thead>
                      		<tr><th colspan="2">Unfinished Goals</th></tr>
                      		<tr>
                      			<th>#</th>
                      			<th>Subject/Goal</th>
                      		</tr>
                      	</thead>
						<tbody>
							<c:forEach items="${unfinishedGoals}" var="goal">
								<c:if test="${goal.subjectId == 0 || goal.subjectId != subjectId}">
									<tr>
										<th>${goal.subjectNo}</th>
										<th>${goal.subject}</th>
										<c:set var="subjectId" value="${goal.subjectId}"/>
									</tr>
								</c:if>
								<tr>
									<td>${goal.goalNo}</td>
									<td>${goal.goal}</td>
								</tr>
							</c:forEach>
						</tbody>
					  </table>
					  </c:if>
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
    <script src="/js/plan.js"></script>

  </body>
</html>