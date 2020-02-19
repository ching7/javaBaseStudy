<%--
  Created by IntelliJ IDEA.
  User: hspcadmin
  Date: 2019/8/3
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>图片验证码</title>
  </head>
  <script type="text/javascript">
    window.onload=function () {
      let  freshValidCode = document.getElementById("freshValidCode");
      freshValidCode.addEventListener("click", function () {
        let img = document.getElementById("vlidCodeImg");
        img.src = "validCode?"+new Date();//解决浏览器缓存问题
        return false;//防止a标签跳转
      })
    }
  </script>
  <body>
  <form action="" method="post">
    用户名：<input type="text" name="username"><br>
    密码：<input type="text" name="password"><br>
    验证码：<input type="text" size="1"><img id ="vlidCodeImg" width="80" height="40" src="validCode" alt=""><span id="freshValidCode" href="" style="cursor: pointer;">看不清 </span><br>
    <input type="button" value="提交"/>
    <input type="button" value="重置"/>
  </form>
  </body>
</html>
