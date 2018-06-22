<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<TITLE>添加客户</TITLE>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
	<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
		  rel=stylesheet>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
	<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<!--在跳转到add.jsp的同时，查询数字字典,获取客户来源,客户所属行业,客户级别-->
<script type="text/javascript">
    $(function(){
        // 客户级别
        $.post("baseDict_findByTypeCode.action",{"dict_type_code":"006"},function(data){
            // alert(data);// json数据的字符串
            // data = eval("("+data+")"); // 将json形式的字符串，转换成json对象
            // alert(data);// json对象数据
            $(data).each(function(index,domEle){
                //alert(domEle.dict_id);
                $("#cust_level").append("<option value='"+domEle.dict_id+"'>"+domEle.dict_item_name+"</option>");
            })
            // 默认选中客户级别:EL获取值栈的数据 ${baseDictLevel.dict_id}
            $("#cust_level option[value='${baseDictLevel.dict_id}']").prop("selected",true);
        },"json")  // 表示响应的结果是json数据


        // 客户级别
        $.post("baseDict_findByTypeCode.action",{"dict_type_code":"002"},function(data){
            $(data).each(function(index,domEle){
                $("#cust_source").append("<option value='"+domEle.dict_id+"'>"+domEle.dict_item_name+"</option>");
            })
			$("#cust_source option[value='${baseDictSource.dict_id}']").prop("selected",true);
        },"json")  // 表示响应的结果是json数据


        // 客户级别
        $.post("baseDict_findByTypeCode.action",{"dict_type_code":"001"},function(data){
            $(data).each(function(index,domEle){
                $("#cust_industry").append("<option value='"+domEle.dict_id+"'>"+domEle.dict_item_name+"</option>");
            })
			$("#cust_industry option[value='${baseDictIndustry.dict_id}']").prop("selected",true);
        },"json")  // 表示响应的结果是json数据
    })
</script>

<BODY>
<s:form name="form1" id="form1" 	action="customer_update.action" method="post" enctype="multipart/form-data">
	<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
		<TBODY>
		<TR>
			<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
							  border=0></TD>
			<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
				height=20></TD>
			<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
							  border=0></TD>
		</TR>
		</TBODY>
	</TABLE>
	<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
		<TBODY>
		<TR>
			<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
					src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
			<TD vAlign=top width="100%" bgColor=#ffffff>
				<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
					<TR>
						<TD class=manageHead>当前位置：客户管理 &gt; 添加客户</TD>
					</TR>
					<TR>
						<TD height=2></TD>
					</TR>
				</TABLE>

				<TABLE cellSpacing=0 cellPadding=5  border=0>


					<TR>
						<td>客户名称：</td>
						<td>
							<s:textfield theme="simple" cssClass="textbox" cssStyle="WIDTH: 180px" maxLength="50"  name="cust_name"/>
						</td>
						<td>客户级别 ：</td>
						<td>
							<%--<INPUT class=textbox id=sChannel2--%>
							<%--style="WIDTH: 180px" maxLength=50 name="cust_level">--%>
							<select id="cust_level" name="baseDictLevel.dict_id">
								<option value="0">--请选择--</option>
							</select>
						</td>
					</TR>

					<TR>

						<td>信息来源 ：</td>
						<td>
							<%--<INPUT class=textbox id=sChannel2--%>
							<%--style="WIDTH: 180px" maxLength=50 name="cust_source">--%>
							<select id="cust_source" name="baseDictSource.dict_id">
								<option value="0">--请选择--</option>
							</select>
						</td>
						<td>所属行业 ：</td>
						<td>
							<%--<INPUT class=textbox id=sChannel2--%>
							<%--style="WIDTH: 180px" maxLength=50 name="cust_industry">--%>
							<select id="cust_industry" name="baseDictIndustry.dict_id">
								<option value="0">--请选择--</option>
							</select>
						</td>
					</TR>

					<TR>


						<td>固定电话 ：</td>
						<td>
							<s:textfield name="cust_phone" theme="simple" cssClass="textbox" cssStyle="WIDTH: 180px"/>
						</td>
						<td>移动电话 ：</td>
						<td>
							<s:textfield name="cust_mobile" theme="simple" cssClass="textbox" cssStyle="WIDTH: 180px"/>
						</td>
					</TR>
					<TR>
						<td>客户资质图片：</td>
						<td colspan="3">
							<input type="file" name="upload"/>
							<s:actionerror/>
							<s:fielderror></s:fielderror>
						</td>
					</TR>
					<s:hidden name="cust_id"/>
					<s:hidden name="cust_image"/>

					<tr>
						<td rowspan=2>
							<INPUT class=button id=sButton2 type=submit
								   value=" 保存 " name=sButton2>
						</td>
					</tr>
				</TABLE>

			</TD>
			<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
				<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
		</TR>
		</TBODY>
	</TABLE>
	<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
		<TBODY>
		<TR>
			<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
							  border=0></TD>
			<TD align=middle width="100%"
				background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
			<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
							  border=0></TD>
		</TR>
		</TBODY>
	</TABLE>
</s:form>
</BODY>
</HTML>
