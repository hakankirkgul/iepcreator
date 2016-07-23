<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="iep" tagdir="/WEB-INF/tags/" %>
<html lang="en">
    <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>IEP CREATOR - Students</title>
    <link href="/css/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/style-responsive.css" rel="stylesheet">
    <link href="/css/bootstrap.css" rel="stylesheet">
	<link href="/css/jq/jquery-ui-1.10.4.custom.min.css" rel="stylesheet" type="text/css"/>
  </head>

  <body>

  <section id="container" >
     <iep:header />
      
     <iep:sidebar currentPage="students"/>
      
      <section id="main-content">
          <section class="wrapper site-min-height">
          	<h3><i class="fa fa-angle-right"></i> Students</h3>
          	<div class="row mt">
          		<div class="col-lg-12">
          			<table class="table table-striped table-advance table-hover">
          				<thead>
          					<tr>
          						<th>Gender</th>
          						<th>Name</th>
          						<th>Surname</th>
          						<th>Birth Date</th>
          						<th>Parent Name</th>
          						<th>Parent Surname</th>
          						<th></th>
          					</tr>
          					<tr>
          						<td><select id="gender" class="form-control">
          							<option value="E">Male</option>
          							<option value="K">Female</option>
          						</select></td>
          						<td><input type="text" class="form-control" id="name"/></td>
          						<td><input type="text" class="form-control" id="surname"/></td>
          						<td><input type="text" class="form-control datepicker" id="birthDate"/></td>
          						<td><input type="text" class="form-control" id="parentName"/></td>
          						<td><input type="text" class="form-control" id="parentSurname"/></td>
          						<td><button type="button" class="btn btn-theme" id="addStudent">Add</button></td>
          					</tr>
          				</thead>
          				<tbody>
          					<c:forEach items="${students}" var="student"><tr>
          						<td><select id="gender${student.studentId}" class="form-control">
          							<option value="E" <c:if test='${student.gender ==  "E"}'>selected</c:if>>Male</option>
          							<option value="K" <c:if test='${student.gender ==  "K"}'>selected</c:if>>Female</option>
          						</select></td>
          						<td><input type="text" class="form-control" id="name${student.studentId}" value="${student.name}"/></td>
          						<td><input type="text" class="form-control" id="surname${student.studentId}" value="${student.surname}"/></td>
          						<td><input type="text" class="form-control datepicker" id="birthDate${student.studentId}" value='<fmt:formatDate value="${student.birthDate}" pattern="dd.MM.yyyy"/>'/></td>
          						<td><input type="text" class="form-control" id="parentName${student.studentId}" value="${student.name}"/></td>
          						<td><input type="text" class="form-control" id="parentSurname${student.studentId}" value="${student.name}"/></td>
          						<td>
          							<button class="btn btn-success btn-xs updateStudent" data-id="${student.studentId}"><i class="fa fa-check"></i></button>
                                    <button class="btn btn-danger btn-xs deleteStudent" data-id="${student.studentId}"><i class="fa fa-trash-o "></i></button>
                                </td>
          					</tr></c:forEach>
          				</tbody>
          			</table>
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
    <script src="/js/students.js"></script>

  </body>
</html>