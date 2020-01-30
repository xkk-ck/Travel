<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>矩阵的加法</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Trail Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<link href="cpts_169_dcw/css/bootstrap.css" rel='stylesheet'
	type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="cpts_169_dcw/js/jquery-1.11.1.min.js"></script>
<!---strat-slider---->
<!-- Custom Theme files -->
<link href="cpts_169_dcw/css/style.css" rel='stylesheet' type='text/css' />
<!----font-Awesome----->
<link rel="stylesheet"
	href="cpts_169_dcw/fonts/css/font-awesome.min.css">
<!----font-Awesome----->
<script type="text/javascript" src="cpts_169_dcw/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(function() {
		$('#create').click(function() {
		    $('#matrix1').empty();
		    $('#matrix2').empty();
			var row = $('#row').val();
			var col = $('#col').val();
			var item;
			for (var i = 0; i < row; i++) {
			    for (var j = 0; j < col; j++) {
			        item = "<input style='height:30px;width:30px' type='text' name='1_" + i + "_" + j +"'>&nbsp;";
			        $('#matrix1').append(item);
			        item = "<input style='height:30px;width:30px' type='text' name='2_" + i + "_" + j +"'>&nbsp;";
			        $('#matrix2').append(item);
		        }
		        $('#matrix1').append("<br/><br/>");
		        $('#matrix2').append("<br/><br/>");
	        }
	        $('#matrix1').append("<br/>");
	        $('#matrix2').append("<br/>");
	    });
    });
</script>
</head>
<body>
	<div class="top-header">
		<div class="container">
			<p class="m_1">
		      <c:choose>
		        <c:when test="${empty sessionScope.session_user }">
		                              游客你好！
		        </c:when>
		        <c:otherwise>
		            ${session_user.username },你好!
		        </c:otherwise>
		    </c:choose>
			</p>&nbsp;&nbsp;
			<a href="interrogation.jsp"><font size="4" color="blue">进入问答</font>
			</a>&nbsp;&nbsp;
			<a href="UserServlet?method=exit" target="_parent"><font size="4" color="blue">退出</font>
			</a>
			<div class="clearfix"></div>
		</div>
	</div>
	<div class="bottom-header">
		<div class="container">
			<div class="header_top-responsive">
				<div class="logo_responsive">
					<a href="index.html"><img src="cpts_169_dcw/images/logo1.png"
						alt="" /> </a>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="h_menu4">
				<!-- start h_menu4 -->
				<a class="toggleMenu" href="#">Menu</a>
				<ul class="nav">
					<li><a>矩阵的运算</a>
						<ul>
							<li><a href="matrixAdd.jsp">矩阵的加法</a></li>
							<li><a href="matrixMultiply.jsp">矩阵的乘法</a></li>
						</ul></li>
					<li><a href="matrixTranspose.jsp">矩阵的转置</a></li>
					<li><a href="determinant.jsp">行列式求值</a></li>
					<li><a href="matrixInverse.jsp">逆矩阵</a></li>
					<li><a href="">解线性方程</a>
						<ul>
							<li><a href="equationsSolution.jsp">齐次线性方程</a></li>
							<li><a href="unequationsSolution.jsp">非齐次线性方程</a></li>
						</ul></li>
					<li><a href="matrixRank.jsp">矩阵的秩</a></li>
					<li><a href="isCorrelate.jsp">判断线性相关</a></li>
					<li><a href="matrixEigenvalue.jsp">矩阵的特征值</a></li>
					<li><a href="isSimilarity.jsp">判断矩阵相似</a></li>
				</ul>
				<script type="text/javascript" src="cpts_169_dcw/js/nav.js"></script>
			</div>
			<!-- end h_menu4 -->

			<div class="clearfix"></div>
		</div>
	</div>
	<div class="wrap-box"></div>
	<div class="about">
		<form action="<c:url value='/MatrixServlet'/>" method="post">
			<input type="hidden" name="method" value="matrixAdd" />
			<div class="container" align="center">							
						          输入矩阵的行与列： 
							<input style="height:30px; width:30px" id="row" name="row" value="${row }" type="text"> 
							<input style="height:30px; width:30px" id="col" name="col" value="${col }" type="text"> 
							<input type="button" value="确认" id="create">
							<br /> <br />
				<div class="col-md-6 section_group">
					<div class="span_3">
						<div class="col_1_of_5 span_1_of_5">
							<h2>矩阵1</h2>
							<div id="matrix1">
							  <c:forEach items="${matrix1 }" var="keyword">
			                    ${keyword }<br/><br/>
			                  </c:forEach>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="wrap-box"></div>
<!-- 			       
                    <div class="span_4">
				        <div class="col_1_of_5 span_1_of_5">
					        <h2>计算结果</h2>
				        </div>
			        </div> 
					<div class="clearfix"></div> 
					-->
				</div>
				<div class="col-md-6 section_group">
					<div class="span_3">
						<div class="col_1_of_5 span_1_of_5">
							<h2>矩阵2</h2>
							<div id="matrix2">
			                  <c:forEach items="${matrix2 }" var="keyword">
			                    ${keyword }<br/><br/>
			                  </c:forEach>
							
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="wrap-box"></div>
<!-- 
	               <div class="span_4">
	      	           <div class="col_1_of_5 span_1_of_5">
	      		           <h2>矩阵4</h2>
	      	           </div>
	                   <div class="clearfix"> </div>
	               </div>
-->
					<div class="clearfix"></div>
				</div>
			  <br/>
			  <input type="submit" value="计算">
			  <br/>
			  <div align="center">
			  结果为:<br/>
			  <c:forEach items="${matrix3 }" var="keyword">
			      ${keyword }<br/><br/>
			  </c:forEach>
			  </div>
			</div>
		</form>
	</div>
</body>
</html>