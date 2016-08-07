<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="iep" tagdir="/WEB-INF/tags/" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>IEP CREATOR - Home</title>
    <link href="/css/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/style-responsive.css" rel="stylesheet">
    <link href="/css/bootstrap.css" rel="stylesheet">
  </head>

  <body>

  <section id="container" >
     <iep:header />
      
     <iep:sidebar currentPage="index"/>
      <section id="main-content">
          <section class="wrapper site-min-height">
          	<h3><i class="fa fa-angle-right"></i> Home</h3>
          	<div class="row mt">
          		<div class="col-lg-12">
          			<h4>Welcome to IEP(Individualized Education Plan) Creator.</h4>
          			<p>You can create IEP's for your students easily with the steps below.</p>
          			<p>1. <a href="/signup">Register</a> and <a href="/login">login</a>.</p>
          			<p>2. Enter your students' info from <a href="/students">students</a> page.</p>
          			<p>3. <a href="/review">Review</a> your students.</p>
          			<p>4. Enter your students iep <a href="/settings">settings</a> for courses.</p>
          			<p>5. <a href="/plan">Create Plan</a>.</p>
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

  </body>
</html>