$(document).ready(function(){
	$('#addStudent').on('click',function(){
		var ok = true;
		var name = $('#name').val();
		if(name == null || name.length == 0){
			ok = false;
			$('#name').addClass('focused');
		} else {
			$('#name').removeClass('focused');
		}
		var surname = $('#surname').val();
		if(surname == null || surname.length == 0){
			ok = false;
			$('#surname').addClass('focused');
		} else {
			$('#surname').removeClass('focused');
		}
		var gender = $('#gender').val();
		if(gender == null || gender.length == 0){
			ok = false;
			$('#gender').addClass('focused');
		} else {
			$('#gender').removeClass('focused');
		}
		var parentName = $('#parentName').val();
		if(parentName == null || parentName.length == 0){
			ok = false;
			$('#parentName').addClass('focused');
		} else {
			$('#parentName').removeClass('focused');
		}
		var parentSurname = $('#parentSurname').val();
		if(parentSurname == null || parentSurname.length == 0){
			ok = false;
			$('#parentSurname').addClass('focused');
		} else {
			$('#parentSurname').removeClass('focused');
		}
		var birthDate = $('#birthDate').val();
		if(birthDate == null || birthDate.length == 0){
			ok = false;
			$('#birthDate').addClass('focused');
		} else {
			$('#birthDate').removeClass('focused');
		}
		
		if(ok){
			$.ajax({
				type : 'post',
				url : '/students/add',
				data : {
					name : name,
					surname : surname,
					gender : gender,
					birthDate : birthDate,
					parentName : parentName,
					parentSurname : parentSurname
				}
			}).done(function(data){
				if(data != 'OK'){
					alert(data);
				} else {
					window.location.reload();
				}
			});
		}
	});
	
	$('.updateStudent').on('click',function(){
		var studentId = $(this).data('id');
		var ok = true;
		var name = $('#name'+studentId).val();
		if(name == null || name.length == 0){
			ok = false;
			$('#name'+studentId).addClass('focused');
		} else {
			$('#name'+studentId).removeClass('focused');
		}
		var surname = $('#surname'+studentId).val();
		if(surname == null || surname.length == 0){
			ok = false;
			$('#surname+studentId').addClass('focused');
		} else {
			$('#surname+studentId').removeClass('focused');
		}
		var gender = $('#gender'+studentId).val();
		if(gender == null || gender.length == 0){
			ok = false;
			$('#gender'+studentId).addClass('focused');
		} else {
			$('#gender'+studentId).removeClass('focused');
		}
		var parentName = $('#parentName'+studentId).val();
		if(parentName == null || parentName.length == 0){
			ok = false;
			$('#parentName'+studentId).addClass('focused');
		} else {
			$('#parentName'+studentId).removeClass('focused');
		}
		var parentSurname = $('#parentSurname'+studentId).val();
		if(parentSurname == null || parentSurname.length == 0){
			ok = false;
			$('#parentSurname'+studentId).addClass('focused');
		} else {
			$('#parentSurname'+studentId).removeClass('focused');
		}
		var birthDate = $('#birthDate'+studentId).val();
		if(birthDate == null || birthDate.length == 0){
			ok = false;
			$('#birthDate'+studentId).addClass('focused');
		} else {
			$('#birthDate'+studentId).removeClass('focused');
		}
		
		if(ok){
			$.ajax({
				type : 'post',
				url : '/students/update',
				data : {
					studentId : studentId,
					name : name,
					surname : surname,
					gender : gender,
					birthDate : birthDate,
					parentName : parentName,
					parentSurname : parentSurname
				}
			}).done(function(data){
				if(data != 'OK'){
					alert(data);
				} else {
					alert('Saved');
				}
			});
		}
	});
	
	$('.deleteStudent').on('click',function(){
		var studentId = $(this).data('id');
		var row = $(this).parent().parent();
		$.ajax({
			type : 'post',
			url : '/students/delete',
			data : {
				studentId : studentId
			}
		}).done(function(data){
			if(data != 'OK'){
				alert(data);
			} else {
				$(row).remove();
			}
		});
	});
	
	$('.datepicker').datepicker({
		changeMonth: true,
	    changeYear: true,
	    maxDate : '-5Y',
	    minDate : '-15Y',
	    dateFormat : 'dd.mm.yy'
	});
});