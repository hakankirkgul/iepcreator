$(document).ready(function(){
	//dfasdasgfsa
	$('.goal').on('change',function(){
		$.ajax({
			type : 'post',
			url : '/review/set',
			data : {
				studentId : $('#studentId').val(),
				goalId : $(this).val(),
				status : $(this).prop('checked') ? 1 : 0
			}
		}).done(function(data){
			if(data != 'OK'){
				alert(data);
			}
		});
	});
});