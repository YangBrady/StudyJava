<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>


<a href="${pageContext.request.contextPath}/frame/spring/demo/mvc/ok">消息页</a><br>


<h3>只允许GET请求</h3>
<form action="${pageContext.request.contextPath}/frame/spring/demo/mvc/justGet" method="get">
    <input type="submit" value="提交">
</form>


<h3>只允许Post请求</h3>
<form action="${pageContext.request.contextPath}/frame/spring/demo/mvc/justPost" method="post">
    <input type="submit" value="提交">
</form>


<h3>接收JavaBean</h3>
<form action="${pageContext.request.contextPath}/frame/spring/demo/mvc/receiveByJavaBean" method="post">
    <label>编号: <input type="text" name="id"/></label><br>
    <label>用户名: <input type="text" name="username"/></label><br>
    <input type="submit" value="提交">
</form>


<h3>获取url上的参数</h3>
<form action="${pageContext.request.contextPath}/frame/spring/demo/mvc/receiveUrlParam/222" method="post">
    <input type="submit" value="提交">
</form>


<h3>接收数组</h3>
<form action="${pageContext.request.contextPath}/frame/spring/demo/mvc/receiveArray" method="post">
    <label>编号: <input type="text" name="id"/></label><br>
    <label>用户名: <input type="text" name="username"/></label><br>
    <label>爱好</label>
    <label><input type="checkbox" name="hobby" value="1">篮球</label>
    <label><input type="checkbox" name="hobby" value="2">足球</label>
    <label><input type="checkbox" name="hobby" value="3">排球</label>
    <label><input type="checkbox" name="hobby" value="4">羽毛球</label>
    <input type="submit" value="提交">
</form>


<h3>接收数组</h3>
<form action="${pageContext.request.contextPath}/frame/spring/demo/mvc/receiveList" method="post">
    <label>用户1</label><br>
    <label><input type="text" name="users[0].id" value="1"/></label>
    <label><input type="text" name="users[0].username" value="哼哼"/></label><br>
    <label>用户2</label><br>
    <label><input type="text" name="users[1].id" value="2"/></label>
    <label><input type="text" name="users[1].username" value="哈哈"/></label><br>
    <label>用户3</label><br>
    <label><input type="text" name="users[2].id" value="3"/></label>
    <label><input type="text" name="users[2].username" value="嘿嘿"/></label><br>
    <label>用户4</label><br>
    <label><input type="text" name="users[3].id" value="4"/></label>
    <label><input type="text" name="users[3].username" value="嘻嘻"/></label><br>
    <label>用户5</label><br>
    <label><input type="text" name="users[4].id" value="5"/></label>
    <label><input type="text" name="users[4].username" value="略略"/></label><br>
    <label><input type="submit" value="提交"/></label>
</form>


<h3>RequestParam注解</h3>
<form action="${pageContext.request.contextPath}/frame/spring/demo/mvc/requestParam" method="post">
    <label>用户名: <input type="text" name="name"/></label><br>
    <label>性别: <input type="text" name="sex"/></label><br>
    <input type="submit" value="提交">
</form>


<h3>ModelAttribute注解 - 放在参数上</h3>
<form action="${pageContext.request.contextPath}/frame/spring/demo/mvc/modelAttributeAtParam" method="post">
    <label>编号: <input type="text" name="id"/></label><br>
    <label>用户名: <input type="text" name="username"/></label><br>
    <input type="submit" value="提交">
</form>


<h3>ModelAttribute注解 - 放在方法上</h3>
<form action="${pageContext.request.contextPath}/frame/spring/demo/mvc/modelAttributeAtFunction" method="post">
    <input type="submit" value="提交">
</form>


<h3>使用InitBinder来处理Date类型的参数</h3>
<form action="${pageContext.request.contextPath}/frame/spring/demo/mvc/str2date" method="post">
    <label>食物名称: <input type="text" name="username" value="哈哈"/></label><br>
    <label>季节: <input type="text" name="season" value="春"/></label><br>
    <label>生产日期: <input type="text" name="productDate" value="2019-02-26"/></label><br>
    <input type="submit" value="提交">
</form>


<h3>文件上传</h3>
<form action="${pageContext.request.contextPath}/frame/spring/demo/mvc/upload" method="post"
      enctype="multipart/form-data">
    <input type="file" name="file"><br>
    <input type="submit" value="提交">
</form>


<h3>ExceptionHandler注解</h3>
<form action="${pageContext.request.contextPath}/frame/spring/demo/mvc/exceptionHandlerTest" method="post">
    <input type="submit" value="提交">
</form>


<h3>转发</h3>
<form action="${pageContext.request.contextPath}/frame/spring/demo/mvc/forward1" method="post">
    <label>消息: <input type="text" name="message"/></label><br>
    <input type="submit" value="提交1">
</form>
<form action="${pageContext.request.contextPath}/frame/spring/demo/mvc/forward2" method="post">
    <label>消息: <input type="text" name="message"/></label><br>
    <input type="submit" value="提交2">
</form>


<h3>重定向</h3>
<form action="${pageContext.request.contextPath}/frame/spring/demo/mvc/redirect1" method="post">
    <input type="submit" value="提交1">
</form>
<form action="${pageContext.request.contextPath}/frame/spring/demo/mvc/redirect2" method="post">
    <input type="submit" value="提交2">
</form>


</body>
</html>
