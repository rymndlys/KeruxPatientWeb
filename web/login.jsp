
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>KERUX</title>

<style>
.selectSize{
	width: 200px;
	height: 40px;
	font-size:20px;
}

</style>
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	
	    <link rel="icon" href="images/KeruxLogo-notext.png">
</head>
<body>

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-form-title" style="background-image: url(images/docbg.png);">
					<span class="login100-form-title-1">
						Choose your clinic
					</span>
				</div>

				<s:form cssClass="login100-form validate-form" action="queuepage" theme="simple">
					<div class="wrap-input100 validate-input m-b-26" data-validate="Username is required">
						<span class="label-input100" style="font-size:23px; margin-top:-7px;">Clinic : </span>
					
						<s:select list="clinics" label="Choose Clinic"  cssClass="selectSize" listValue="clinicname" listKey="clinicid" name="clinicid" id="cid" />
	
					</div>

					<div class="flex-sb-m w-full p-b-30">
						<font color="#d0262a">
							<s:if test="hasActionErrors()">
									<s:actionerror/>
							</s:if>
						</font>
					</div>

					<div class="container-login100-form-btn">
						<s:submit cssClass="login100-form-btn" type="submit" value="Confirm Clinic"/>
						
						
					</div>
				</s:form>
				<div class="container-login100-form-apkbtn">
					<a href ="/SymplPatient/apk/KeruxPatient.apk"><s:submit cssClass="login100-apk-btn" type="button" value="Download the Patient APK"/></a>
                </div>
				
			</div>
		</div>
	</div>

<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>