<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="/struts-tags" prefix="s" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
    <title>Kerux Patient Web App</title>
    
    <!-- Styles -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:500,700&display=swap&subset=latin-ext" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,600&display=swap&subset=latin-ext" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/fontawesome-all.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
	
    <link rel="icon" href="images/KeruxLogo-notext.png">
<s:head/>
<style type="text/css">

	
/* The Modal (background) */
.modal {
display: block;
  position: fixed; /* Stay in place */
  z-index: 1031; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}


/* Modal Content */
.modal-content {
  background-color: #fefefe;
  margin: auto;
  padding: 20px;
  border: 1px solid #888;
  width: 80%;
}


.textbox {
    width: 450px;
    padding: 10px 15px;
    color: #272727;
    text-shadow: 1px 1px 0 #FFF;
    background: #FFF;
    border: 1px solid #FFF;
    border-radius: 5px;
    box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.50);
    -moz-box-shadow: inset 0 1px 3px rgba(0,0,0,0.50);
    -webkit-box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.50);
    margin-bottom: 10px;
}
  .textbox:focus {
    background: white;

    box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.25);
    -moz-box-shadow: inset 0 1px 2px rgba(0,0,0,0.25);
    -webkit-box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.25);
    outline: 0;
}
  .textbox:hover {
    background: #fee3e4;

}
.selectSize{
margin-top:-10px;
	width: 200px;
	height: 40px;
	font-size:20px;
}

</style>
</head>
<body data-spy="scroll" data-target=".fixed-top">
    
    <!-- icon para sa loading -->
	<div class="spinner-wrapper">
        <div class="spinner">
            <div class="bounce1"></div>
            <div class="bounce2"></div>
            <div class="bounce3"></div>
        </div>
    </div>
   
    
    <!-- Navbar -->
    <nav class="navbar navbar-expand-md navbar-dark navbar-custom fixed-top">
  
        <!-- Image Logo -->
        <a class="navbar-brand logo-image" href="index.html"><img src="images/KeruxLogoW.png"></a>
      
    </nav> <!-- end of navbar -->
    <!-- end of navbar -->


    <!-- Header -->
    <header id="header" class="header" >
        <div class="header-content" style="padding-top:0; padding-bottom:0;">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="text-container">
                        
                        
    <!-- Queue -->
    <div id="queue" class="form-1">
 

                   
                    <s:form  action="queue" method='post' theme="simple" cssClass="mx-auto">
                    <h1 style="color:#272727">Kerux Patient Queuing</h1><br><br>
					<h2 style="color:#d0262a">Select Department</h2><s:select list="departments" cssClass="selectSize" label="Select department for admin"  listValue="departmentName" listKey="departmentId" name="departmentId" id="depid" />
					<br><br>


					<h2 style="color:#d0262a">Select Doctor</h2><s:select list="doctors" cssClass="selectSize" label="Select doctor for admin"  listValue="doctorfirstname" listKey="doctorid" name="doctorid" id="docid" />
					<br>
					<br>
						<s:textfield cssClass="textbox" type="text" name="firstname" placeholder="Enter First Name" required="required"/>
						<br>
					
						<s:textfield cssClass="textbox" type="text" name="lastname" placeholder="Enter Last Name" required="required"/>
						<br>
				
						<s:textfield cssClass="textbox" type="text" name="contactno" placeholder="Enter Contact Number" required="required"/>
						<br>
						<br>
						<s:hidden  value="%{clinicid}" name="clinicid" />

						<s:if test="hasActionErrors()">
								<s:actionerror/>
						</s:if>
						<s:submit cssClass="btnSubmit-solid-lg" type="submit" value="Submit" onclick="getValues()"/>

				</s:form>
				



    </div> <!-- end of form-1 -->
    <!-- end of queue -->
                        
                        
                        
                        
                        </div>
                    </div> <!-- end of col -->
                </div> <!-- end of row -->
            </div> <!-- end of container -->
        </div> <!-- end of header-content -->
    </header> <!-- end of header -->
    <!-- end of header -->

<s:if test="actionMessages!=null && actionMessages.size > 0">
    <div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
  You have successfully queued! <br>Queue Number:
        <s:iterator value="actionMessages" >
			<s:property />
        </s:iterator>      

  </div>

</div>
</s:if>

<s:if test="actionErrors!=null && actionErrors.size > 0">
    <div id="myModal1" class="modal">

  <!-- Modal content -->
  <div class="modal-content" >

        <s:iterator value="actionErrors" >
			<s:property />
        </s:iterator>           

  </div>

</div>
</s:if>

<!--     Copyright
    <div class="copyright">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <p class="p-small">Copyright © 2020 KERUX</p>
                </div> end of col
            </div> enf of row
        </div> end of container
    </div> end of copyright 
    end of copyright -->
    

    <!-- Scripts -->
    <script src="js/jquery.min.js"></script> <!-- jQuery for Bootstrap's JavaScript plugins -->
    <script src="js/bootstrap.min.js"></script> <!-- Bootstrap framework -->
    <script src="js/jquery.easing.min.js"></script> <!-- jQuery Easing for smooth scrolling between anchors -->
    <script src="js/morphext.min.js"></script> <!-- Morphtext rotating text in the header -->
    <script src="js/scripts.js"></script> <!-- Custom scripts -->
    
    <script type="text/javascript">
	


 
  $(document).ready(function () {
	  

	//Get the modal
	  var modal = document.getElementById("myModal");
	  var modal1 = document.getElementById("myModal1");




	  
window.onclick = function(event) {
    if (event.target == modal) {
      modal.style.display = "none";
    }
    
    if (event.target == modal1) {
        modal1.style.display = "none";
      }
  }

	  

	
	
  });

</script>
    
</body>
</html>