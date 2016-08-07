$(document).ready(function(){
	$('#btnShowRules').on('click',function(){
		if(parseInt($('#studentId').val()) > 0 && parseInt($('#courseId').val()) > 0){
			$('#rules').load('/rules',{
				studentId : $('#studentId').val(),
				courseId : $('#courseId').val()
			});
		}
	});
	
	$('#rules').on('click','#updateStudentCourseSettings',function(){
		$.ajax({
			type : 'post',
			url : '/rules/update/student/course/settings',
			data : {
				studentId : $('#studentId').val(),
				courseId : $('#courseId').val(),
				goalPerSubject : $('#goalCountPerSubject').val(),
				subjectPerPlan : $('#subjectCountPerPlan').val()
			}
		}).done(function(data){
			if(data != 'OK'){
				alert(data);
			} else {
				alert('Saved');
			}
		});
	});
	
	$('#rules').on('click','#addRule',function(){
		$.ajax({
			type : 'post',
			url : '/rules/add',
			data : {
				studentId : $('#studentId').val(),
				subjectId : $('#subjectId').val(),
				preSubjectId : $('#preSubjectId').val()
			}
		}).done(function(data){
			if(data != 'OK'){
				alert(data);
			} else {
				$('#btnShowRules').click();
			}
		});
	});
	
	$('#rules').on('click','.deleteRule',function(){
		var ruleId = $(this).data('id');
		var row = $(this).parent().parent();
		$.ajax({
			type : 'post',
			url : '/rules/delete',
			data : {
				ruleId : ruleId
			}
		}).done(function(data){
			if(data != 'OK'){
				alert(data);
			} else {
				$(row).remove();
			}
		});
	});
});