<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet"
	href="<c:url   value="/resources/css/bootstrap.min.css" />">
<title>Insert title here</title>
</head>
<body>
	<div id="loginbox" style="margin-top: 50px;"
		class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">

		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">
					<span>Sign In</span>
				</div>
			</div>
			<div style="padding-top: 30px" class="panel-body">
				<c:if test="${param.error  eq 1}">
					<div class="alert alert-danger text-center">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
					</div>
				</c:if>
			</div>
			<div class="">
				<form class="form-horizontal" role="form" action="login"
					method="post">
					<div class="form-group">
						<label class="col-md-4 control-label"> User Name </label>
						<div class="col-md-6">
							<input class="form-control" type="text" name="useranme" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label"> Password </label>
						<div class="col-md-6">
							<input class="form-control" type="password" name="mot_passe" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-offset-4 col-md-6">
							<input type="submit" value="Sign In" class="btn btn-primary" />
						</div>
					</div>
				</form>
			</div>
		</div>


	</div>


</body>
</html>