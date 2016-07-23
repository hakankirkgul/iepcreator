<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="iep" tagdir="/WEB-INF/tags/" %>
<html lang="en">
    <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>IEP CREATOR - Register</title>
    <link href="/css/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/style-responsive.css" rel="stylesheet">
    <link href="/css/bootstrap.css" rel="stylesheet">
  </head>

  <body>

  <section id="container" >
     <iep:header />
      
     <iep:sidebar currentPage="signup"/>
      
      <section id="main-content">
          <section class="wrapper site-min-height">
          	<h3><i class="fa fa-angle-right"></i> Register</h3>
          	<div class="row mt">
          		<div class="col-lg-12">
          			<form id="registerForm" class="form-horizontal style-form" method="post">
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Email</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control required email" id="email" name="email">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Name</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control required" id="name" name="name">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Surname</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control required" id="surname" name="surname">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Password</label>
                              <div class="col-sm-10">
                                  <input class="form-control required" type="password" id="password" name="password" maxlength="8" minlength="8">
                              </div>
                          </div>
                          <button type="submit" class="btn btn-theme">Register</button>
                      </form>
          		</div>
          	</div>
          	<c:if test="${not empty success}">
          		<div class="alert alert-success">
          			<b>Your registration is successfully completed.</b> <a href="/login">&nbsp; Login here</a>
          		</div>
             </c:if>
             
          	<c:if test="${not empty error}">
          		<div class="alert alert-danger">
          			<b>${error}</b>
          		</div>
             </c:if>
             
			
		</section>
      </section>
      
      <iep:footer/>
  </section>

    <script src="/js/jq/jquery-2.2.3.min.js" type="text/javascript"></script>
    <script src="/js/jq/jquery-ui-1.10.4.custom.min.js"></script>
    <script src="/js/jq/jquery.validate.min.js"></script>
    <script class="include" type="text/javascript" src="/js/jq/jquery.dcjqaccordion.2.7.js"></script>
    <script src="/js/jq/jquery.scrollTo.min.js"></script>
    <script src="/js/jq/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="/js/common-scripts.js"></script>
    <script type="text/javascript">
		$(document).ready(function(){
			$('#registerForm').validate();
		});
    </script>

  </body>
</html>