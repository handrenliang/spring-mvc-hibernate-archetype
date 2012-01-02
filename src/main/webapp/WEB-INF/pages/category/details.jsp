<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/include/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>details</title>
		<link rel="stylesheet" type="text/css"
			href="<c:url value='/styles/jmesa.css'/>">
		<link rel="stylesheet" type="text/css"
			href="<c:url value='/styles/jmesa-pdf.css'/>">
		<script type="text/javascript"
			src="<c:url value='/scripts/jmesa.min.js'/>"></script>
		<script type="text/javascript"
			src="<c:url value='/scripts/jquery.jmesa.min.js'/>"></script>
	</head>

	<body>
		<jmesa:springTableModel items="${categories}" id="category"
			var="category" toolbar="com.joinme.icook.util.CustomToolbar">
			<jmesa:htmlTable width="80%">
				<jmesa:htmlRow>
					<jmesa:htmlColumn property="categoryId" title="编号">${category.categoryId}</jmesa:htmlColumn>
					<jmesa:htmlColumn property="categoryName" title="分类">${category.categoryName}</jmesa:htmlColumn>
					<jmesa:htmlColumn property="categoryDescription" title="描述">${category.categoryDescription}</jmesa:htmlColumn>
				</jmesa:htmlRow>
			</jmesa:htmlTable>
		</jmesa:springTableModel>
	</body>
</html>
