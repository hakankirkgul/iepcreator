$(document).ready(function(){
	//dfasdasgfsa
	$('#formCreatePlan').on('submit',function(){
		if($('#studentId').val() != '0' && $('#courseId').val() != '0'){
			$('#btnCreatePlan').html('Creating Plan.....').prop('disabled',true);
			return true;
		} else {
			return false;
		}
	});
});