<%--
    Document   : index
    Created on : 21-abr-2009, 12:17:59
    Author     : CEU
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>RECETARIO</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="wrapper">
<!-- start header -->
<div id="header">
	<div id="logo">
		
		<h2> Todas las Recetas para Usted</h2> <br /><br />
        <h2>Pagina de login de la administraci&oacute;n</h2>
	</div>
</div>
<!-- end header -->

<!-- start page -->
<div id="page">

	<!-- start sidebar -->
	<div id="sidebar">
		<ul>
			<li id="search">
				<h2>Entra en la aplicacion</h2>
				<form action="Login" method="post" enctype="application/x-www-form-urlencoded" action="<%= response.encodeRedirectURL(request.getContextPath()+"/Login")%>">
					<fieldset>
                    <tr><td><center><font color="#000000">Usuario:&nbsp;</font><input type="text" name="login" size="12" maxlength="10"/></center></td></tr>
                    <br /><br />
                    <tr><td><center><font color="#000000">Password: &nbsp;</font><input type="password" name="password" size="12" maxlength="8"/></center></td></tr>
                    <br /><br />
                    <!-- <tr><td>&nbsp;</td></tr><tr><td><input type="submit"/></td></tr> -->
                    <center><input type="submit" value="Aceptar" name="submit" /></center>
					</fieldset>
				</form>
			</li>
		</ul>
	</div>
	<!-- end sidebar -->
    <br /> <br /> <br />
    <div align="center"><img src="./other/paella.jpg" ></img></div>
	<div style="clear: both;">&nbsp;</div>
</div>
<!-- end page -->
</div>
<!-- start footer -->
<div id="footer">
	<p id="legal">Aqui tendra todas las Recetas que necesite</p>
</div>
<!-- end footer -->
</body>
</html>