<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="iep" tagdir="/WEB-INF/tags/" %>
<html lang="en">
    <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>IEP CREATOR - Login</title>
    <link href="/css/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/style-responsive.css" rel="stylesheet">
    <link href="/css/bootstrap.css" rel="stylesheet">
  </head>

  <body>

  <section id="container" >
     <iep:header />
      
     <iep:sidebar currentPage="login"/>
      
      <section id="main-content">
          <section class="wrapper site-min-height">
          	<h3><i class="fa fa-angle-right"></i> Login</h3>
          	<div class="row mt">
          		<div class="col-lg-12">
                      <form id="loginForm" class="form-horizontal style-form" method="post">
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Email</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control required email" id="email" name="email">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Password</label>
                              <div class="col-sm-10">
                                  <input class="form-control required" type="password" id="password" name="password">
                              </div>
                          </div>
                          <button type="submit" class="btn btn-theme">Sign in</button>
                      </form>
          		</div>
          	</div>
          	<c:if test="${not empty error}">
          		<div class="alert alert-danger">
          			<b>You entered wrong email and/or password.</b>
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
			$('#loginForm').validate();
		});
    </script>

  </body>
</html>