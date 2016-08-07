<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form id="settingsForm" class="form-inline" method="post">
    <div class="form-group">
        <label>Goal Count per Subject</label><br />
        <input id="goalCountPerSubject" class="form-control" value="${settings.goalPerSubject}"/>
    </div>
    <div class="form-group">
        <label>Subject Count per Plan</label><br />
        <input id="subjectCountPerPlan" class="form-control" value="${settings.subjectPerPlan}"/>
    </div>
    <button type="button" class="btn btn-theme" id="updateStudentCourseSettings" style="vertical-align: bottom;">Save</button>
</form>

<table class="table table-striped table-advance table-hover">
	<thead>
		<tr>
			<th>Subject</th>
			<th>Pre-Subject</th>
			<th></th>
		</tr>
		<tr>
			<td><select id="subjectId" name="subjectId" class="form-control">
				<c:forEach items="${subjects}" var="subject">
					<option value="${subject.subjectId}">${subject.subjectNo}. ${subject.subject}</option>
				</c:forEach>
			</select></td>
			<td><select id="preSubjectId" name="preSubjectId" class="form-control">
				<c:forEach items="${subjects}" var="subject">
					<option value="${subject.subjectId}">${subject.subjectNo}. ${subject.subject}</option>
				</c:forEach>
			</select></td>
			<td><button type="button" class="btn btn-theme" id="addRule">Add</button></td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${rules}" var="rule"><tr>
			<td>${rule.subjectNo}. ${rule.subject}</td>
			<td>${rule.preSubjectNo}. ${rule.preSubject}</td>
			<td><button class="btn btn-danger btn-xs deleteRule" data-id="${rule.ruleId}"><i class="fa fa-trash-o "></i></button></td>
		</tr></c:forEach>
	</tbody>
</table>