package com.bingchunmoli.Dao;

import com.bingchunmoli.Obj.User;
import com.bingchunmoli.Obj.Userimage;
import com.bingchunmoli.Util.Ajax;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ProjectName: [${project_name}]
 * @Package: [${package_name}.${file_name}]
 * @ClassName: [${type_name}]
 * @Description: [一句话描述该类的功能]
 * @Author: [${user}]
 * @CreateDate: [${date} ${time}]
 * @UpdateUser: [${user}]
 * @UpdateDate: [${date} ${time}]
 * @UpdateRemark: [说明本次修改内容]
 */
@WebServlet(name = "Image",urlPatterns = "/image")
public class Image extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        Object session1 = session.getAttribute("User");
        if (session1 != null){
            User u = new User();
            Integer uid = (Integer) session1;
            u.setUID(uid);
            Userimage userimage = new Userimage();
            Searchimage searchimage = new Searchimage();
            userimage = searchimage.search(uid);
            Ajax.Ajax(userimage,response);
        }else{
            out.print("<!--\n" +
                    " * @Author: your name\n" +
                    " * @Date: 2020-01-11 00:52:18\n" +
                    " * @LastEditTime : 2020-01-11 00:54:04\n" +
                    " * @LastEditors  : Please set LastEditors\n" +
                    " * @Description: In User Settings Edit\n" +
                    " * @FilePath: \\undefinedd:\\Github\\Biyesheji\\web\\page\\b\\boos.html\n" +
                    " -->\n" +
                    "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "\n" +
                    "    <head>\n" +
                    "\n" +
                    "        <meta charset=\"utf-8\">\n" +
                    "        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                    "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                    "        <title>Bootstrap Modal Registration Form Template</title>\n" +
                    "\n" +
                    "        <!-- CSS -->\n" +
                    "        <link rel=\"stylesheet\" href=\"http://fonts.googleapis.com/css?family=Roboto:400,100,300,500\">\n" +
                    "        <link rel=\"stylesheet\" href=\"/css/b.min.css\">\n" +
                    "\t\t<link rel=\"stylesheet\" href=\"/css/form-elements.css\">\n" +
                    "        <link rel=\"stylesheet\" href=\"/css/style.css\">\n" +
                    "\n" +
                    "    \n" +
                    "\n" +
                    "        <!-- Favicon and touch icons -->\n" +
                    "        <link rel=\"shortcut icon\" href=\"assets/ico/favicon.png\">\n" +
                    "\n" +
                    "    </head>\n" +
                    "\n" +
                    "    <body>\n" +
                    "\n" +
                    "        <!-- Content -->\n" +
                    "        <div class=\"top-content\">\n" +
                    "        \t\n" +
                    "            <div class=\"inner-bg\">\n" +
                    "                <div class=\"container\">\n" +
                    "                    <div class=\"row\">\n" +
                    "                        <div class=\"col-sm-8 col-sm-offset-2 text\">\n" +
                    "                        \t<a class=\"logo\" href=\"index.html\"></a>\n" +
                    "                            <h1><strong>请登录</strong></h1>\n" +
                    "                            <div class=\"description\">\n" +
                    "                            \t<p>\n" +
                    "\t                            \t页面三秒后跳转或点击跳转登录<a href=\"/page/login/login.html\"></a>\n" +
                    "                            \t</p>\n" +
                    "                            </div>\n" +
                    "                            <div class=\"top-big-link\">\n" +
                    "                            \t<a class=\"btn btn-link-1 launch-modal\" href=\"/index.html\" data-modal-id=\"modal-register\">返回主页</a>\n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "            </div>\n" +
                    "            \n" +
                    "        </div>\n" +
                    "        \n" +
                    "        <!-- MODAL -->\n" +
                    "       \n" +
                    "\n" +
                    "\n" +
                    "        <!-- Javascript -->\n" +
                    "        <script src=\"/js/jquery-1.11.1.min.js\"></script>\n" +
                    "        <script src=\"/js/bootstrap.min.js\"></script>\n" +
                    "        <script src=\"/js/jquery.backstretch.min.js\"></script>\n" +
                    "        <script src=\"/js/scripts.js\"></script>\n" +
                    "        \n"+
                    "        <!--[if lt IE 10]>\n" +
                    "            <script src=\"assets/js/placeholder.js\"></script>\n" +
                    "        <![endif]-->\n" +
                    "\t<script>\n" +
                    "        window.onload=function(){\n" +
                    "            window.setTimeout(function () {\n" +
                    "                window.location.href='/page/login/login.html'\n" +
                    "            },3000);\n" +
                    "        }\n" +
                    "\t</script>"+
                    "    </body>\n" +
                    "\n" +
                    "</html>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("请重新打开页面");
    }
}
